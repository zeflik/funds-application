package pl.jozefniemiec.funds.service;

import pl.jozefniemiec.funds.model.Fund;
import pl.jozefniemiec.funds.model.FundAndAmount;
import pl.jozefniemiec.funds.model.FundType;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FundsDistributor {

    private final PercentCalculator percentCalculator;
    private final AmountAssigner amountAssigner;

    @Inject
    public FundsDistributor(PercentCalculator percentCalculator, AmountAssigner amountAssigner) {
        this.percentCalculator = percentCalculator;
        this.amountAssigner = amountAssigner;
    }

    public List<FundAndAmount> distributeAmountsPerFundType(Map<FundType, Integer> fundTypesPercentages,
                                                            int totalAmount,
                                                            List<Fund> funds) {
        List<FundAndAmount> fundsAndAmounts = new ArrayList<>();
        fundTypesPercentages.forEach((fundType, percent) -> {
            int amountForFundType = percentCalculator.calculatePercent(percent, totalAmount);
            fundsAndAmounts.addAll(
                    amountAssigner.assignAmountToFunds(amountForFundType, findFundsByType(funds, fundType))
            );
        });
        return fundsAndAmounts;
    }

    public List<Fund> findFundsByType(List<Fund> funds, FundType fundType) {
        return funds.stream()
                .filter(fund -> fund.getType() == fundType)
                .collect(Collectors.toList());
    }

}

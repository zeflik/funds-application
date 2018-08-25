package pl.jozefniemiec.funds.service;

import pl.jozefniemiec.funds.model.Fund;
import pl.jozefniemiec.funds.model.FundAndAmount;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class AmountAssigner {

    @Inject
    public AmountAssigner() {
    }

    public List<FundAndAmount> assignAmountToFunds(int amountForDistribution, List<Fund> funds) {

        int singleAmount = amountForDistribution / funds.size();
        int remainingAmount = amountForDistribution % funds.size();

        List<FundAndAmount> fundsAndAmounts = funds.stream()
                .map(fund -> new FundAndAmount(fund, singleAmount))
                .collect(Collectors.toList());

        if (remainingAmount > 0)
            fundsAndAmounts.stream()
                    .findFirst()
                    .ifPresent(fundAndAmount -> fundAndAmount.setAmount(singleAmount + remainingAmount));

        return fundsAndAmounts;
    }
}

package pl.jozefniemiec.funds.service;

import pl.jozefniemiec.funds.model.FundAndAmount;

import javax.inject.Inject;
import java.util.List;

public class PercentManager {

    private final PercentFormatter percentFormatter;
    private final PercentCalculator percentCalculator;

    @Inject
    public PercentManager(PercentFormatter percentFormatter, PercentCalculator percentCalculator) {
        this.percentFormatter = percentFormatter;
        this.percentCalculator = percentCalculator;
    }

    public List<FundAndAmount> calculatePercentValues(List<FundAndAmount> fundsAndAmounts, int totalAmount) {
        fundsAndAmounts.forEach(fundAndAmount ->
                fundAndAmount.setPercent(
                        percentFormatter.format(
                                percentCalculator.findPercent(fundAndAmount.getAmount(), totalAmount)
                        )
                )
        );
        return fundsAndAmounts;
    }
}

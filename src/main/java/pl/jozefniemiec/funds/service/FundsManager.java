package pl.jozefniemiec.funds.service;


import pl.jozefniemiec.funds.model.Fund;
import pl.jozefniemiec.funds.model.FundAndAmount;
import pl.jozefniemiec.funds.model.FundType;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

public class FundsManager {

    private final FundsDistributor fundsDistributor;
    private final RemainingAmountManager remainingAmountManager;
    private final ResultGenerator resultGenerator;
    private final PercentManager percentManager;

    @Inject
    public FundsManager(FundsDistributor fundsDistributor,
                        RemainingAmountManager remainingAmountManager,
                        ResultGenerator resultGenerator,
                        PercentManager percentManager) {
        this.fundsDistributor = fundsDistributor;
        this.remainingAmountManager = remainingAmountManager;
        this.resultGenerator = resultGenerator;
        this.percentManager = percentManager;
    }

    public Object assignAmountsToFundsByPercentages(Map<FundType, Integer> fundTypesPercentages,
                                                    int totalAmount,
                                                    List<Fund> funds) {
        List<FundAndAmount> fundsAndAmounts =
                fundsDistributor.distributeAmountsPerFundType(fundTypesPercentages, totalAmount, funds);
        fundsAndAmounts = percentManager.calculatePercentValues(fundsAndAmounts, totalAmount);
        int remainingAmount = remainingAmountManager.findRemainingAmount(fundsAndAmounts, totalAmount);
        return resultGenerator.formatResult(fundsAndAmounts, remainingAmount);
    }
}

package pl.jozefniemiec.funds;

import pl.jozefniemiec.funds.dagger.DaggerFundsManagerComponent;
import pl.jozefniemiec.funds.dagger.FundsManagerComponent;
import pl.jozefniemiec.funds.model.Fund;
import pl.jozefniemiec.funds.service.FundsManager;
import pl.jozefniemiec.funds.strategies.Strategy;

import java.util.List;

public class FundsApplication {

    private final Strategy strategy;
    private final FundsManager fundsManager;

    public FundsApplication(Strategy strategy) {
        this.strategy = strategy;
        FundsManagerComponent fundsManagerComponent = DaggerFundsManagerComponent.create();
        fundsManager = fundsManagerComponent.getFundsManager();
    }

    public Object calculateAndAssignAmountsToFunds(int totalAmount, List<Fund> funds) {
        return fundsManager.assignAmountsToFundsByPercentages(strategy.getFundTypePercentages(), totalAmount, funds);
    }
}

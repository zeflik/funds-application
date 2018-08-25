package pl.jozefniemiec.funds.strategies;

import pl.jozefniemiec.funds.model.FundType;

import java.util.LinkedHashMap;
import java.util.Map;

public class BalancedStrategy implements Strategy {

    private final Map<FundType, Integer> fundTypePercentages = new LinkedHashMap<>();

    public BalancedStrategy() {
        this.fundTypePercentages.put(FundType.POLISH, 30);
        this.fundTypePercentages.put(FundType.FOREIGN, 60);
        this.fundTypePercentages.put(FundType.MONETARY, 10);
    }

    @Override
    public Map<FundType, Integer> getFundTypePercentages() {
        return fundTypePercentages;
    }
}

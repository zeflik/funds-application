package pl.jozefniemiec.funds.strategies;


import pl.jozefniemiec.funds.model.FundType;

import java.util.LinkedHashMap;
import java.util.Map;

public class SafetyStrategy implements Strategy {

    private final Map<FundType, Integer> fundTypePercentages = new LinkedHashMap<>();

    public SafetyStrategy() {
        this.fundTypePercentages.put(FundType.POLISH, 20);
        this.fundTypePercentages.put(FundType.FOREIGN, 75);
        this.fundTypePercentages.put(FundType.MONETARY, 5);
    }

    @Override
    public Map<FundType, Integer> getFundTypePercentages() {
        return fundTypePercentages;
    }
}

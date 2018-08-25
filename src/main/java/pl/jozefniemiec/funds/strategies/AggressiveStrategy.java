package pl.jozefniemiec.funds.strategies;

import pl.jozefniemiec.funds.model.FundType;

import java.util.LinkedHashMap;
import java.util.Map;

public class AggressiveStrategy implements Strategy {


    private final Map<FundType, Integer> fundTypePercentages = new LinkedHashMap<>();

    public AggressiveStrategy() {
        this.fundTypePercentages.put(FundType.POLISH, 40);
        this.fundTypePercentages.put(FundType.FOREIGN, 20);
        this.fundTypePercentages.put(FundType.MONETARY, 40);
    }

    @Override
    public Map<FundType, Integer> getFundTypePercentages() {
        return fundTypePercentages;
    }
}

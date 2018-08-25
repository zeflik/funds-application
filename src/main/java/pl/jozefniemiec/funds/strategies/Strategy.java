package pl.jozefniemiec.funds.strategies;

import pl.jozefniemiec.funds.model.FundType;

import java.util.Map;

public interface Strategy {

    Map<FundType, Integer> getFundTypePercentages();
}

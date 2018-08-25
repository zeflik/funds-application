package pl.jozefniemiec.funds.strategies;

import org.junit.Test;
import pl.jozefniemiec.funds.model.FundType;

import java.util.Map;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class StrategiesTest {

    @Test
    public void getFundTypePercentages_ShouldDeliverMapOfFundTypeAndPercentages() {
        assertNotNull(new SafetyStrategy().getFundTypePercentages());
        assertNotNull(new AggressiveStrategy().getFundTypePercentages());
        assertNotNull(new BalancedStrategy().getFundTypePercentages());
    }

    @Test
    public void getFundTypePercentages_MapOfFundTypeAndPercentages_SumOfThePercentagesShouldNotExceed100() {
        assertTrue(sumPercentages(new SafetyStrategy().getFundTypePercentages()) <= 100);
        assertTrue(sumPercentages(new AggressiveStrategy().getFundTypePercentages()) <= 100);
        assertTrue(sumPercentages(new BalancedStrategy().getFundTypePercentages()) <= 100);
    }

    private int sumPercentages(Map<FundType, Integer> fundTypePercentages) {
        return fundTypePercentages.values().stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
package pl.jozefniemiec.funds.service;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PercentCalculatorTest {

    @Test
    public void calculatePercent_AmountAndPercentage_ShouldReturnNumberByPercentage() {
        PercentCalculator percentCalculator = new PercentCalculator();
        int result = percentCalculator.calculatePercent(10, 50);
        assertEquals(5, result);
    }

    @Test
    public void findPercent_AmountAndTotalAmount_ShouldReturnPercentageOfTheAmount() {
        PercentCalculator percentCalculator = new PercentCalculator();
        float result = percentCalculator.findPercent(33.5555f, 100);
        assertEquals(33.5555f, result, 0.00001);
    }
}
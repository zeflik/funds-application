package pl.jozefniemiec.funds.service;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class PercentageFormatterTest {

    @Test
    public void format_FloatNumber_ShouldRoundToHundredthsHalfEven() {
        PercentFormatter percentFormatter = new PercentFormatter();
        BigDecimal roundedDigit1 = percentFormatter.format(9.9851f);
        BigDecimal roundedDigit2 = percentFormatter.format(9.9850f);
        assertEquals(new BigDecimal("9.99"), roundedDigit1);
        assertEquals(new BigDecimal("9.98"), roundedDigit2);
    }

    @Test
    public void format_FloatNumber_ShouldRemoveTrailingZeros() {
        PercentFormatter percentFormatter = new PercentFormatter();
        BigDecimal roundedDigit1 = percentFormatter.format(9.9f);
        BigDecimal roundedDigit2 = percentFormatter.format(9f);
        assertEquals(new BigDecimal("9.9"), roundedDigit1);
        assertEquals(new BigDecimal("9"), roundedDigit2);
    }
}
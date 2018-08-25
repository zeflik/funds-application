package pl.jozefniemiec.funds.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pl.jozefniemiec.funds.model.FundAndAmount;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyFloat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

public class PercentManagerTest {

    @Mock
    private PercentFormatter percentFormatter;

    @Mock
    private PercentCalculator percentCalculator;

    @InjectMocks
    private PercentManager percentManager;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void calculateAndSetPercentValue_FundsAndAmountsListAndTotalAmount_ShouldReturnAmountsAndFundsWithCalculatedPercentValue() {
        FundAndAmount[] fundsAndAmountsArray = {
                new FundAndAmount(null, 1000),
                new FundAndAmount(null, 1000),
                new FundAndAmount(null, 1000)};
        ArrayList<FundAndAmount> fundsAndAmounts = new ArrayList<>(Arrays.asList(fundsAndAmountsArray));
        when(percentCalculator.calculatePercent(anyInt(), anyInt())).thenReturn(33);
        BigDecimal bigDecimal = new BigDecimal("33");
        when(percentFormatter.format(anyFloat())).thenReturn(bigDecimal);
        List<FundAndAmount> resultFundAndAmounts = percentManager.calculatePercentValues(fundsAndAmounts, 10000);
        assertEquals(bigDecimal, resultFundAndAmounts.get(0).getPercent());
    }
}
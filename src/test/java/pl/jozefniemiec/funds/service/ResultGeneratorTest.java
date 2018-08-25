package pl.jozefniemiec.funds.service;

import org.junit.Before;
import org.junit.Test;
import pl.jozefniemiec.funds.model.Fund;
import pl.jozefniemiec.funds.model.FundAndAmount;
import pl.jozefniemiec.funds.model.FundType;
import pl.jozefniemiec.funds.model.Result;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ResultGeneratorTest {

    private List<FundAndAmount> fundsAndAmounts;
    private int remainingAmount;

    @Before
    public void setUp() {
        Fund[] fundsArray = {
                new Fund(1, "Fundusz Polski 1", FundType.POLISH),
                new Fund(2, "Fundusz Zagraniczny 1", FundType.FOREIGN),
                new Fund(3, "Fundusz Pieniężny 1", FundType.MONETARY)};

        FundAndAmount[] fundsAndAmountsArray = {
                new FundAndAmount(fundsArray[0], 500),
                new FundAndAmount(fundsArray[1], 1000),
                new FundAndAmount(fundsArray[2], 1500)};

        fundsAndAmounts = new ArrayList<>(Arrays.asList(fundsAndAmountsArray));
        remainingAmount = 5;
    }

    @Test
    public void formatResult_ListOfFundsAndAmountsAndRemainingAmount_ShouldReturnResultObject() {
        ResultGenerator resultGenerator = new ResultGenerator();
        Result result = resultGenerator.formatResult(fundsAndAmounts, remainingAmount);
        assertEquals(remainingAmount, result.getRemainingAmount());
        assertEquals(fundsAndAmounts, result.getFundAndAmounts());
    }
}
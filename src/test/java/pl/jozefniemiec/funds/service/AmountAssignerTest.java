package pl.jozefniemiec.funds.service;

import org.junit.Test;
import pl.jozefniemiec.funds.model.Fund;
import pl.jozefniemiec.funds.model.FundAndAmount;
import pl.jozefniemiec.funds.model.FundType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AmountAssignerTest {


    @Test
    public void assignAmountToFunds_AmountForDistributionAndFundsList_ShouldReturnFundAndAmountList() {
        Fund[] fundArray = {
                new Fund(1, "Fundusz Polski 1", FundType.POLISH),
                new Fund(2, "Fundusz Polski 2", FundType.POLISH),
                new Fund(3, "Fundusz Polski 3", FundType.POLISH)
        };
        AmountAssigner amountAssigner = new AmountAssigner();
        List<Fund> funds = new ArrayList<>(Arrays.asList(fundArray));
        List<FundAndAmount> expectedFundAndAmounts = new ArrayList<>();
        expectedFundAndAmounts.add(new FundAndAmount(funds.get(0), 2001));
        expectedFundAndAmounts.add(new FundAndAmount(funds.get(1), 2000));
        expectedFundAndAmounts.add(new FundAndAmount(funds.get(2), 2000));
        List<FundAndAmount> fundsAndAmounts = amountAssigner.assignAmountToFunds(6001, funds);
        assertEquals(expectedFundAndAmounts, fundsAndAmounts);
    }
}
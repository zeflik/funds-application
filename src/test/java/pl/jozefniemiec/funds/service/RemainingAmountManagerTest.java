package pl.jozefniemiec.funds.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.jozefniemiec.funds.model.FundAndAmount;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemainingAmountManagerTest {

    private RemainingAmountManager remainingAmountManager;
    private int totalAmount;
    private int remainingAmount;
    private List<FundAndAmount> fundsAndAmounts;

    @Before
    public void setUp() {
        remainingAmountManager = new RemainingAmountManager();

        totalAmount = 10001;
        int amountAssigned1 = 1000;
        int amountAssigned2 = 2000;
        int amountAssigned3 = 7000;
        remainingAmount = 1;

        FundAndAmount[] fundsAndAmountsArray = {
                new FundAndAmount(null, amountAssigned1),
                new FundAndAmount(null, amountAssigned2),
                new FundAndAmount(null, amountAssigned3)};

        fundsAndAmounts = new ArrayList<>(Arrays.asList(fundsAndAmountsArray));
    }

    @Test
    public void findRemainingAmount_TotalAmountAndListOfFundsAndAmounts_ShouldReturnNotAssignedAmount() {
        int remainingAmount = remainingAmountManager.findRemainingAmount(fundsAndAmounts, totalAmount);
        Assert.assertEquals(this.remainingAmount, remainingAmount);
    }
}
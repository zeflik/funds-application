package pl.jozefniemiec.funds.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pl.jozefniemiec.funds.model.Fund;
import pl.jozefniemiec.funds.model.FundAndAmount;
import pl.jozefniemiec.funds.model.FundType;
import pl.jozefniemiec.funds.model.Result;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class FundsManagerTest {

    @Mock
    private FundsDistributor fundsDistributor;

    @Mock
    private RemainingAmountManager remainingAmountManager;

    @Mock
    private ResultGenerator resultGenerator;

    @Mock
    private PercentManager percentManager;

    @InjectMocks
    private FundsManager fundsManager;

    private Map<FundType, Integer> percentages;
    private List<Fund> funds;
    private List<FundAndAmount> fundsAndAmounts;
    private List<FundAndAmount> fundsAndAmountsFiltered;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        percentages = new HashMap<>();

        this.percentages.put(FundType.POLISH, 40);
        this.percentages.put(FundType.FOREIGN, 20);
        this.percentages.put(FundType.MONETARY, 40);

        Fund[] fundArray = {
                new Fund(1, "Fundusz Polski 1", FundType.POLISH),
                new Fund(2, "Fundusz Polski 2", FundType.POLISH),
                new Fund(3, "Fundusz Polski 3", FundType.POLISH),
                new Fund(4, "Fundusz Zagraniczny 1", FundType.FOREIGN),
                new Fund(5, "Fundusz Zagraniczny 2", FundType.FOREIGN),
                new Fund(6, "Fundusz Pieniężny 1", FundType.MONETARY)
        };

        funds = new ArrayList<>(Arrays.asList(fundArray));

        fundsAndAmounts = funds.stream()
                .map(fund -> new FundAndAmount(fund, 1000))
                .collect(Collectors.toList());

        fundsAndAmountsFiltered = fundsAndAmounts.stream()
                .map(fundAndAmount -> new FundAndAmount(fundAndAmount.getFund(), fundAndAmount.getAmount() + 1))
                .collect(Collectors.toList());
    }

    @Test
    public void assignAmountsToFundsByPercentages_InitialData_ShouldDeliverArgumentsToServicesAndReturnResult() {
        int totalAmount = 10000;
        int remainingAmount = 5;
        when(fundsDistributor.distributeAmountsPerFundType(percentages, totalAmount, funds)).thenReturn(fundsAndAmounts);
        when(percentManager.calculatePercentValues(fundsAndAmounts, totalAmount)).thenReturn(fundsAndAmountsFiltered);
        when(remainingAmountManager.findRemainingAmount(fundsAndAmountsFiltered, totalAmount)).thenReturn(remainingAmount);
        Result expectedResult = new Result(fundsAndAmountsFiltered, remainingAmount);
        when(resultGenerator.formatResult(fundsAndAmountsFiltered, remainingAmount)).thenReturn(expectedResult);
        Object result = fundsManager.assignAmountsToFundsByPercentages(percentages, totalAmount, funds);
        assertEquals(expectedResult, result);
    }
}
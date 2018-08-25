package pl.jozefniemiec.funds.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import pl.jozefniemiec.funds.model.Fund;
import pl.jozefniemiec.funds.model.FundAndAmount;
import pl.jozefniemiec.funds.model.FundType;

import java.util.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.any;

public class FundsDistributorTest {

    @Mock
    private PercentCalculator percentCalculator;

    @Mock
    private AmountAssigner amountAssigner;

    @InjectMocks
    private FundsDistributor fundsDistributor;

    private ArrayList<Fund> funds = new ArrayList<>();
    private ArrayList<FundAndAmount> fundsAndAmounts = new ArrayList<>();
    private Map<FundType, Integer> percentages = new HashMap<>();

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        this.percentages.put(FundType.POLISH, 20);
        this.percentages.put(FundType.FOREIGN, 75);
        this.percentages.put(FundType.MONETARY, 5);

        Fund[] fundArray = {
                new Fund(1, "Fundusz Polski 1", FundType.POLISH),
                new Fund(2, "Fundusz Polski 2", FundType.POLISH),
                new Fund(3, "Fundusz Polski 3", FundType.POLISH),
                new Fund(4, "Fundusz Zagraniczny 1", FundType.FOREIGN),
                new Fund(5, "Fundusz Zagraniczny 2", FundType.FOREIGN),
                new Fund(6, "Fundusz Pieniężny 1", FundType.MONETARY)
        };

        funds.addAll(Arrays.asList(fundArray));

        FundAndAmount[] fundsAndAmountsArray = {
                new FundAndAmount(fundArray[0], 2500),
                new FundAndAmount(fundArray[3], 2500),
                new FundAndAmount(fundArray[5], 5000)};

        fundsAndAmounts.addAll(Arrays.asList(fundsAndAmountsArray));
    }

    @Test
    public void distributeAmounts_ApplicationInitialData_ShouldDistributeDataPerEveryFundType() {
        int totalAmount = 10000;
        InOrder order = Mockito.inOrder(percentCalculator, amountAssigner);
        fundsDistributor.distributeAmountsPerFundType(percentages, totalAmount, funds);
        for (int i = 0; i < percentages.size(); i++) {
            order.verify(percentCalculator).calculatePercent(anyInt(), anyInt());
            order.verify(amountAssigner).assignAmountToFunds(anyInt(), any());
        }
    }

    @Test
    public void findFundsByType_FundsListAndFundType_ShouldReturnFundsListByGivenType() {
        List<Fund> fundsByType = fundsDistributor.findFundsByType(funds, FundType.MONETARY);
        assertTrue(fundsByType.contains(funds.get(5)));
        assertFalse(fundsByType.contains(funds.get(0)));
        assertFalse(fundsByType.contains(funds.get(3)));
    }
}
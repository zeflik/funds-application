package pl.jozefniemiec.funds;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import pl.jozefniemiec.funds.model.Fund;
import pl.jozefniemiec.funds.model.FundAndAmount;
import pl.jozefniemiec.funds.model.FundType;
import pl.jozefniemiec.funds.model.Result;
import pl.jozefniemiec.funds.strategies.SafetyStrategy;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FundsApplicationIntegrationTest {

    private List<Fund> example1FundsList = new ArrayList<>();
    private List<FundAndAmount> example1AmountsAndFundsList = new ArrayList<>();
    private List<Fund> example2FundsList = new ArrayList<>();
    private List<FundAndAmount> example2AmountsAndFundsList = new ArrayList<>();
    private Result example1ExpectedResult;
    private Result example2ExpectedResult;

    @Before
    public void setUp() {
        example1FundsList.addAll(
                Arrays.asList(
                        new Fund(1, "Fundusz Polski 1", FundType.POLISH),
                        new Fund(2, "Fundusz Polski 2", FundType.POLISH),
                        new Fund(3, "Fundusz Zagraniczny 1", FundType.FOREIGN),
                        new Fund(4, "Fundusz Zagraniczny 2", FundType.FOREIGN),
                        new Fund(5, "Fundusz Zagraniczny 3", FundType.FOREIGN),
                        new Fund(6, "Fundusz Pieniężny 1", FundType.MONETARY)
                )
        );
        example1AmountsAndFundsList.addAll(
                Arrays.asList(
                        new FundAndAmount(example1FundsList.get(0), 1000, new BigDecimal("10")),
                        new FundAndAmount(example1FundsList.get(1), 1000, new BigDecimal("10")),
                        new FundAndAmount(example1FundsList.get(2), 2500, new BigDecimal("25")),
                        new FundAndAmount(example1FundsList.get(3), 2500, new BigDecimal("25")),
                        new FundAndAmount(example1FundsList.get(4), 2500, new BigDecimal("25")),
                        new FundAndAmount(example1FundsList.get(5), 500, new BigDecimal("5"))
                )
        );
        example1ExpectedResult = new Result(example1AmountsAndFundsList, 1);

        example2FundsList.addAll(
                Arrays.asList(
                        new Fund(1, "Fundusz Polski 1", FundType.POLISH),
                        new Fund(2, "Fundusz Polski 2", FundType.POLISH),
                        new Fund(3, "Fundusz Polski 3", FundType.POLISH),
                        new Fund(4, "Fundusz Zagraniczny 1", FundType.FOREIGN),
                        new Fund(5, "Fundusz Zagraniczny 2", FundType.FOREIGN),
                        new Fund(6, "Fundusz Pieniężny 1", FundType.MONETARY)
                )
        );
        example2AmountsAndFundsList.addAll(
                Arrays.asList(
                        new FundAndAmount(example2FundsList.get(0), 668, new BigDecimal("6.68")),
                        new FundAndAmount(example2FundsList.get(1), 666, new BigDecimal("6.66")),
                        new FundAndAmount(example2FundsList.get(2), 666, new BigDecimal("6.66")),
                        new FundAndAmount(example2FundsList.get(3), 3750, new BigDecimal("37.5")),
                        new FundAndAmount(example2FundsList.get(4), 3750, new BigDecimal("37.5")),
                        new FundAndAmount(example2FundsList.get(5), 500, new BigDecimal("5"))
                )
        );
        example2ExpectedResult = new Result(example2AmountsAndFundsList, 0);
    }

    @Ignore
    @Test
    public void example1IntegrationTest() {
        Object example1result = new FundsApplication(new SafetyStrategy())
                .calculateAndAssignAmountsToFunds(10001, example1FundsList);
        Assert.assertEquals(example1ExpectedResult, example1result);
    }

    @Ignore
    @Test
    public void example2IntegrationTest() {
        Object example2result = new FundsApplication(new SafetyStrategy())
                .calculateAndAssignAmountsToFunds(10000, example2FundsList);
        Assert.assertEquals(example2ExpectedResult, example2result);
    }
}
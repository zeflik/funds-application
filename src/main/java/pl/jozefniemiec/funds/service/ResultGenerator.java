package pl.jozefniemiec.funds.service;

import pl.jozefniemiec.funds.model.FundAndAmount;
import pl.jozefniemiec.funds.model.Result;

import javax.inject.Inject;
import java.util.List;

public class ResultGenerator implements ResultFormatter {

    @Inject
    public ResultGenerator() {
    }

    public Result formatResult(List<FundAndAmount> fundsAndAmounts, int remainingAmount) {
        return new Result(fundsAndAmounts, remainingAmount);
    }
}

package pl.jozefniemiec.funds.service;

import pl.jozefniemiec.funds.model.FundAndAmount;

import java.util.List;

public interface ResultFormatter {

    Object formatResult(List<FundAndAmount> fundsAndAmounts, int remainingAmount);
}

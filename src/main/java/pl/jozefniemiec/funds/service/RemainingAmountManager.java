package pl.jozefniemiec.funds.service;

import pl.jozefniemiec.funds.model.FundAndAmount;

import javax.inject.Inject;
import java.util.List;

public class RemainingAmountManager {

    @Inject
    public RemainingAmountManager() {
    }

    public int findRemainingAmount(List<FundAndAmount> fundsAndAmounts, int totalAmount) {
        return totalAmount - fundsAndAmounts.stream()
                .mapToInt(FundAndAmount::getAmount)
                .sum();
    }
}

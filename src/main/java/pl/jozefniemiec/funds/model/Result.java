package pl.jozefniemiec.funds.model;

import java.util.List;
import java.util.Objects;

public class Result {

    private List<FundAndAmount> fundsAndAmounts;
    private int remainingAmount;

    public Result(List<FundAndAmount> fundsAndAmounts, int remainingAmount) {
        this.fundsAndAmounts = fundsAndAmounts;
        this.remainingAmount = remainingAmount;
    }

    public List<FundAndAmount> getFundAndAmounts() {
        return fundsAndAmounts;
    }

    public void setFundAndAmounts(List<FundAndAmount> fundsAndAmounts) {
        this.fundsAndAmounts = fundsAndAmounts;
    }

    public int getRemainingAmount() {
        return remainingAmount;
    }

    public void setRemainingAmount(int remainingAmount) {
        this.remainingAmount = remainingAmount;
    }

    @Override
    public String toString() {
        return "Result{" +
                "fundsAndAmounts=" + fundsAndAmounts +
                ", remainingAmount=" + remainingAmount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result = (Result) o;
        return remainingAmount == result.remainingAmount &&
                Objects.equals(fundsAndAmounts, result.fundsAndAmounts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fundsAndAmounts, remainingAmount);
    }
}

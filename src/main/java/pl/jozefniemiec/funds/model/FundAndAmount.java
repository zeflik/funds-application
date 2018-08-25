package pl.jozefniemiec.funds.model;

import java.math.BigDecimal;
import java.util.Objects;

public class FundAndAmount {

    private Fund fund;
    private int amount;
    private BigDecimal percent;

    public FundAndAmount(Fund fund, int amount) {
        this.fund = fund;
        this.amount = amount;
    }

    public FundAndAmount(Fund fund, int amount, BigDecimal percent) {
        this.fund = fund;
        this.amount = amount;
        this.percent = percent;
    }

    public Fund getFund() {
        return fund;
    }

    public void setFund(Fund fund) {
        this.fund = fund;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public BigDecimal getPercent() {
        return percent;
    }

    public void setPercent(BigDecimal percent) {
        this.percent = percent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FundAndAmount that = (FundAndAmount) o;
        return amount == that.amount &&
                Objects.equals(fund, that.fund) &&
                Objects.equals(percent, that.percent);
    }

    @Override
    public int hashCode() {

        return Objects.hash(fund, amount, percent);
    }

    @Override
    public String toString() {
        return "FundAndAmount{" +
                "fund=" + fund +
                ", amount=" + amount +
                ", percent=" + percent +
                '}';
    }
}

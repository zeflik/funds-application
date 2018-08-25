package pl.jozefniemiec.funds.model;

import java.util.Objects;

public class Fund {

    private int id;
    private String name;
    private FundType type;

    public Fund(int id, String name, FundType type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public FundType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Fund{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fund fund = (Fund) o;
        return id == fund.id &&
                Objects.equals(name, fund.name) &&
                type == fund.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type);
    }
}

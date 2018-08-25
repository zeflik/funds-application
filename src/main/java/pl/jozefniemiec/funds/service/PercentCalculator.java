package pl.jozefniemiec.funds.service;

import javax.inject.Inject;

public class PercentCalculator {

    @Inject
    public PercentCalculator() {
    }

    public float findPercent(float amount, int totalAmount) {
        return amount / totalAmount * 100;
    }

    public int calculatePercent(int percentage, int totalAmount) {
        return (int) ((float) totalAmount / 100 * percentage);
    }
}

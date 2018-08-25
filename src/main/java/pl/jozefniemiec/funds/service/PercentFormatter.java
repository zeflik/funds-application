package pl.jozefniemiec.funds.service;

import javax.inject.Inject;
import java.math.BigDecimal;

public class PercentFormatter {

    @Inject
    public PercentFormatter() {
    }

    public BigDecimal format(float amount) {
        BigDecimal bigDecimalAmount = new BigDecimal(Float.toString(amount));
        return new BigDecimal(
                bigDecimalAmount.setScale(2, BigDecimal.ROUND_HALF_EVEN).stripTrailingZeros().toPlainString()
        );
    }
}



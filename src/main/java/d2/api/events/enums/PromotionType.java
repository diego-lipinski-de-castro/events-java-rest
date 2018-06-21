package d2.api.events.enums;

import java.math.BigDecimal;

public enum PromotionType {

    DAY(new BigDecimal("4.99")),
    WEEK(new BigDecimal("9.99"));

    private BigDecimal price;

    PromotionType(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }
}

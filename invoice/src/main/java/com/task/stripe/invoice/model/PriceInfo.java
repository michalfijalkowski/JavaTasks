package com.task.stripe.invoice.model;

public class PriceInfo {

    private final String productId;
    private final String currency;
    private final int unitAmount;

    public PriceInfo(String productId, String currency, int unitAmount) {
        this.productId = productId;
        this.currency = currency;
        this.unitAmount = unitAmount;
    }

    public String getProductId() {
        return productId;
    }

    public String getCurrency() {
        return currency;
    }

    public int getUnitAmount() {
        return unitAmount;
    }
}

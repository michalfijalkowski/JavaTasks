package com.task.stripe.invoice.model;

public class InvoiceInfo {

    private final String customerId;
    private final String productId;
    private final String currency;
    private final int unitAmount;

    public InvoiceInfo(String customerId, String productId, String currency, int unitAmount){
        this.customerId = customerId;
        this.productId = productId;
        this.currency = currency;
        this.unitAmount = unitAmount;
    }

    public String getCustomerId() {
        return customerId;
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

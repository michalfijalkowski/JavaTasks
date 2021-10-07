package com.task.stripe.invoice.model;

public class ProductInfo {

    private final String name;

    public ProductInfo(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}

package com.task.stripe.invoice.model;

public class CustomerInfo {

    private final String name;
    private final String email;

    public CustomerInfo(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}

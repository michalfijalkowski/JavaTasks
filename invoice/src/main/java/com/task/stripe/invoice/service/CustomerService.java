package com.task.stripe.invoice.service;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Customer;
import com.task.stripe.invoice.model.CustomerInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@Service
public class CustomerService {

    @Value("${stripeApiKey}")
    private String apiKey;

    private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);

    public Customer createCustomer(CustomerInfo customer) throws StripeException {
        logger.info("Request create new customer - customer email: " + customer.getEmail() +
                " Start Time: " + Instant.now());

        Stripe.apiKey = this.apiKey;

        Map<String, Object> params = new HashMap<>();
        params.put("name", customer.getName());
        params.put("email", customer.getEmail());

        return Customer.create(params);
    }

    public Customer getCustomer(String customerId) throws StripeException {
        logger.info("Request get customer by id - customerId: " + customerId +
                " Start Time: " + Instant.now());

        Stripe.apiKey = this.apiKey;

        return Customer.retrieve(customerId);
    }
}

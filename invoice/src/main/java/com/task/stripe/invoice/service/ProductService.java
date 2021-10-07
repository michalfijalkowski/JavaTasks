package com.task.stripe.invoice.service;

import com.stripe.exception.StripeException;
import com.stripe.model.Product;
import com.task.stripe.invoice.model.ProductInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@Service
public class ProductService {

    @Value("${stripeApiKey}")
    private String apiKey;

    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

    public Product createProduct(ProductInfo product) throws StripeException {
        logger.info("Request create new product - product name: " + product.getName() +
                " Start Time: " + Instant.now());

        Map<String, Object> params = new HashMap<>();
        params.put("name", product.getName());

        return Product.create(params);
    }

}

package com.task.stripe.invoice.service;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Price;
import com.task.stripe.invoice.model.PriceInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@Service
public class PriceService {

    @Value("${stripeApiKey}")
    private String apiKey;

    private static final Logger logger = LoggerFactory.getLogger(PriceService.class);

    public Price createPrice(PriceInfo price) throws StripeException {
        logger.info("Request create new price - productId: " + price.getProductId() + " currency: " + price.getCurrency() + " unit amount: " + price.getUnitAmount() +
                " Start Time: " + Instant.now());

        Stripe.apiKey = this.apiKey;

        Map<String, Object> params = new HashMap<>();
        params.put("unit_amount", price.getUnitAmount());
        params.put("currency", price.getCurrency());
        params.put("product", price.getProductId());

        return Price.create(params);
    }
}

package com.task.stripe.invoice;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.*;
import com.stripe.param.InvoiceCreateParams;
import com.stripe.param.InvoiceItemCreateParams;
import com.task.stripe.invoice.model.InvoiceInfo;
import com.task.stripe.invoice.model.PriceInfo;
import com.task.stripe.invoice.model.ProductInfo;
import com.task.stripe.invoice.service.CustomerService;
import com.task.stripe.invoice.service.InvoiceService;
import com.task.stripe.invoice.service.PriceService;
import com.task.stripe.invoice.service.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class InvoiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InvoiceApplication.class, args);
	}

}

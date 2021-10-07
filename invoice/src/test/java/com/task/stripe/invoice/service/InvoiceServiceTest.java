package com.task.stripe.invoice.service;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Customer;
import com.stripe.model.Invoice;
import com.stripe.model.Product;
import com.task.stripe.invoice.model.CustomerInfo;
import com.task.stripe.invoice.model.InvoiceInfo;
import com.task.stripe.invoice.model.ProductInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class InvoiceServiceTest {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProductService productService;

    @Autowired
    private InvoiceService invoiceService;

    @Value("${stripeApiKey}")
    private String apiKey;

    private Customer customer;
    private Product product;

    @BeforeEach
    void setUp() throws StripeException {
        Stripe.apiKey = this.apiKey;

        final ProductInfo productInfo = new ProductInfo("XW.1");
        this.product = productService.createProduct(productInfo);

        final CustomerInfo customerInfo = new CustomerInfo("Michal", "michal@gmail.com");
        this.customer = customerService.createCustomer(customerInfo);
    }

    @Test
    void createdInvoiceShouldBeAvailableToRetrieve() throws StripeException {
        final InvoiceInfo invoiceInfo = new InvoiceInfo(this.customer.getId(), this.product.getId(), "usd", 1000);

        final Invoice invoice = invoiceService.createInvoice(invoiceInfo);

        Assertions.assertEquals(invoice, invoiceService.getInvoice(invoice.getId()), "Creating invoice failed.");
    }

    @Test
    void getListOfCustomersInvoices() throws StripeException {
        final InvoiceInfo invoiceInfo = new InvoiceInfo(this.customer.getId(), this.product.getId(), "usd", 1000);

        final ProductInfo productInfo = new ProductInfo("XW.2");
        final Product product2 = productService.createProduct(productInfo);
        final InvoiceInfo invoiceInfo2 = new InvoiceInfo(this.customer.getId(), product2.getId(), "usd", 1500);

        invoiceService.createInvoice(invoiceInfo);
        invoiceService.createInvoice(invoiceInfo2);

        Assertions.assertEquals(2, invoiceService.getInvoices(this.customer.getId()).size(), "Check count of customer's invoices.");
    }

}
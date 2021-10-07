package com.task.stripe.invoice.service;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Customer;
import com.stripe.model.Invoice;
import com.stripe.model.InvoiceItem;
import com.stripe.model.Price;
import com.stripe.param.InvoiceCreateParams;
import com.stripe.param.InvoiceItemCreateParams;
import com.stripe.param.InvoiceListParams;
import com.task.stripe.invoice.model.InvoiceInfo;
import com.task.stripe.invoice.model.PriceInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class InvoiceService {

    @Value("${stripeApiKey}")
    private String apiKey;

    private final CustomerService customerService;
    private final PriceService priceService;

    private static final Logger logger = LoggerFactory.getLogger(InvoiceService.class);

    @Autowired
    public InvoiceService(CustomerService customerService, PriceService priceService){
        this.customerService = customerService;
        this.priceService = priceService;
    }

    public Invoice createInvoice(InvoiceInfo invoiceInfo) throws StripeException {
        logger.info("Request create new invoice - customerId: " + invoiceInfo.getCustomerId() +
                " Start Time: " + Instant.now());

        Stripe.apiKey = this.apiKey;

        final Customer customer = customerService.getCustomer(invoiceInfo.getCustomerId());
        final Price price = priceService.createPrice(new PriceInfo(invoiceInfo.getProductId(), invoiceInfo.getCurrency(), invoiceInfo.getUnitAmount()));
        final InvoiceItemCreateParams invoiceItemCreateParams = new InvoiceItemCreateParams.Builder().setCustomer(customer.getId()).setPrice(price.getId()).build();
        InvoiceItem.create(invoiceItemCreateParams);

        final InvoiceCreateParams invoiceCreateParams = new InvoiceCreateParams.Builder().setCustomer(customer.getId()).build();

        return  Invoice.create(invoiceCreateParams);
    }

    public List<Invoice> getInvoices(String customerId) throws StripeException {
        logger.info("Request get customer invoices - customerId: " + customerId +
                " Start Time: " + Instant.now());

        final InvoiceListParams invoiceListParams = InvoiceListParams.builder()
                .setCustomer(customerId)
                .build();

        return Invoice.list(invoiceListParams).getData();
    }

    public Invoice getInvoice(String invoiceId) throws StripeException {
        logger.error("Request get invoice by id - invoiceId: " + invoiceId +
                " Start Time: " + Instant.now());

        return Invoice.retrieve(invoiceId);
    }

}

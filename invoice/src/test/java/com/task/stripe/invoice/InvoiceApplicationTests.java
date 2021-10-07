package com.task.stripe.invoice;

import com.stripe.exception.StripeException;
import com.stripe.model.Customer;
import com.task.stripe.invoice.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class InvoiceApplicationTests {

	@Test
	void contextLoads() throws StripeException {
	}

}

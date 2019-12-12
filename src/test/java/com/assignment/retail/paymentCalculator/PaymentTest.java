package com.assignment.retail.paymentCalculator;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import com.assignment.retail.paymentCalculator.beans.DiscountDetails;
import com.assignment.retail.paymentCalculator.beans.PaymentDetails;

public class PaymentTest {
	
	Payment payment = new Payment();
	DiscountDetails discountDetails;
	@Before
	public void initMocks(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void calculateTest(){
		PaymentDetails paymentDetails = new PaymentDetails(990, "N", "Y", "N", "N");
		discountDetails = payment.calculate(paymentDetails);
		assertTrue(discountDetails != null);
	}
	
	@Test
	public void calculateTestFalse(){
		PaymentDetails paymentDetails = new PaymentDetails(0, "N", "Y", "N", "N");
		discountDetails = payment.calculate(paymentDetails);
		assertTrue(discountDetails.getFinalAmount() == 0);
	}
	
}

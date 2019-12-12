package com.assignment.retail.paymentCalculator.handlers;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import com.assignment.retail.paymentCalculator.beans.DiscountDetails;
import com.assignment.retail.paymentCalculator.beans.PaymentDetails;

public class OldCustomerDiscountHandlerTest {


	OldCustomerDiscountHandler oldCustomerDiscountHandler= new OldCustomerDiscountHandler();
	DiscountDetails discountDetails;
	
	@Before
	public void initMocks(){
		MockitoAnnotations.initMocks(this);
	}
	@Test
	public void applyDiscountTest(){
		PaymentDetails paymentDetails = new PaymentDetails(990, "N", "Y", "N", "Y");
		discountDetails = oldCustomerDiscountHandler.applyDiscount(paymentDetails);
		assertTrue(discountDetails!=null);
	}
	
	@Test
	public void isDiscountApplicableTest(){
		PaymentDetails paymentDetails = new PaymentDetails(990, "N", "Y", "N", "Y");
		assertTrue(oldCustomerDiscountHandler.isDiscountApplicable(paymentDetails));
	}
	
	@Test
	public void isDiscountApplicableFalseTest(){
		PaymentDetails paymentDetails = new PaymentDetails(990, "N", "N", "N", "N");
		assertFalse(oldCustomerDiscountHandler.isDiscountApplicable(paymentDetails));
	}


}

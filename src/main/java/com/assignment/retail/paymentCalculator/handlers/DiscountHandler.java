package com.assignment.retail.paymentCalculator.handlers;

import com.assignment.retail.paymentCalculator.beans.DiscountDetails;
import com.assignment.retail.paymentCalculator.beans.PaymentDetails;

public abstract class DiscountHandler {

	DiscountHandler discountHandler;
	DiscountDetails discountDetails = new DiscountDetails();
	public void nextDiscountHandler(DiscountHandler discountHandler) {
		this.discountHandler = discountHandler;
	}

	public abstract DiscountDetails applyDiscount(PaymentDetails paymentDetails);
}

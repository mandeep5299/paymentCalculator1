package com.assignment.retail.paymentCalculator.handlers;

import com.assignment.retail.paymentCalculator.beans.PaymentDetails;

public interface VerifyDiscount {
	public boolean isDiscountApplicable(PaymentDetails paymentDetails);
}

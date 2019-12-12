package com.assignment.retail.paymentCalculator.handlers;

import com.assignment.retail.paymentCalculator.beans.DiscountDetails;
import com.assignment.retail.paymentCalculator.beans.PaymentDetails;
import com.assignment.retail.paymentCalculator.util.CalculateDiscount;
import com.assignment.retail.paymentCalculator.util.Const;

public class OldCustomerDiscountHandler extends DiscountHandler implements VerifyDiscount{
	/*
	 * check if old customer discount is applicable or not.
	 * If applicable, get discounted amount, else pass the request to other price discount handler (price discount).
	 * */
	@Override
	public DiscountDetails applyDiscount(PaymentDetails paymentDetails) {
		if(!isDiscountApplicable(paymentDetails)){
			discountHandler.applyDiscount(paymentDetails);
		}else{
			discountDetails.setDiscountType("Eligible for old customer discount (5%).");
			discountDetails.setFinalAmount(CalculateDiscount.getDiscountPrice(Const.EMPLOYEE_DISCOUNT, paymentDetails.getAmount()));
			//System.out.println("Eligible for old customer discount (5%).");
			//System.out.println("Payable Amt.: "+CalculateDiscount.getDiscountPrice(Const.OLD_CUSTOMER_DISCOUNT, paymentDetails.getAmount()));
		}
		return discountDetails;
	}

	@Override
	public boolean isDiscountApplicable(PaymentDetails paymentDetails) {
		boolean isOldCustomer = false;
		if(paymentDetails.getOldCustomer().equals(Const.YES)){
			isOldCustomer = true;
		}
		return isOldCustomer;
	}
}

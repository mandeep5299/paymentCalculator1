package com.assignment.retail.paymentCalculator.handlers;

import com.assignment.retail.paymentCalculator.beans.DiscountDetails;
import com.assignment.retail.paymentCalculator.beans.PaymentDetails;
import com.assignment.retail.paymentCalculator.util.CalculateDiscount;
import com.assignment.retail.paymentCalculator.util.Const;

public class PriceDiscountHandler extends DiscountHandler implements VerifyDiscount{

	/*
	 * check if Affiliate discount is applicable or not.
	 * If applicable, get discounted amount, else no discount is applicable.
	 * */
	
	@Override
	public DiscountDetails applyDiscount(PaymentDetails paymentDetails) {
		if(!isDiscountApplicable(paymentDetails)){
			discountDetails.setDiscountType("No Discount applicable.");
			discountDetails.setFinalAmount(paymentDetails.getAmount());
			
			//System.out.println("No Discount applicable.");
			//System.out.println("Payable Amt.:"+paymentDetails.getAmount());
		}else{
			discountDetails.setDiscountType("Eligible for default price discount.");
			discountDetails.setFinalAmount(CalculateDiscount.getDefaultDiscount(paymentDetails.getAmount()));
			//System.out.println("Eligible for default price discount.");
			//System.out.println("Payable Amt.:"+CalculateDiscount.getDefaultDiscount(paymentDetails.getAmount()));
		}
		return discountDetails;
	}

	@Override
	public boolean isDiscountApplicable(PaymentDetails paymentDetails) {
		boolean isPriceDiscount = false;
		if(paymentDetails.getAmount() > 100){
			isPriceDiscount = true;
		}
		return isPriceDiscount;
	}
}

package com.assignment.retail.paymentCalculator.handlers;

import com.assignment.retail.paymentCalculator.beans.DiscountDetails;
import com.assignment.retail.paymentCalculator.beans.PaymentDetails;
import com.assignment.retail.paymentCalculator.util.CalculateDiscount;
import com.assignment.retail.paymentCalculator.util.Const;

public class AffiliateDiscountHandler extends DiscountHandler implements VerifyDiscount{

	@Override
	public DiscountDetails applyDiscount(PaymentDetails paymentDetails) {
		/*
		 * check if Affiliate discount is applicable or not.
		 * If applicable, get discounted amount, else pass the request to other discount handler (old customer discount).
		 * */
		if(!isDiscountApplicable(paymentDetails)){
			discountHandler.applyDiscount(paymentDetails);
		}else{
			discountDetails.setDiscountType("Eligible for affliliate discount (10%).");
			discountDetails.setFinalAmount(CalculateDiscount.getDiscountPrice(Const.EMPLOYEE_DISCOUNT, paymentDetails.getAmount()));
			//System.out.println("Eligible for affliliate discount (10%).");
			//System.out.println("Payable Amt.: "+CalculateDiscount.getDiscountPrice(Const.AFFILIATE_DISCOUNT, paymentDetails.getAmount()));
		}
		return discountDetails;
	}

	@Override
	public boolean isDiscountApplicable(PaymentDetails paymentDetails) {
		boolean isAffiliate = false;
		if(paymentDetails.getAffiliate().equals(Const.YES)){
			isAffiliate = true;
		}
		return isAffiliate;
	}
}

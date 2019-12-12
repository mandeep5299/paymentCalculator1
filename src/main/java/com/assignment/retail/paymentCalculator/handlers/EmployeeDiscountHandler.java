package com.assignment.retail.paymentCalculator.handlers;

import com.assignment.retail.paymentCalculator.beans.DiscountDetails;
import com.assignment.retail.paymentCalculator.beans.PaymentDetails;
import com.assignment.retail.paymentCalculator.util.CalculateDiscount;
import com.assignment.retail.paymentCalculator.util.Const;

public class EmployeeDiscountHandler extends DiscountHandler implements VerifyDiscount{

	@Override
	public DiscountDetails applyDiscount(PaymentDetails paymentDetails) {
		/*
		 * check if employee discount is applicable or not.
		 * If applicable, get discounted amount, else pass the request to other discount handler (affiliate discount).
		 * */
		 
		if(!isDiscountApplicable(paymentDetails)){
			discountHandler.applyDiscount(paymentDetails);
		}else{
			discountDetails.setDiscountType("Eligible for employee discount (30%).");
			discountDetails.setFinalAmount(CalculateDiscount.getDiscountPrice(Const.EMPLOYEE_DISCOUNT, paymentDetails.getAmount()));
			//System.out.println("Eligible for employee discount (30%).");
			//System.out.println("Payable Amt.: "+CalculateDiscount.getDiscountPrice(Const.EMPLOYEE_DISCOUNT, paymentDetails.getAmount()));
		}
		return discountDetails;
	}

	@Override
	public boolean isDiscountApplicable(PaymentDetails paymentDetails) {
		boolean isEmployee = false;
		if(paymentDetails.getEmployee().equals(Const.YES)){
			isEmployee = true;
		}
		return isEmployee;
	}
}

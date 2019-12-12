package com.assignment.retail.paymentCalculator;

import com.assignment.retail.paymentCalculator.beans.DiscountDetails;
import com.assignment.retail.paymentCalculator.beans.PaymentDetails;
import com.assignment.retail.paymentCalculator.handlers.AffiliateDiscountHandler;
import com.assignment.retail.paymentCalculator.handlers.EmployeeDiscountHandler;
import com.assignment.retail.paymentCalculator.handlers.OldCustomerDiscountHandler;
import com.assignment.retail.paymentCalculator.handlers.PriceDiscountHandler;
import com.assignment.retail.paymentCalculator.util.Const;

public class Payment {

	private EmployeeDiscountHandler employeeDiscountHandler = new EmployeeDiscountHandler();
	private AffiliateDiscountHandler affiliateDiscountHandler = new AffiliateDiscountHandler();
	private OldCustomerDiscountHandler oldCustomerDiscountHandler = new OldCustomerDiscountHandler();
	private PriceDiscountHandler priceDiscountHandler = new PriceDiscountHandler();

	/*
	 * Various discount request handlers.
	 * their chaining as per the discount %age.
	 */
	public Payment() {
		employeeDiscountHandler.nextDiscountHandler(affiliateDiscountHandler);
		affiliateDiscountHandler.nextDiscountHandler(oldCustomerDiscountHandler);
		oldCustomerDiscountHandler.nextDiscountHandler(priceDiscountHandler);
	}
	
	public DiscountDetails calculate(PaymentDetails paymentDetails){
		/*
		 * check if bought products are grocery.
		 * If yes no other % discount is applicable just provide default price discount if applicable*/
		DiscountDetails discountDetails;
		if(paymentDetails.getIsGrocerry().equals(Const.NO)){
			discountDetails = employeeDiscountHandler.applyDiscount(paymentDetails);
		}else{
			discountDetails = priceDiscountHandler.applyDiscount(paymentDetails);
		}
		return discountDetails;
	}
}

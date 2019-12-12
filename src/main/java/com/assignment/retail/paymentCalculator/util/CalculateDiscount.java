package com.assignment.retail.paymentCalculator.util;

public class CalculateDiscount {

	public static double getDiscountPrice(int discount, double amount){
		return (amount - (amount*discount/100));
	}
	public static double getDefaultDiscount(double amount){
		double multi = amount/100;
		if(multi<1){
			multi=1;
		}
		return amount = amount - (Math.floor(multi) * Const.DEFAULT_DISCOUNT);
	}
}

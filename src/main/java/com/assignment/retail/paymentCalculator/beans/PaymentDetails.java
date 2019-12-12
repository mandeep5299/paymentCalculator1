package com.assignment.retail.paymentCalculator.beans;

public class PaymentDetails {

	private double amount;
	private String employee;
	private String affiliate;
	private String oldCustomer;
	private String isGrocerry;
	
	public PaymentDetails(double amount, String isGrocerry, String employee, String affiliate, String oldCustomer) {
		this.amount = amount;
		this.employee = employee;
		this.affiliate = affiliate;
		this.oldCustomer = oldCustomer;
		this.isGrocerry = isGrocerry;
	}
	
	
	public double getAmount() {
		return amount;
	}
	public String getEmployee() {
		return employee;
	}
	public String getAffiliate() {
		return affiliate;
	}
	public String getOldCustomer() {
		return oldCustomer;
	}
	public String getIsGrocerry() {
		return isGrocerry;
	}
}

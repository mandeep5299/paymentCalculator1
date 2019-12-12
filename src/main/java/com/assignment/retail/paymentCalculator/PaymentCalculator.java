package com.assignment.retail.paymentCalculator;

import java.util.Calendar;
import java.util.Scanner;

import com.assignment.retail.paymentCalculator.beans.DiscountDetails;
import com.assignment.retail.paymentCalculator.beans.PaymentDetails;
import com.assignment.retail.paymentCalculator.util.Const;

public class PaymentCalculator {
	public static void main(String[] args) {
		start();
	}

	static void start() {
		double amount;
		String grocery;
		String employee;
		String affiliate;
		String oldCustomer;

		Scanner sc = new Scanner(System.in);
		// Bill amount must be greater than 0.
		System.out.println("Enter bill amount.");
		amount = sc.nextDouble();
		if (amount <= 0)
			exit();
		// Is this bill for grocery or other products. Any thing other than Y/y
		// will be consider as N.
		System.out.println("Is grocery bill? (Y/N)");
		grocery = (sc.next().equalsIgnoreCase(Const.YES) ? Const.YES : Const.NO);
		// Is this bill for employee purchase. Any thing other than Y/y will be
		// consider as N.
		System.out.println("Is an employee? (Y/N)");
		employee = (sc.next().equalsIgnoreCase(Const.YES) ? Const.YES : Const.NO);
		// Is this bill for affiliate's purchase. Any thing other than Y/y will
		// be consider as N.
		System.out.println("Is an affiliate? (Y/N)");
		affiliate = (sc.next().equalsIgnoreCase(Const.YES) ? Const.YES : Const.NO);
		// Enter the valid year. Year must be greater than 0 and less than or
		// equal to current year.
		System.out.println("Customer since year.");
		int year = sc.nextInt();
		Calendar cal = Calendar.getInstance();
		if (year < 0 && year > cal.getWeekYear()) {
			exit();
		}
		oldCustomer = (cal.getWeekYear() - year > 2 ? Const.YES : Const.NO);
		PaymentDetails paymentDetails = new PaymentDetails(amount, grocery, employee, affiliate, oldCustomer);
		// calculate the discount and amount payable.
		DiscountDetails discountDetails = new Payment().calculate(paymentDetails);
		System.out.println(discountDetails.getDiscountType());
		System.out.println("Payable Amt.: "+ discountDetails.getFinalAmount());
	}

	static void exit() {
		System.out.println("Invalid inputs. Please try again.");
		System.exit(0);
	}
}

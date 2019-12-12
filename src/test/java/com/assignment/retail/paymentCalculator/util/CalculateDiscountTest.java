package com.assignment.retail.paymentCalculator.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.assignment.retail.paymentCalculator.util.CalculateDiscount;
import com.assignment.retail.paymentCalculator.util.Const;

public class CalculateDiscountTest {

	@Before
	public void initMocks(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test	
	public void getDiscountPriceEmployeeTest(){
		assertTrue(693.0 == CalculateDiscount.getDiscountPrice(Const.EMPLOYEE_DISCOUNT, 990));
	}
	
	@Test	
	public void getDiscountPriceEmployeeFalseTest(){
		assertFalse(Mockito.anyDouble() == CalculateDiscount.getDiscountPrice(Const.EMPLOYEE_DISCOUNT, 990));
	}
	
	@Test	
	public void getDiscountPriceAffiliateTest(){
		assertTrue(891.0 == CalculateDiscount.getDiscountPrice(Const.AFFILIATE_DISCOUNT, 990));
	}
	@Test	
	public void getDiscountPriceAffiliateFalseTest(){
		assertFalse(Mockito.anyDouble()  == CalculateDiscount.getDiscountPrice(Const.AFFILIATE_DISCOUNT, 990));
	}
	@Test	
	public void getDiscountPriceOldCustomerTest(){
		assertTrue(940.5 == CalculateDiscount.getDiscountPrice(Const.OLD_CUSTOMER_DISCOUNT, 990));
	}
	@Test	
	public void getDiscountPriceOldCustomerFalseTest(){
		assertFalse(Mockito.anyDouble()  == CalculateDiscount.getDiscountPrice(Const.OLD_CUSTOMER_DISCOUNT, 990));
	}
	@Test	
	public void getDefaultDiscountTest(){
		assertTrue(945 == CalculateDiscount.getDefaultDiscount(990));
	}
	@Test	
	public void getDefaultDiscountFalseTest(){
		assertFalse(Mockito.anyDouble()  == CalculateDiscount.getDefaultDiscount(990));
	}
}

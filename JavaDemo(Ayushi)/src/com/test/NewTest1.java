package com.test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class NewTest1 {
	
	@Test(priority=1)
	public void testGoogle() {
		SoftAssert sa=new SoftAssert();
		System.out.println("1st assert");
		sa.assertEquals(10, 10);
		
		System.out.println("2nd validation");
		sa.assertEquals("Hi", "Hi");
		
		sa.assertAll();
		
	}
	

}

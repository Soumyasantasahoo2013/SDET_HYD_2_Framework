package com.vtiger.genericutil;

import java.util.Random;

import org.testng.annotations.Test;

/**
 * This class to generate random number
 * @author SOUMYASANTA SAHOO
 *
 */
public class JavaUtility {
	
	/**
	 * this method will return a random number
	 * @return
	 */
	@Test
	public static int generateRandomNumber()
	{
		Random r=new Random();
		int number = r.nextInt(1000);
		return number;
	}

}

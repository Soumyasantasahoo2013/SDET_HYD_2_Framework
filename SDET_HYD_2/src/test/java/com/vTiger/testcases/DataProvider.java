package com.vTiger.testcases;

import org.testng.annotations.Test;

public class DataProvider {
	
	@org.testng.annotations.DataProvider
	public Object[][] sendData()
	{
		Object[][] ob=new Object[3][2];
		
		ob[0][0]="ACC_1";
		ob[0][1]=4565.00;
		
		ob[1][0]="ACC_2";
		ob[1][1]=4565;
		
		ob[2][0]="ACC_3";
		ob[2][1]=465.00;
		
		return ob;
	}
	
	@Test(dataProvider = "sendData")
	public void getData(String name, double balance)
	{
		System.out.println("Name of Account Holder :"+name+" Balance :"+balance);
	}

}

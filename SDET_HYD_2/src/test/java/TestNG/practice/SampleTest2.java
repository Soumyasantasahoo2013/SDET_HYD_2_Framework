package TestNG.practice;

import org.testng.annotations.Test;

public class SampleTest2 {
	
	@Test(retryAnalyzer = com.vtiger.genericutils.RetryAnalyser.class)
	public void createOrganization()
	{
		System.out.println(10/0);
	}

}

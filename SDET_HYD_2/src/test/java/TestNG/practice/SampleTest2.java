package TestNG.practice;

import org.testng.annotations.Test;

public class SampleTest2 {
	
	@Test(retryAnalyzer = com.vtiger.genericutil.RetryAnalyser.class)
	public void createOrganization()
	{
		System.out.println(10/0);
	}

}

package TestNG.practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class SampleTest {

	@Test
	public void createOrganization()
	{
		System.out.println("create the Organization");
	}

	@Test
	public void modifyOrganization()
	{
		System.out.println("Modify the Organization");
	}
	
}

package TestNG.practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.genericutils.BaseClass;

@Listeners(com.vtiger.genericutils.ListenerImp.class)
public class SampleTest extends BaseClass {

	@Test
	public void createOrganization()
	{
		System.out.println(10/0);
	}

	@Test
	public void modifyOrganization()
	{
		System.out.println("Modify the Organization");
	}
	
}

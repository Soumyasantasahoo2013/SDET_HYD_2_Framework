package DDT.practice;

import org.testng.annotations.Test;

public class CreateUserTest {
	
	@Test
	public void createUserTest()
	{
		System.out.println("Execute Script");
		String URL = System.getProperty("url");
		String UN = System.getProperty("username");
		String PWD = System.getProperty("password");
		System.out.println("========>"+URL);
		System.out.println("========>"+UN);
		System.out.println("========>"+PWD);
	}

}

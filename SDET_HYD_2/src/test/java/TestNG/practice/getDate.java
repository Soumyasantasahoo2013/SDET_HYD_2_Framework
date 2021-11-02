package TestNG.practice;

import java.util.Date;

import org.testng.annotations.Test;

public class getDate {
	
	@Test
	public void getDateTest()
	{
		new Date().toString().replace(" ", "_").replace(":", "_");
	}

}

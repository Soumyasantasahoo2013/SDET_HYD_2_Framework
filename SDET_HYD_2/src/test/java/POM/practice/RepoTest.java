package POM.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.vtiger.objectRepository.Login;

public class RepoTest {
	
	@Test
	public void repoTest()
	{
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888");
		Login lp=new Login(driver);
		lp.loginIntoVtiger("admin", "admin");
	}

}

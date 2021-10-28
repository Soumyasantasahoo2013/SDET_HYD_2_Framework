package JDBC.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class VerifyTheTableTest {
	
	@Test
	public void verifyTheTableTest() throws Throwable
	{
		String expectedData="bam";
		
		//Register the Driver
		Driver dref=new Driver();
		DriverManager.registerDriver(dref);
		
		//Create the Connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
		
		//Create the Statement
		Statement stmt = con.createStatement();
		
		//Verify the Data
		ResultSet res = stmt.executeQuery(" select * from students_info;");
		boolean flag=false;
		while(res.next())
		{
			String actualData = res.getString(2);
			if(actualData.equals(expectedData))
			{
				System.out.println(expectedData+" is present");
				flag=true;
				break;
			}
			
		}
		Assert.assertEquals(flag, true);
		
		//Close the connection
		con.close();
	}

}

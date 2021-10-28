package JDBC.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class ExecuteUpdate {
	
	@Test
	public void executeUpdateTest() throws Throwable
	{
		Connection con=null;
		try {
		//Register the database
		Driver dref=new Driver();
		DriverManager.registerDriver(dref);
		
		//Connect to the Database
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
		
		//create statement
		Statement stmt = con.createStatement();
		
		//Insert the Data
		int res = stmt.executeUpdate("insert into students_info (regno, firstname, middlename, lastname) values('6', 'Suresh','gowda', 'r');");
        System.out.println(res);
        if(res==1)
        {
        	System.out.println("Data inserted into Database");
        }
        else
        {
        	System.out.println("Data not inserted");
        }
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			//close the connection
			con.close();
		}
	}

}

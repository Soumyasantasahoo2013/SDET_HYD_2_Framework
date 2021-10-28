package JDBC.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class ExecuteQuery {
	
	@Test
	public void executeQueryTest() throws Throwable
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

		
		//execute my query and will get the data
		ResultSet res=stmt.executeQuery("select * from student_info;");
		while(res.next())
		{
			System.out.println(res.getInt(1)+"\t"+res.getString(2)+"\t"+res.getString(3));
		}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		finally {
		//close the Connection
			System.out.println("======Closing the Connection=====");
		con.close();
		}
	}

}

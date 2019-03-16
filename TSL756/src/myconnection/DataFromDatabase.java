package myconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class DataFromDatabase {
	WebDriver driver;

		  @Test
		  
		  public void f() throws Exception {
			  
			  DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			  Connection C =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Newuser123");
			  ResultSet R= C.createStatement().executeQuery("select  * from Login");
			  
			  while(R.next())
			  {
				  System.out.println(R.getString(1));
				  System.out.println(R.getString(2));
			  }
		  }
		  
		 
}
package day8;

import org.testng.annotations.Test;

import util.Base;

public class Execute extends Base {
  @Test 
  public void f() 
  {
	  Login LN=new Login(driver);
	  SQL_Command command=new SQL_Command(driver);
	  driver.get("http://127.0.0.1:8080/htmldb");
	  LN.LoginProcess("system", "Newuser123");
	  command.LogoutProcess();
  }
}

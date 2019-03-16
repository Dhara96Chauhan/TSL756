package day9;

import org.testng.annotations.Test;

import util.Base;

public class Executekeywords extends Base {
  @Test
  public void f() throws Exception 
  
  {
	  KeyWords Key=new KeyWords(driver);
	  Key.openUrl("https://opensource-demo.orangehrmlive.com/");
	  Key.type("txtUsername_name", "Admin");
	  Key.type("txtPassword_id", "admin123");
	  Key.click("//*[@type='submit']_xpath");
	  Thread.sleep(3000);
	  Key.click("//*[@id='welcome']_xpath");
	  Thread.sleep(3000);
	  Key.click("Logout_linktext");
  }
}

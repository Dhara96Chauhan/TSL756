package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import util.Base;
public class Scrolling extends Base {
	WebDriver driver;
  @Test
  public void f() throws Exception {
	  
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	  driver.get("http://seleniumhq.org");
	  
 js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.linkText("Selenium blog")));
	  Thread.sleep(4000);
	 
  }
}

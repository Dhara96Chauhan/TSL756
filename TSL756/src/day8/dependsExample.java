package day8;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import util.Base;

public class dependsExample extends Base
{
  @Test
  public void f1() 
  {
	  System.out.println("In test 1");

	driver.get("http://google.com");
	 Assert.assertEquals(driver.getTitle(), "Google");
  }
  
  @Test(dependsOnMethods="f1")
  public void f2() 
  {
	  System.out.println("In test 2");
	  boolean display = driver.findElement(By.name("q")).isDisplayed();
	  Assert.assertTrue(display);
	  
  }
@Test(dependsOnMethods="f2")
public void f3()
{

	String data = "MODI";
	driver.findElement(By.name("q")).sendKeys(data);
	
	driver.findElement(By.name("btnK")).click();
	 Assert.assertEquals(driver.getTitle(), data+"- Google Search");
		System.out.println("In test 3");
}
}


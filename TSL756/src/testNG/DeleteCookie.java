package testNG;

import java.util.Set;

import javax.swing.border.TitledBorder;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.Test;

import util.Base;

public class DeleteCookie extends Base
{
  @Test
  public void oracle() throws InterruptedException
  {
	  driver.get("http://127.0.0.1:8080/htmldb");
	  driver.findElement(By.xpath("//*[@id='P11_USERNAME']")).clear();
	  driver.findElement(By.xpath("//*[@id='P11_USERNAME']")).sendKeys("sys");
	  driver.findElement(By.xpath("//*[@id='P11_PASSWORD']")).clear();
	  driver.findElement(By.xpath("//*[@id='P11_PASSWORD']")).sendKeys("Newuser123");
	  driver.findElement(By.xpath("//*[@value='Login']")).click();
	  driver.manage().deleteAllCookies();
//  driver.findElement(By.linkText("SQL")).click();
	  driver.navigate().refresh();

	  Assert.assertEquals(driver.getTitle(), "HTML DB Login");
//	  Assert.assertTrue(driver.findElement(By.name("p_t01")).isDisplayed());
	  Thread.sleep(4000);
  }
}
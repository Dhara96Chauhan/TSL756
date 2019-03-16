package day7;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import util.Base;

public class AlertExample extends Base{
  @Test
  public void alertTesting() throws Exception {
	  
	  
	  driver.get("https://www.magneticautomation.in/2019/01/alert-example.html");
	  Thread.sleep(2000);
	  
	  driver.findElement(By.xpath("//button[@onclick='myFunction1()']")).click();
	  
	  Alert A=driver.switchTo().alert();
	  Thread.sleep(2000);
	  
	 
	  String txt=A.getText();
	  System.out.println(txt);
	  A.accept();
	  
	  Thread.sleep(2000);
	  
	  driver.findElement(By.xpath("//button[@onclick='myFunction()']")).click();
	  Alert A2=driver.switchTo().alert();
	  System.out.println(A2.getText());
	  
	  Thread.sleep(2000);
	  A2.sendKeys("John");
	  Thread.sleep(2000);
	  
	  A2.dismiss();
	  }
}

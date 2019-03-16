package testNG;

import org.testng.annotations.Test;

import myconnection.MyConnection;
import util.BrowserSetup;
import util.Excel;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class para {
	WebDriver driver;
	
  @Test(dataProvider = "dp")
  public void Login(String UN, String PW) 
  {
	  driver.get("http://127.0.0.1:8080/htmldb");
	  driver.findElement(By.xpath("//*[@id='P11_USERNAME']")).clear();
	  driver.findElement(By.xpath("//*[@id='P11_USERNAME']")).sendKeys(UN);
	  driver.findElement(By.xpath("//*[@id='P11_PASSWORD']")).clear();
	  driver.findElement(By.xpath("//*[@id='P11_PASSWORD']")).sendKeys(PW);
	  driver.findElement(By.xpath("//*[@value='Login']")).click();
	  driver.findElement(By.linkText("Logout")).click();
	  driver.findElement(By.partialLinkText("Log")).click();
  }
@DataProvider

public Object[][] dp() {
	Object[][] data=new Object[4][2];



return data;
}


//  @DataProvider
//  public Object[][] dp() {
//Object[][] data=new Object[4][2];
//
//Excel excel =new Excel("C:\\Users\\vshadmin\\Desktop\\abc.xlsx");
//
//for(int i=0; i<=excel.rowCount("Sheet1"); i++) {
//data[i][0]=excel.Read("Sheet1", i, 0);
//data[i][1]=excel.Read("Sheet1", i, 1);
//}
////data[1][0]="system";
////data[1][1]="Newuser123";
////data[2][0]="dgd";
////data[2][1]="sjgkjys";
////data[3][0]="sjhfys";
////data[3][1]="sysd";
//	
//return data;
//  }
  
@AfterMethod     // Runs for each TestMethod
  
  public void AfterMethod(ITestResult result)
  {
	  
	  System.out.println(ITestResult.FAILURE);
	  System.out.println(ITestResult.SUCCESS);
	  System.out.println(ITestResult.SKIP);
	  
	  if(result.getStatus()==ITestResult.FAILURE)
	  {
		  System.out.println("Taking Screenshot....");
		  BrowserSetup.getScreenShot(result.getName()); 
	  }
  }
 
  @BeforeTest
  public void beforeTest() 
  {
	  driver=BrowserSetup.browserStart("chrome");
  }

  @AfterTest
  public void afterTest()
  {
	  driver.quit();
  }

}

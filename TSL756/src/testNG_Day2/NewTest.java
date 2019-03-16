package testNG_Day2;

import org.testng.annotations.Test;

import util.BrowserSetup;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class NewTest {
	WebDriver driver;
	  @Test(dataProvider = "dp")
	  public void Login(String UN, String PW) 
	  {
		  driver.get("http://127.0.0.1:8080/htmldb/f?p=4550:11:16954781911278626555::NO:::");
		  driver.findElement(By.xpath("//*[@id='P11_USERNAME']")).sendKeys(UN);
		  driver.findElement(By.xpath("//*[@id='P11_PASSWORD']")).sendKeys(PW);
		  driver.findElement(By.xpath("//*[@value='Login']")).click();
		  driver.findElement(By.linkText("Logout")).click();
		  driver.findElement(By.partialLinkText("Log")).click();
	  }

	  @DataProvider
	  public Object[][] dp() throws Exception {
	Object[][] data=new Object[4][2];

	FileInputStream inFile = new FileInputStream("C:\\Users\\vshadmin\\Desktop\\Book1.xlsx");
	XSSFWorkbook book = new XSSFWorkbook(inFile);
	XSSFSheet sheet = book.getSheet("Sheet1");
	
	for(int i =0 ; i<=sheet.getLastRowNum();i++)
	{
	String data1 = sheet.getRow(i).getCell(0).toString();
	System.out.print(data1);
	driver.findElement(By.cssSelector("input#P11_USERNAME")).sendKeys(data1);
	
	String data11 = sheet.getRow(i).getCell(1).toString();
	System.out.println("  "+data11);
	driver.findElement(By.cssSelector("input[type='password']")).sendKeys(data11);
	driver.findElement(By.cssSelector("input[value='Login']")).click();
	
	
	
	if (driver.getTitle().equals("Oracle"))
	{
	
	System.out.println("login done");
	
	driver.findElement(By.cssSelector("img[title='Logout']")).click();
	driver.findElement(By.cssSelector("a.htmldbInstruct")).click();
	}
	else
	{
		System.out.println("login fail");}
	}
	return data;
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

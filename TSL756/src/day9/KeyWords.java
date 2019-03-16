package day9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class KeyWords {
	private WebDriver driver;
	
	public KeyWords(WebDriver idriver)
	{
		this.driver=idriver;
	}
	
	public void openUrl(String url)
	{
		driver.get(url);
	}

	public void type(String Locator,String text)
	{
		driver.findElement(element(Locator)).sendKeys(text);
	}
	public void click(String Locator)
	{
		driver.findElement(element(Locator)).click();;
	}
	public void dropDown(String Locator,String visibletext)
	{
		new Select(driver.findElement(element(Locator))).selectByVisibleText(visibletext);
	}	
	public By element(String Value)
	  {
		  By B=null;
		  if(Value.endsWith("_linktext"))
			B=  By.linkText(Value.split("_")[0]);
		  else if (Value.endsWith("_xpath"))	 
			B=  By.xpath(Value.split("_")[0]);
		  else if (Value.endsWith("_id"))	 
				B=  By.id(Value.split("_")[0]);
		  else if (Value.endsWith("_name"))	 
				B=  By.name(Value.split("_")[0]);
		  else if (Value.endsWith("_css"))	 
				B=  By.cssSelector(Value.split("_")[0]);
		  else 
			  System.out.println("Invalid Locator");
		  return B;
	  }  
}

package day8;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import util.Base;

public class ReadProperty extends Base {
	
	@Test
  public void property() throws Exception
{
	Properties prop=new Properties();
	prop.load(new FileInputStream(".\\Contant.property"));
	driver.get(prop.getProperty("URL"));
	driver.findElement(By.linkText(prop.getProperty("e_download"))).click();
}
	
	public By element(String value)
	{
		By B=null;
		if(value.endsWith("_linktext"))
			B=By.linkText(value.split("_")[0]);
		else if(value.endsWith("_xpath"))
		B=By.xpath(value.split("_")[0]);
		return B;
	}
	
	
	
}

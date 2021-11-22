package Testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.appender.rolling.action.Action;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.Homepage;
import utilities.BaseTest;

public class Homepage_TC extends BaseTest
{
	public static Logger log= LogManager.getLogger(BaseTest.class.getName());
	@Test
	public void Homepage() throws InterruptedException
	{
		
		driver.get(baseURL);
		Homepage hp=new Homepage(driver,test);
		log.info("Homepage loaded successfully");
		test.info("Homepage loaded successfully");
		Assert.assertTrue(hp.Homepage_logo().isDisplayed());
		
		
	}
	
}
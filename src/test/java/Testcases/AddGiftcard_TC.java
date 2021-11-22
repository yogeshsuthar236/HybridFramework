package Testcases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.AddGiftcard;
import utilities.BaseTest;

public class AddGiftcard_TC extends BaseTest {


	public static Logger log= LogManager.getLogger(BaseTest.class.getName());
	
	@Test
	public void AddGift() throws IOException, InterruptedException{
		driver.get(baseURL);
		AddGiftcard gfcard=new AddGiftcard(driver,test);
		gfcard.Gift_card_section().click();
		log.info("navigated to Add giftcard section");
		test.info("navigated to Add giftcard section");
		gfcard.Add_cart().click();
		Thread.sleep(2000);
		Assert.assertTrue(gfcard.checkout_availibility().isDisplayed());
		log.info("Gift card added successfully");
		test.info("Gift card added successfully");
}
}

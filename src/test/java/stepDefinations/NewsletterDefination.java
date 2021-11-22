package stepDefinations;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import io.cucumber.java.en.*;
import pageobjects.Newsletter_Locator;
import utilities.BaseTest;

public class NewsletterDefination extends BaseTest{

	public static Logger log= LogManager.getLogger(BaseTest.class.getName());
	String title=null;
	@When("Enter the email {string} in the Newsletter section and click on signup button")
	public void enter_the_email_in_the_newsletter_section_and_click_on_signup_button(String string) throws InterruptedException {
		Newsletter_Locator nl=new Newsletter_Locator(driver,test);
		nl.Newsletter().sendKeys(string);
		log.info("User email id entered");
		test.info("User email id entered");
		Thread.sleep(2000);
		nl.Submit_newsletter().click();
		log.info("Signup button clicked");
		test.info("Signup button clicked");
	}

	@Then("The newsletter page should be displayed")
	public void the_newsletter_page_should_be_displayed() {
	Newsletter_Locator nl=new Newsletter_Locator(driver,test);
		String main=driver.getWindowHandle();
		for(String handle : driver.getWindowHandles()) {
			if (!handle.equals(main)) {
				driver.switchTo().window(handle);
				title=driver.getTitle();
				driver.close();
			}
		}
		driver.switchTo().window(main);
		Assert.assertEquals(title, "Newsletter");
		log.error("Page not found");
	}

}

package stepDefinations;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import io.cucumber.java.en.*;
import pageobjects.Cart_Checkout;
import utilities.BaseTest;

public class CartcheckoutDefination extends BaseTest{
	public static Logger log= LogManager.getLogger(BaseTest.class.getName());
	
	@When("Add one product to cart and click on cart section")
	public void add_one_product_to_cart_and_click_on_cart_section() throws InterruptedException {
		Cart_Checkout cart=new Cart_Checkout(driver,test);
		cart.product_selection().click();
		cart.Add_cart().click();
		log.info("product added to cart");
		test.info("Product added to cart");
		cart.Continue_shop().click();
		Thread.sleep(2000);
		cart.Cart().click();
		log.info("Navigated to cart");
		test.info("Navigated to cart");
	}

	@When("click on checkout button")
	public void click_on_checkout_button() {
		Cart_Checkout cart=new Cart_Checkout(driver,test);
		cart.Go_Checkout().click();
		cart.Remove_whatsappimg().click();
		test.info("Moving to the checkout option");
	}

	@Then("validate the continue button for payment page is availabe or not")
	public void validate_the_continue_button_for_payment_page_is_availabe_or_not() {
		Cart_Checkout cart=new Cart_Checkout(driver,test);
		Assert.assertTrue(cart.continuebutton().isDisplayed());
		log.info("successfully navigated to the checkout page");
		test.info("successfully navigated to the checkout page");
	}
}

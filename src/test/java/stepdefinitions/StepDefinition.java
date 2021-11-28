package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.SeleniumUtil;

import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.github.javafaker.Faker;

import io.cucumber.datatable.DataTable;

public class StepDefinition{	
	
	/** The base utils. */
	private BaseUtils baseUtils;
	
	/**
	 * Instantiates a new step definition.
	 *
	 * @param base the base
	 */
	public StepDefinition(BaseUtils base) {
		this.baseUtils = base;
	}
	
	
	@When("User clicks on {string} element in {string}")
	public void userClicksOnElement(String elementName, String pageName) {
		switch (pageName) {
		case "Home Page":
							SeleniumUtil.callclickElementMethod(baseUtils.homePage, elementName);
							break;
		case "Register Page":
							SeleniumUtil.callclickElementMethod(baseUtils.registerPage, elementName);
							break;

		default:
			break;
		}
	    
	}
	
	@Then("Verify Page with title {string} is displayed")
	public void pageIsDisplayed(String eTitle) {
		SeleniumUtil.verifyTitle(baseUtils.wait,eTitle);
	}
	
	@Given("User is on {string} page")
	public void userIsOnPage(String eTitle) {
		SeleniumUtil.verifyTitle(baseUtils.wait,eTitle);
	}
	
	@When("User enters below inputs in {string}")
	public void userEntersInTextBox(String pageName, DataTable dataTable) {
		Map<String, String> dt = dataTable.asMap(String.class,String.class);
		for(String key:dt.keySet())
		{
			String value=getValue(key,dt.get(key));
			
			switch (pageName) {
			
			case "Register Page":
								SeleniumUtil.callEnterInputMethod(baseUtils.registerPage, key,value);
								break;
			case "Home Page":
								SeleniumUtil.callEnterInputMethod(baseUtils.homePage, key,value);
								break;
			default:
				break;
			}
			
		}
		
		
	}
	
	
	@Then("Verify {string} message is displayed on {string}")
	public void VerifyMessageIsDisplayed(String message,String pageName) {
		switch (pageName) {
		case "Register Page":
							SeleniumUtil.callVerifyElementPresentMethod(baseUtils.registerPage,message);
							break;
		case "Home Page":
							SeleniumUtil.callVerifyElementPresentMethod(baseUtils.homePage,message);
							break;
		default:
			break;
		}
	}

	@When("User clicks Add to Cart button of below product in {string}")
	public void clickAddToCartButton(String pageName, DataTable dataTable) throws InterruptedException {
		Map<String, String> dt = dataTable.asMap(String.class,String.class);
		System.out.println(dt);
		for(String key:dt.keySet())
		{
			String value=dt.get(key);
			
			switch (pageName) {
			
			case "Home Page":
								String xp ="//span[text()='"+value+"']/ancestor::div[3]//button[@data-ref='add-to-cart-button']";
								WebElement button = baseUtils.driver.findElement(By.xpath(xp));
								SeleniumUtil.clickElement(baseUtils.wait, button);
								Thread.sleep(3000);
								break;
			default:
				break;
			}
			
		}
		
	}
	@Then("Verify that below products are present in {string}")
	public void verifyThatBelowProductsArePresentIn(String pageName,DataTable dataTable) {
		Map<String, String> dt = dataTable.asMap(String.class,String.class);
		System.out.println(dt);
		for(String key:dt.keySet())
		{
			String value=dt.get(key);
			
			switch (pageName) {
			
			case "Cart Page":
								System.out.println("Verify product:"+value+" is present in "+pageName);
								String xp ="//h3[contains(text(),'"+value+"')]";
								WebElement product = baseUtils.driver.findElement(By.xpath(xp));
								SeleniumUtil.verifyElementPresent(baseUtils.wait, product);

								break;
			default:
				break;
			}
			
		}
	}

	private String getValue(String key,String value) {
		if(key.equals("email") ||key.equals("retypeEmail") )
		{
			String emailid=BaseUtils.now+"@gmail.com";
			return emailid;
		}
		else
		{
			return value;
		}
	}

}

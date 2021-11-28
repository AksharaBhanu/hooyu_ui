package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.SeleniumUtil;

import java.util.Map;
import java.util.Set;

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
								SeleniumUtil.callEnterInputMethod(baseUtils.registerPage, key,value);
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
							SeleniumUtil.callVerifyElementPresentMethod(baseUtils.registerPage,message);
							break;
		default:
			break;
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

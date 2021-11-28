package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.SeleniumUtil;


public class HomePage extends BasePage{

	@FindBy(linkText = "Register")
	public WebElement register;
		
	public HomePage(WebDriver driver,WebDriverWait wait)
	{
		super(driver,wait);
	}
	
	
	
	public void verifyHomePageIsDisplayed(String eTitle)
	{
		SeleniumUtil.verifyTitle(wait,eTitle);
	}

}

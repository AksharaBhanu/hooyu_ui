package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;



public class HomePage extends BasePage{

	@FindBy(linkText = "Register")
	public WebElement register;
		
	public HomePage(WebDriver driver,WebDriverWait wait)
	{
		super(driver,wait);
	}
	
}

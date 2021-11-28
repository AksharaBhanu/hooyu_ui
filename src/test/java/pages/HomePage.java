package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;



public class HomePage extends BasePage{

	@FindBy(linkText = "Register")
	public WebElement register;
		
	@FindBy(xpath="//input[@name='search']")
	public WebElement searchBox;
	
	@FindBy(xpath="//button[@type='submit']")
	public WebElement searchButton;
	
	@FindBy(css=".mini-cart-button")
	public WebElement cartButton;
	
	@FindBy(xpath="//button[text()='Got it']")
	public WebElement gotItButton;
	

	public HomePage(WebDriver driver,WebDriverWait wait)
	{
		super(driver,wait);
	}
	
}

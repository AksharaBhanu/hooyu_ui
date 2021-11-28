package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage extends BasePage{

	@FindBy(id="firstname")
	public WebElement firstName;
	
	@FindBy(id="surname")
	public WebElement lastName;
	
	@FindBy(id="email")
	public WebElement email;
	
	@FindBy(id="email2")
	public WebElement retypeEmail;
	
	@FindBy(id="password")
	public WebElement password;
	
	@FindBy(id="password2")
	public WebElement retypePassword;
	
	@FindBy(id="telno1")
	public WebElement mobileNumber;
	
	@FindBy(name="registerButton")
	public WebElement registerNow;
	
	@FindBy(xpath="//h3[text()='Welcome to the TAKEALOT.com family!']")
	public WebElement welcomeToFamily;
	
	public RegisterPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		
	}

	
}

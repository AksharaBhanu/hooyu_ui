package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.HomePage;
import pages.RegisterPage;

public class BaseUtils {

	public WebDriver driver;
	public WebDriverWait wait;
	
	public HomePage homePage;
	public RegisterPage registerPage;
	
	public static long duration;
	public static String appUrl;
	public static String browser;
	public static long now;
	
}


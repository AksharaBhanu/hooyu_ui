package stepdefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HomePage;
import pages.RegisterPage;

public class BaseClass {	
	
	private BaseUtils baseUtils;
	
	public BaseClass(BaseUtils base) {
		this.baseUtils=base;
	}
	
	@Before
	public void beforeScenarioOne() {
		switch (BaseUtils.browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			baseUtils.driver = new ChromeDriver();
		
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			baseUtils.driver = new FirefoxDriver();
			break;
		default:
			break;
		}
		
		baseUtils.driver.get(BaseUtils.appUrl);
		baseUtils.driver.manage().timeouts().implicitlyWait(BaseUtils.duration,TimeUnit.SECONDS);
		baseUtils.wait=new WebDriverWait(baseUtils.driver,BaseUtils.duration);
		baseUtils.homePage = new HomePage(baseUtils.driver,baseUtils.wait);
		baseUtils.registerPage= new RegisterPage(baseUtils.driver,baseUtils.wait);
	}
		
	
	@After
	public void afterScenarioDelete() {
		baseUtils.driver.quit();
	}
}

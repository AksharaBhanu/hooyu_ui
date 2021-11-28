package pages;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.SeleniumUtil;

public abstract class BasePage implements ITakealot{
	public WebDriverWait wait;
	
	public BasePage(WebDriver driver,WebDriverWait wait)
	{
		PageFactory.initElements(driver,this);
		this.wait = wait;
	}

	@Override
	public void clickElement(String elementName) {
		try 
		{
			WebElement element =(WebElement) this.getClass().getDeclaredField(elementName).get(this);
			Method method = SeleniumUtil.class.getDeclaredMethod("clickElement",WebDriverWait.class,WebElement.class);
			method.invoke(null,wait,element);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void enterInput(String elementName, String input) {
		try 
		{
			WebElement element =(WebElement) this.getClass().getDeclaredField(elementName).get(this);
			Method method = SeleniumUtil.class.getDeclaredMethod("typeElement",WebDriverWait.class,WebElement.class,String.class);
			method.invoke(null,wait,element,input);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void verifyElementPresent(String elementName) {
		try 
		{
			WebElement element =(WebElement) this.getClass().getDeclaredField(elementName).get(this);
			Method method = SeleniumUtil.class.getDeclaredMethod("verifyElementPresent",WebDriverWait.class,WebElement.class);
			method.invoke(null,wait,element);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void verifyTitle(String eTitle) {
		try 
		{
			
			Method method = SeleniumUtil.class.getDeclaredMethod("verifyTitle",WebDriverWait.class,String.class);
			method.invoke(null,wait,eTitle);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}

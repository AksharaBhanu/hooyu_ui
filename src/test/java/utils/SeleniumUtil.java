package utils;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.ITakealot;

public class SeleniumUtil {

	
	public static void clickElement(WebDriverWait wait, WebElement element)
	{
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			element.click();
			System.out.println("Able to click on the element");
		}
		catch (Exception e) {
			Assert.fail("Element not visible to click");
			e.printStackTrace();
		}
	}
	
	public static void typeElement(WebDriverWait wait,WebElement element,String input)
	{
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			element.sendKeys(input);
			System.out.println("Able to enter the input:"+input);
		}
		catch (Exception e) {
			Assert.fail("Element not visible, to enter input:"+input);
			e.printStackTrace();
		}
	}
	
	public static void verifyTitle(WebDriverWait wait,String eTitle)
	{
		try {
			wait.until(ExpectedConditions.titleContains(eTitle));
			System.out.println("Title is matching:"+eTitle);
		}
		catch (Exception e) {
			Assert.fail("Title is not matching:"+eTitle);
			e.printStackTrace();
		}
		
	}
	
	public static void verifyElementPresent(WebDriverWait wait,WebElement element)
	{
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			System.out.println("Element is Present");

		}
		catch (Exception e) {
			Assert.fail("Element is Not Present");
		}
		
	}
	
	public static void callclickElementMethod(ITakealot takealotPage,String elementName)
	{
		try
		{
			System.out.println("Clicking on the element:"+elementName);
			takealotPage.clickElement(elementName);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void callEnterInputMethod(ITakealot takealotPage,String elementName,String input)
	{
		try
		{
			System.out.println("enterting input '"+input+"' in the element:"+elementName);
			takealotPage.enterInput(elementName, input);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void callVerifyElementPresentMethod(ITakealot takealotPage,String elementName)
	{
		try
		{
			System.out.println("Verifying the element:'"+elementName+"' present or not");
			takealotPage.verifyElementPresent(elementName);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void callVerifyTitleMethod(ITakealot takealotPage,String eTitle)
	{
		try
		{
			System.out.println("Verifying the Title:"+eTitle);
			takealotPage.verifyTitle(eTitle);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}

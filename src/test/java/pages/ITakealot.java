package pages;

public interface ITakealot {

	public void clickElement(String elementName);
	public void enterInput(String elementName,String input);
	public void verifyElementPresent(String elementName);
	public void verifyTitle(String eTitle);
}

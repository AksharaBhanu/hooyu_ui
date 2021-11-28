Feature: Checkout product
  This feature has scenarios to Checkout product in https://www.takealot.com/

	@smoke	
	Scenario: Checkout watches - Valid
		Given User is on "Takealot.com: Online Shopping" page
		And User clicks on 'gotItButton' element in "Home Page"
		When User enters below inputs in "Home Page"
		|searchBox|watches|		
		And User clicks on "searchButton" element in "Home Page"
		And User clicks Add to Cart button of below product in "Home Page"
		|product1|Smart Watch A1 - Black|
		|product2|116p Smart Watch With|
		And User clicks on 'cartButton' element in "Home Page"
		Then Verify that below products are present in "Cart Page"
		|product1|Smart Watch A1 - Black|
		|product2|116p Smart Watch With|


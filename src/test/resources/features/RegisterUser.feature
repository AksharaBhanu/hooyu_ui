Feature: Register a New User
  This feature has scenarios to register new user in https://www.takealot.com/
		
	Background: Navigate to  Register Page
		Given User is on "Takealot.com: Online Shopping" page
		When User clicks on "register" element in "Home Page"
		Then Verify Page with title "Register on Takealot" is displayed
		
	Scenario: Register New User - Valid
		Given User is on "Register on Takealot" page
		When User enters below inputs in "Register Page"
		|firstName|Bhanu|
		|lastName|Prakash|
		|email|javagalbhanu4@gmail.com|
		|retypeEmail|javagalbhanu4@gmail.com|
		|password|bhanu123|		
		|retypePassword|bhanu123|		
		|mobileNumber|0873628000|			
		And User clicks on "registerNow" element in "Register Page"
		Then Verify "welcomeToFamily" message is displayed on "Register Page"

Scenario: Register New User -Invalid
		Given User is on "Register on Takealot" page
		When User enters below inputs in "Register Page"
		|firstName|Bhanu|
		|lastName|Prakash|
		|email|javagalbhanu4@gmail.com|
		|retypeEmail|javagalbhanu4@gmail.com|
		|password|bhanu123|		
		|retypePassword|bhanu123|				
		And User clicks on "registerNow" element in "Register Page"
		Then Verify "noMobileNumber" message is displayed on "Register Page"
Feature: test register user functionality

  Scenario: register user functionality

   Given Launch browser "chrome" and Navigate to  "http://automationexercise.com"
   And Verify that home page is visible successfully
   Then Click on Signup button
   Given Verify New User Signup! is visible
   When Enter "Kevin Lee" and "kevin.lee@gmail.com" address
   And Click Signup button
   Then Verify that ENTER ACCOUNT INFORMATION is visible
   Given Fill details: Title, Name, Email, Password, Date of birth
    |password  |day|month|year|
    |pasword123|25 |March|1988|
   When Select checkbox Sign up for our newsletter!
   Then Select checkbox Receive special offers from our partners!
   And Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
    |firstName|lastName|Company    |Address |Address2|Country      |State   |City      |Zip   |MobileNumber|
    |Kevin    |Lee     |TechCenture|123 Main|Ste 200 |United States|Michigan|Farmington|48336 |2482270239  |
   When Click Create Account button
   And Verify that ACCOUNT CREATED! is visible
   Then Click Continue button
   And Verify that Logged in as username is visible



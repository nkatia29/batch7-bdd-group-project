Feature: log in functionality

 Background:
  Given Launch browser chrome and Navigate to automationexercise.com
  And Verify that home page is visible successfully
  Then Click on SignupLogin button
  When Verify Login to your account is visible


  Scenario: register user functionality
   Given Verify New User Signup! is visible
   When Enter "Kevin Lee" and "kevin.lee@gmail.com" address
   And Click Signup button
   Then Verify that ENTER ACCOUNT INFORMATION is visible
   Given Fill details: Title, Name, Email, Password, Date of birth
    |password   |day|month|year|
    |password123|25 |March|1988|
   When Select checkbox Sign up for our newsletter!
   Then Select checkbox Receive special offers from our partners!
   And Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
    |firstName|lastName|Company    |Address |Address2|Country      |State   |City      |Zip   |MobileNumber|
    |Kevin    |Lee     |TechCenture|123 Main|Ste 200 |United States|Michigan|Farmington|48336 |2482270239  |
   When Click Create Account button
   And Verify that ACCOUNT CREATED! is visible
   Then Click Continue button
   And Verify that Logged in as "Kevin Lee" is visible


 Scenario: Positive scenario with correct email and password
  Then  Enter username email and password correctly
  Then Click login button
  Then Verify that Logged in as username is visible


 Scenario: Negative scenario  with incorrect email and password

 Then  Enter "kevin.lee@gmail.com" email address and "kevin123" incorrect password
  Then Click login button
 Then Verify error Your email or password is incorrect! is visible

 Scenario: Logout User

  Then  Enter  "kevin.lee@gmail.com" email and "password123" password correctly
  Then Click login button
  Then Verify that Logged in as username is visible
  Then Click Logout account button
  Then Verify that user is navigated to login page


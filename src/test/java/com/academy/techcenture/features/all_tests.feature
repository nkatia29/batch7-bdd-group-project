Feature: all tests functionality

 Background:
  Given Launch browser chrome and Navigate to automationexercise.com
  And Verify that home page is visible successfully
  Then Click on Signup button
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
 Then  Enter  "kevin.lee@gmail.com" email and "password123" password correctly
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

 Scenario: Contact Us Form

 When Click on Contact Us button
 Then Verify GET IN TOUCH is visible
 Then Enter name, email, subject and message
  |name |email              |subject       |message    |
  |Kevin|kevin.lee@gmail.com|Products issue|Any message|
 Then Upload file
 Then Click Submit button
 When Click OK button
 Then Verify success message Success! Your details have been submitted successfully. is visible
 Then Click Home button and verify that landed to home page successfully



 Scenario: Download Invoice after purchase order
  Then Add products to cart
  Given Click Cart button
  And Verify that cart page is displayed
  And Click Proceed To Checkout
  Then Click Register button
  When Fill all details in Signup and create account
   |name     |email              |password   |day|month|year|firstName|lastName|address    |country      |state   |city|zip  |cell      |
   |Bob Smitt|bob.smitt@gmail.com|password123|15 |April|1995|Bob      |Smith   |123 Main St|United States|Michigan|Novi|48375|2483336666|
  Then Verify ACCOUNT CREATED! and click Continue button
  Given Verify Logged in as "Bob Smith" at top
  And Click Cart btn
  Then Click Proceed To Checkout button
  When Verify Address Details and Review Your Order
  And Enter description in comment text area and click Place Order
  Given Enter payment details: Name on Card, Card Number, CVC, Expiration date
   |name     |cardNumber     |cvc|expDate|year|
   |Bob Smitt|123456789123456|456|02     |2026|
  When Click Pay and Confirm Order button
  Then Verify success message Your order has been placed successfully!
  And  Click Download Invoice button and verify invoice is downloaded successfully.
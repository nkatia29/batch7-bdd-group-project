Feature: tests 6-12 functionality

  Background:
    Given Launch browser chrome and Navigate to automationexercise.com
    And Verify that home page is visible successfully



Scenario:Contact Us Form
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
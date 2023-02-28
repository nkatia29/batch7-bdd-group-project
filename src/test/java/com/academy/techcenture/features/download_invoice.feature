Feature: download invoice functionality


  Scenario: Download Invoice after purchase order

Given Launch browser chrome and Navigate to automationexercise.com
And Verify that home page is visible successfully
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
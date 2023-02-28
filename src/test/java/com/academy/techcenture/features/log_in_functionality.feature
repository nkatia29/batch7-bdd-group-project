Feature: log in functionality

 Background:
  Given Launch browser chrome and Navigate to automationexercise.com
  And Verify that home page is visible successfully
  Then Click on SignupLogin button



 Scenario: Positive scenario with correct email and password
  Then  Enter "kevin.lee@gmail.com" and "password123" correctly
  Then Click login button
  Then Verify that Logged in as username is visible


 Scenario: Negative scenario  with incorrect email and password

 Then  Enter "kevin.lee@gmail.com" email address and "kevin123" incorrect password
  Then Click login button
 Then Verify error Your email or password is incorrect! is visible

 Scenario: Logout User

  Then Enter "kevin.lee@gmail.com" and "password123" correctly
  Then Click login button
  Then Verify that Logged in as username is visible
  Then Click Logout account button
  Then Verify that user is navigated to login page


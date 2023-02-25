Feature: Contact Us form functionality


Scenario:Contact Us Form

Given Launch browser chrome and Navigate to automationexercise.com
And Verify that home page is visible successfully
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


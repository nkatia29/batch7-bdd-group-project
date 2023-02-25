package com.academy.techcenture.stepDefinitions;

import io.cucumber.java.en.Then;

public class LogInTest {

    private LogInTest logInTest;


//Scenario: Positive scenario with correct email and password
    @Then("Enter  {string} email and {string} password correctly")
    public void enterEmailAndPasswordCorrectly(String email, String password) {
        logInTest = new LogInTest();
        logInTest.enterEmailAndPasswordCorrectly(email,password);
    }
    @Then("Click login button")
    public void click_login_button() {
        logInTest = new LogInTest();
        logInTest.click_login_button();

    }

   @Then("Enter  {string} email and {string} password correctlyThen Click login button")
   public void enterEmailAndPasswordCorrectlyThenClickLoginButton(String username, String password) {
       logInTest = new LogInTest();
       logInTest.enterEmailAndPasswordCorrectlyThenClickLoginButton(username, password);
   }
    @Then("Verify that Logged in as username is visible")
    public void verify_that_Logged_in_as_username_is_visible() {
        logInTest = new LogInTest();
        logInTest.verify_that_Logged_in_as_username_is_visible();
    }
    // Scenario: Negative scenario  with incorrect email and password
    @Then("Enter {string} email address and {string} incorrect passwordThen Click login button")
    public void enterEmailAddressAndIncorrectPasswordThenClickLoginButton(String username, String password) {
        logInTest = new LogInTest();
        logInTest.enterEmailAddressAndIncorrectPasswordThenClickLoginButton(username, password);
    }

    @Then("Verify error Your email or password is incorrect! is visible")
    public void verify_error_Your_email_or_password_is_incorrect_is_visible() {
        logInTest = new LogInTest();
        logInTest.verify_error_Your_email_or_password_is_incorrect_is_visible();
    }
// Scenario: Logout User

    @Then("Click Logout account button")
    public void click_Logout_account_button() {
        logInTest = new LogInTest();
        logInTest.click_Logout_account_button();
    }

    @Then("Verify that user is navigated to login page")
    public void verifyThatUserIsNavigatedToLoginPage() {
        logInTest = new LogInTest();
        logInTest.verifyThatUserIsNavigatedToLoginPage();
    }



}




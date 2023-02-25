package com.academy.techcenture.stepDefinitions;

import com.academy.techcenture.Pages.LoginPage;
import com.academy.techcenture.driver.Driver;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

public class LoginSteps {
    private WebDriver driver = Driver.getDriver();
    private LoginPage loginPage;



//Scenario: Positive scenario with correct email and password
    @Then("Click login button")
    public void click_login_button() {
        //loginPage = new LoginPage(driver);
        loginPage.click_login_button();
    }

   @Then("Enter  {string} email and {string} password correctlyThen Click login button")
   public void enterEmailAndPasswordCorrectlyThenClickLoginButton(String username, String password) {
       loginPage = new LoginPage(driver);
       loginPage.enterEmailAndPasswordCorrectlyThenClickLoginButton(username, password);
   }
    @Then("Verify that Logged in as username is visible")
    public void verify_that_Logged_in_as_username_is_visible() {
        //loginPage = new LoginPage(driver);
        loginPage.verify_that_Logged_in_as_username_is_visible();
    }
    // Scenario: Negative scenario  with incorrect email and password

    @Then("Enter {string} email address and {string} incorrect password")
    public void enterEmailAddressAndIncorrectPasswordThenClickLoginButton(String username, String password) {
        loginPage = new LoginPage(driver);;
        loginPage.enterEmailAddressAndIncorrectPasswordThenClickLoginButton(username, password);
    }

    @Then("Verify error Your email or password is incorrect! is visible")
    public void verify_error_Your_email_or_password_is_incorrect_is_visible() {
        loginPage = new LoginPage(driver);
        loginPage.verify_error_Your_email_or_password_is_incorrect_is_visible();
    }


    // Scenario: Logout User
    @Then("Enter  {string} email and {string} password correctly")
    public void enterEmailAndPasswordCorrectly(String email, String pass) {
        loginPage = new LoginPage(driver);
        loginPage.enterEmailAndPasswordCorrectly(email, pass);

}
    @Then("Click Logout account button")
    public void click_Logout_account_button() {

        loginPage.click_Logout_account_button();
    }

    @Then("Verify that user is navigated to login page")
    public void verifyThatUserIsNavigatedToLoginPage() {

        loginPage.verifyThatUserIsNavigatedToLoginPage();
    }



}




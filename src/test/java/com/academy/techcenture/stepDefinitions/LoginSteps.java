package com.academy.techcenture.stepDefinitions;

import com.academy.techcenture.Pages.LoginPage;
import com.academy.techcenture.driver.Driver;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

public class LoginSteps {
    private WebDriver driver = Driver.getDriver();
    private LoginPage loginPage;


    //Positive
    @Then("Enter {string} and {string} correctly")
    public void enterAndCorrectly(String email, String password) {
        loginPage = new LoginPage(driver);
        loginPage.enterCredentialsCorrectly(email, password);
    }


    @Then("Click login button")
    public void click_login_button() {
        loginPage.click_login_button();
    }

    @Then("Verify that Logged in as username is visible")
    public void verify_that_Logged_in_as_username_is_visible() {
        loginPage.verify_that_Logged_in_as_username_is_visible();
    }

    //Negative
    @Then("Enter {string} email address and {string} incorrect password")
    public void enter_email_address_and_incorrect_password(String email, String password) {
        loginPage = new LoginPage(driver);
        loginPage.enterEmailAddressAndIncorrectPasswordThenClickLoginButton(email, password);

    }

    @Then("Verify error Your email or password is incorrect! is visible")
    public void verify_error_Your_email_or_password_is_incorrect_is_visible() {
        loginPage.verify_error_Your_email_or_password_is_incorrect_is_visible();
    }

    //log out

    @Then("Click Logout account button")
    public void click_Logout_account_button() {
        loginPage = new LoginPage(driver);
        loginPage.click_Logout_account_button();
    }

    @Then("Verify that user is navigated to login page")
    public void verify_that_user_is_navigated_to_login_page() {
        loginPage.verifyThatUserIsNavigatedToLoginPage();
    }


}
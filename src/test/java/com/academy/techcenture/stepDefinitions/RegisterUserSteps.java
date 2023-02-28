package com.academy.techcenture.stepDefinitions;

import com.academy.techcenture.Pages.RegisterUserPage;
import com.academy.techcenture.config.ConfigReader;
import com.academy.techcenture.driver.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

public class RegisterUserSteps {
    private static WebDriver driver = Driver.getDriver();
    private RegisterUserPage userPage;

    @Given("Launch browser chrome and Navigate to automationexercise.com")
    public void launch_browser_chrome_and_Navigate_to_automationexercise_com() {
        driver = Driver.getDriver();
        driver.get(ConfigReader.getProperty("url"));

    }

    @Given("Verify that home page is visible successfully")
    public void verify_that_home_page_is_visible_successfully() throws InterruptedException {
        userPage = new RegisterUserPage(driver);
        userPage.verify_that_home_page_is_visible_successfully();
    }

    @Then("Click on Signup button")
    public void click_on_Signup_button() throws InterruptedException {
      userPage.clickSignupButton();
    }

    @When("Verify Login to your account is visible")
    public void verify_Login_to_your_account_is_visible() {

        userPage.verify_Login_to_your_account_is_visible();
    }

    @Given("Verify New User Signup! is visible")
    public void verify_New_User_Signup_is_visible() {
     userPage.verifyNewUserTextIsVisible();
    }

    @When("Enter name and  email address")
    public void enter_name_and_email_address() {
        userPage.enter_name_and_email_address();
    }

    @When("Click Signup button")
    public void click_Signup_button() {
       userPage.clickOnSignupLoginButton();
    }

    @Then("Verify that ENTER ACCOUNT INFORMATION is visible")
    public void verify_that_ENTER_ACCOUNT_INFORMATION_is_visible() {
        userPage.verifyThatACCOUNTCREATEDIsVisible();
    }

    @Given("Fill details: Title, Name, Email, Password, Date of birth")
    public void fill_details_Title_Name_Email_Password_Date_of_birth(List<Map<String, String>> data) {
      userPage.fill_details_Title_Name_Email_Password_Date_of_birth(data);
    }

    @When("Select checkbox Sign up for our newsletter!")
    public void select_checkbox_Sign_up_for_our_newsletter() {

    }


    @Then("Select checkbox Receive special offers from our partners!")
    public void select_checkbox_Receive_special_offers_from_our_partners() {
      userPage.selectCheckboxReceiveSpecialOffersFromOurPartners();
    }


    @Then("Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number")
    public void fill_details_First_name_Last_name_Company_Address_Address2_Country_State_City_Zipcode_Mobile_Number(List<Map<String, String>> data) {
      userPage.fill_details_First_name_Last_name_Company_Address_Address2_Country_State_City_Zipcode_Mobile_Number(data);
    }
    @When("Click Create Account button")
    public void click_Create_Account_button() {
       userPage.clickCreateAccountButton();
    }

    @When("Verify that ACCOUNT CREATED! is visible")
    public void verify_that_ACCOUNT_CREATED_is_visible() {
        userPage.verifyThatACCOUNTCREATEDIsVisible();
    }

    @Then("Click Continue button")
    public void click_Continue_button() {
        userPage.clickContinueButton();
    }

    @Then("Verify that Logged in as {string} is visible")
    public void verify_that_Logged_in_as_is_visible(String username) {
      userPage.verifyThatLoggedInAsUsernameIsVisible(username);
    }




}

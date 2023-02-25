package com.academy.techcenture.stepDefinitions;

import com.academy.techcenture.Pages.LoginPage;
import com.academy.techcenture.Pages.RegisterUserPage;
import com.academy.techcenture.config.ConfigReader;
import com.academy.techcenture.driver.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import java.util.List;
import java.util.Map;

public class RegisterUserSteps {
    private WebDriver driver;
    private RegisterUserPage userPage;

    private LoginPage loginPage;

    @Given("Launch browser chrome and Navigate to automationexercise.com")
    public void launchBrowserChromeAndNavigateToAutomationexerciseCom() {
        System.out.println("Step 0");
        driver = Driver.getDriver();
        System.out.println("Step 1");
        driver.get(ConfigReader.getProperty("url"));
    }

    @And("Verify that home page is visible successfully")
    public void verify_that_home_page_is_visible_successfully() {
        userPage = new RegisterUserPage(driver);
        System.out.println("Step 2");
        userPage.getTitleOnHomePage();
    }


    @Then("Click on Signup button")
    public void clickOnSignupLoginButton() {
       // userPage = new RegisterUserPage(driver);
        userPage.clickOnSignupLoginButton();
    }

    @Given("Verify New User Signup! is visible")
    public void verifyNewUserTextIsVisible() {
        userPage = new RegisterUserPage(driver);
        userPage.verifyNewUserTextIsVisible();

    }

    @When("Enter {string} and {string} address")
    public void enter_and_address(String name, String email) {
        userPage = new RegisterUserPage(driver);
        userPage.enter_and_address(name,email);

    }

    @And("Click Signup button")
    public void clickSignupButton() throws InterruptedException {
        userPage = new RegisterUserPage(driver);
        userPage.clickSignupButton();
        Thread.sleep(1_000);

    }

    @Then("Verify that ENTER ACCOUNT INFORMATION is visible")
    public void verifyThatIsVisible() throws InterruptedException {
        Thread.sleep(2_000);
        userPage = new RegisterUserPage(driver);
        userPage.verifyThatIsVisible();

    }

    @Given("Fill details: Title, Name, Email, Password, Date of birth")
    public void fill_details_Title_Name_Email_Password_Date_of_birth(List<Map<String, String>> data) {
        userPage = new RegisterUserPage(driver);
        userPage.fill_details_Title_Name_Email_Password_Date_of_birth(data);

    }

    @When("Select checkbox Sign up for our newsletter!")
    public void selectCheckboxSignUpForOurNewsletter() {
        userPage=new RegisterUserPage(driver);
        userPage.selectCheckboxSignUpForOurNewsletter();

    }

    @Then("Select checkbox Receive special offers from our partners!")
    public void selectCheckboxReceiveSpecialOffersFromOurPartners() {
        userPage=new RegisterUserPage(driver);
        userPage.selectCheckboxReceiveSpecialOffersFromOurPartners();

    }

    @And("Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number")
    public void fill_details_First_name_Last_name_Company_Address_Address2_Country_State_City_Zipcode_Mobile_Number(List<Map<String, String>> data) {
        userPage = new RegisterUserPage(driver);
        userPage.fill_details_First_name_Last_name_Company_Address_Address2_Country_State_City_Zipcode_Mobile_Number(data);
    }

    @When("Click Create Account button")
    public void clickCreateAccountButton() {
        userPage = new RegisterUserPage(driver);
        userPage.clickCreateAccountButton();
    }
    @And("Verify that ACCOUNT CREATED! is visible")
    public void verifyThatACCOUNTCREATEDIsVisible() {
        userPage = new RegisterUserPage(driver);
        userPage.verifyThatACCOUNTCREATEDIsVisible();
    }

    @Then("Click Continue button")
    public void clickContinueButton() {
        userPage = new RegisterUserPage(driver);
        userPage.clickContinueButton();
    }

    @And("Verify that Logged in as {string} is visible")
    public void verifyThatLoggedInAsUsernameIsVisible(String username) {
        userPage = new RegisterUserPage(driver);
        userPage.verifyThatLoggedInAsUsernameIsVisible(username);

    }
    @When("Verify Login to your account is visible")
    public void verifyLoginToYourAccountIsVisible() {
        //userPage = new RegisterUserPage(driver);
        userPage.verifyLoginToYourAccountIsVisible();
    }

    @Then("Enter username email and password correctly")
    public void enter_username_email_and_password_correctly() {
        loginPage = new LoginPage(driver);
        loginPage.enterEmailAndPasswordCorrectly("kevin.lee@gmail.com","kevin123");
    }
}

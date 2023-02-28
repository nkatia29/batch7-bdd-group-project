package com.academy.techcenture.Pages;

import com.academy.techcenture.driver.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private static WebDriver driver = Driver.getDriver();

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy (xpath = "//input[@placeholder='Name']")
    public WebElement nameInput;
    @FindBy(xpath = "//input[@data-qa='login-email']")
    public  WebElement emailInput;
    @FindBy (xpath = "//input[@placeholder='Password']")
    public WebElement passwordInput;
    @FindBy (xpath = "//button[@data-qa='login-button']")
    public WebElement logInBtn;
    @FindBy (xpath = "//li[10]//a[1]")
    public WebElement loggedInText;
    @FindBy (xpath = "//p[text ()='Your email or password is incorrect!']")
    public WebElement errorText;
    @FindBy (xpath = "//p[text ()='Your email or password is incorrect!']")
    public WebElement logOutBtn;



    public void enterEmailAndPasswordCorrectly(String email, String password) {
        nameInput.sendKeys(email);
        passwordInput.sendKeys(password);
    }

    public void click_login_button() {
       logInBtn.click();
    }
    // Scenario: Positive scenario with correct email and password

    public void enterEmailAndPasswordCorrectlyThenClickLoginButton(String username, String password) {
        emailInput.sendKeys(username);  passwordInput.sendKeys(password);
    }

    public void verify_that_Logged_in_as_username_is_visible() {

        Assert.assertTrue(loggedInText.isDisplayed());
    }
    // Scenario: Negative scenario  with incorrect email and password

    public void enterEmailAddressAndIncorrectPasswordThenClickLoginButton(String username, String password) {
        emailInput.sendKeys(username); passwordInput.sendKeys(password);
    }


    public void verify_error_Your_email_or_password_is_incorrect_is_visible() {
        Assert.assertTrue(errorText.isDisplayed());
    }
// Scenario: Logout User


    public void click_Logout_account_button() {
       logOutBtn.click();
    }


    public void verifyThatUserIsNavigatedToLoginPage() {
        String loginPageTitle = driver.getTitle();
        Assert.assertEquals("Automation Exercise - Signup / Login", loginPageTitle);


    }



}




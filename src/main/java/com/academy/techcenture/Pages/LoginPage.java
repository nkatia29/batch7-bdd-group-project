package com.academy.techcenture.Pages;

import com.academy.techcenture.driver.Driver;
import com.github.javafaker.Faker;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private static WebDriver driver = Driver.getDriver();
    RegisterUserPage userPage;
    Faker faker;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
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
    @FindBy (xpath = "//a[normalize-space()='Logout']")
    public WebElement logOutBtn;




    public void enterCredentialsCorrectly(String email, String password) {
        emailInput.sendKeys(email); passwordInput.sendKeys(password);
    }


    public void click_login_button() {
        logInBtn.click();
    }


    public void verify_that_Logged_in_as_username_is_visible() {

        Assert.assertTrue(loggedInText.isDisplayed());
    }


    public void enterEmailAddressAndIncorrectPasswordThenClickLoginButton(String username, String password) {
        emailInput.sendKeys(username); passwordInput.sendKeys(password);
    }


    public void verify_error_Your_email_or_password_is_incorrect_is_visible() {
        Assert.assertTrue(errorText.isDisplayed());
    }



    public void click_Logout_account_button() {
       logOutBtn.click();
    }


    public void verifyThatUserIsNavigatedToLoginPage() {
        String loginPageTitle = driver.getTitle();
        Assert.assertEquals("Automation Exercise - Signup / Login", loginPageTitle);


    }



}




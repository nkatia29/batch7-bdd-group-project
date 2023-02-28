package com.academy.techcenture.stepDefinitions;

import com.academy.techcenture.Pages.DownloadInvoicePage;
import com.academy.techcenture.driver.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.util.List;
import java.util.Map;

public class DowloadInvoiceSteps {
    private static WebDriver driver = Driver.getDriver();
    private WebDriverWait wait;
    private File file;

    private DownloadInvoicePage downloadInvoicePage;

    //Download invoice test

    @Then("Add products to cart")
    public void addProductsToCart() throws InterruptedException {
     downloadInvoicePage = new DownloadInvoicePage(driver);
     downloadInvoicePage.addProductsToCart();

    }

    @Given("Click Cart button")
    public void clickCartButton() {

        downloadInvoicePage.clickCartButton();
    }

    @And("Verify that cart page is displayed")
    public void verifyThatCartPageIsDisplayed() {

        downloadInvoicePage.verifyThatCartPageIsDisplayed();
    }

    @And("Click Proceed To Checkout")
    public void clickProceedToCheckout() {

        downloadInvoicePage.clickProceedToCheckout();
    }

    @Then("Click Register button")
    public void clickRegisterButton() {

        downloadInvoicePage.clickRegisterButton();

    }

    @When("Fill all details in Signup and create account")
    public void fillAllDetailsInSignupAndCreateAccount(List<Map<String, String>> data) {
       ;
        downloadInvoicePage.fillAllDetailsInSignupAndCreateAccount(data);
    }

    @Then("Verify ACCOUNT CREATED! and click Continue button")
    public void verifyACCOUNTCREATEDAndClickContinueButton() {

        downloadInvoicePage.verifyACCOUNTCREATEDAndClickContinueButton();
    }
    @Given("Verify Logged in as {string} at top")
    public void verifyLoggedInAsAtTop(String username) {

        downloadInvoicePage.verifyLoggedInAsAtTop(username);
    }
    @Then("Click Cart btn")
    public void clickCartBtn() {

        downloadInvoicePage.clickCartBtn();
    }

    @Then("Click Proceed To Checkout button")
    public void clickProceedToCheckoutButton() {

        downloadInvoicePage.clickProceedToCheckoutButton();
    }

    @When("Verify Address Details and Review Your Order")
    public void verifyAddressDetailsAndReviewYourOrder() {

    }

    @And("Enter description in comment text area and click Place Order")
    public void enterDescriptionInCommentTextAreaAndClickPlaceOrder() {

        downloadInvoicePage.enterDescriptionInCommentTextAreaAndClickPlaceOrder();

    }

    @Given("Enter payment details: Name on Card, Card Number, CVC, Expiration date")
    public void enterPaymentDetailsNameOnCardCardNumberCVCExpirationDate(List<Map<String, String>> data) {

        downloadInvoicePage.enterPaymentDetailsNameOnCardCardNumberCVCExpirationDate(data);
    }

    @When("Click Pay and Confirm Order button")
    public void clickPayAndConfirmOrderButton() {

        downloadInvoicePage.clickPayAndConfirmOrderButton();
    }

    @Then("Verify success message Your order has been placed successfully!")
    public void verifySuccessMessageYourOrderHasBeenPlacedSuccessfully() {
        try{
            wait = new WebDriverWait(driver,20);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Your order has been placed successfully!')]")));
        }catch(Throwable e){
            System.err.println("Error while waiting for the notification to appear: "+ e.getMessage());
        }

    }

    @And("Click Download Invoice button and verify invoice is downloaded successfully.")
    public void clickDownloadInvoiceButtonAndVerifyInvoiceIsDownloadedSuccessfully() {

        downloadInvoicePage.clickDownloadInvoiceButtonAndVerifyInvoiceIsDownloadedSuccessfully();

    }




}

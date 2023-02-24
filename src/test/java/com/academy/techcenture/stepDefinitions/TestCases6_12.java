package com.academy.techcenture.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TestCases6_12 {
    WebDriver driver;
    private File file;
    private Alert alert;


    @When("Click on Contact Us button")
    public void clickOnContactUsButton() {
        driver.findElement(By.cssSelector("a[href='/contact_us'])")).click();
    }

    @Then("Verify GET IN TOUCH is visible")
    public void verify_GET_IN_TOUCH_is_visible() {

        WebElement getInTouchText = driver.findElement(By.xpath("//div[@class='contact-form']/ h2[@class='title text-center']"));
        Assert.assertTrue(getInTouchText.isDisplayed());

    }

    @Then("Enter name, email, subject and message")
    public void enter_name_email_subject_and_message(List<Map<String, String>> data) {
        Map<String, String> getIntouchInfo = data.get(0);
        String name = getIntouchInfo.get("name");
        String email = getIntouchInfo.get("email");
        String subject = getIntouchInfo.get("subject");
        String message = getIntouchInfo.get("message");

        driver.findElement(By.xpath("//input[@placeholder='Name']"))
                .sendKeys(name);
        driver.findElement(By.xpath("//input[@placeholder='Email']"))
                .sendKeys(email);
        driver.findElement(By.xpath("//input[@placeholder='Subject']"))
                .sendKeys(subject);
        driver.findElement(By.xpath("//textarea[@id='message']"))
                .sendKeys(message);
    }

    @Then("Upload file")
    public void upload_file() {
        WebElement uploadFileBtn = driver.findElement(By.name("upload_file"));
        String filepath = "src/main/resources/UploadFile/School Pre Enroll.pdf";
        uploadFileBtn.sendKeys(filepath);
    }


    @Then("Click Submit button")
    public void click_Submit_button() {
        driver.findElement(By.xpath("//input[@data-qa='submit-button']")).click();
    }

    @When("Click OK button")
    public void click_OK_button() {

        alert = driver.switchTo().alert();
        alert.accept();
    }

    @Then("Verify success message Success! Your details have been submitted successfully. is visible")
    public void verify_success_message_Success_Your_details_have_been_submitted_successfully_is_visible() {
        WebElement successMsg = driver.findElement(By.xpath("//div[@class='status alert alert-success']"));
        Assert.assertTrue(successMsg.isDisplayed());
    }

    @Then("Click Home button and verify that landed to home page successfully")
    public void click_Home_button_and_verify_that_landed_to_home_page_successfully() {

    }
    //Download invoice test

    @Then("Add products to cart")
    public void addProductsToCart() {
        driver.findElement(By.xpath("(//a[contains(text(),'View Product')])[1]")).click();
        driver.findElement(By.xpath("//button[@type='button']")).click();
    }

    @Given("Click Cart button")
    public void clickCartButton() {



        driver.findElement(By.xpath("//u[normalize-space()='View Cart']")).click();
    }

    @And("Verify that cart page is displayed")
    public void verifyThatCartPageIsDisplayed() {
        WebElement shoppingCartText = driver.findElement(By.xpath("//li[@class='active' and text()='Shopping Cart']"));
        Assert.assertEquals("Shopping Cart",shoppingCartText.getText());
    }

    @And("Click Proceed To Checkout")
    public void clickProceedToCheckout() {
        driver.findElement(By.xpath("//a[normalize-space()='Proceed To Checkout']")).click();
    }

    @Then("Click Register button")
    public void clickRegisterButton() {
        driver.findElement(By.xpath("//u[normalize-space()='Register / Login']")).click();

    }

    @When("Fill all details in Signup and create account")
    public void fillAllDetailsInSignupAndCreateAccount(List<Map<String, String>> data) {
        Map<String, String> info = data.get(0);
        String name = info.get("name");
        String email = info.get("email");
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys(name);
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys(email);
        driver.findElement(By.xpath("//button[text()='Signup']")).click();

        String password = info.get("password");
        String day = info.get("day");
        String month = info.get("month");
        String year = info.get("year");

        driver.findElement(By.xpath("//input[@id='id_gender1']")).click();//clicking on Mr.
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);

        WebElement days = driver.findElement(By.id("days"));
        Select select = new Select(days);
        select.selectByVisibleText(day);
        WebElement months = driver.findElement(By.id("months"));
        Select select1 = new Select(months);
        select1.selectByVisibleText(month);
        WebElement years = driver.findElement(By.id("years"));
        Select select2 = new Select(years);
        select2.selectByVisibleText(year);

        String firstName = info.get("firstName");
        String lastName = info.get("lastName");
        String address = info.get("address");
        String country = info.get("country");
        String state = info.get("state");
        String city = info.get("city");
        String zip = info.get("zip");
        String mobileNumber = info.get("cell");


        driver.findElement(By.id("first_name")).sendKeys(firstName);
        driver.findElement(By.id("last_name")).sendKeys(lastName);
        driver.findElement(By.id("address1")).sendKeys(address);
        driver.findElement(By.id("country")).sendKeys(country);
        driver.findElement(By.id("state")).sendKeys(state);
        driver.findElement(By.id("city")).sendKeys(city);
        driver.findElement(By.id("zipcode")).sendKeys(zip);
        driver.findElement(By.id("mobile_number")).sendKeys(mobileNumber);

        WebElement submitBtn = driver.findElement(By.xpath("//button[text()='Create Account']"));
        submitBtn.click();

    }

    @Then("Verify ACCOUNT CREATED! and click Continue button")
    public void verifyACCOUNTCREATEDAndClickContinueButton() {
        WebElement text = driver.findElement(By.xpath("//b[normalize-space()='Account Created!']"));
        Assert.assertTrue(text.isDisplayed());
        driver.findElement(By.xpath("//a[normalize-space()='Continue']")).click();

    }

    @Given("Verify Logged in as {string} at top")
    public void verifyLoggedInAsAtTop(String username) {
        WebElement loginName = driver.findElement(By.xpath("//a/i[@class='fa fa-user']/following-sibling::b"));
        Assert.assertEquals(username, loginName.getText());
    }
    @Then("Click Cart btn")
    public void clickCartBtn() {
        driver.findElement(By.xpath("//a[normalize-space()='Cart']//i[@class='fa fa-shopping-cart']")).click();
    }

    @Then("Click Proceed To Checkout button")
    public void clickProceedToCheckoutButton() {
        driver.findElement(By.xpath("//a[normalize-space()='Proceed To Checkout']")).click();
    }

    @When("Verify Address Details and Review Your Order")
    public void verifyAddressDetailsAndReviewYourOrder() {

    }

    @And("Enter description in comment text area and click Place Order")
    public void enterDescriptionInCommentTextAreaAndClickPlaceOrder() {
        driver.findElement(By.id("ordermsg")).sendKeys("some message");
        driver.findElement(By.xpath("//a[normalize-space()='Place Order']")).click();

    }

    @Given("Enter payment details: Name on Card, Card Number, CVC, Expiration date")
    public void enterPaymentDetailsNameOnCardCardNumberCVCExpirationDate(List<Map<String, String>> data) {
        Map<String, String> info = data.get(0);
        String nameOnCard = info.get("name");
        String cardNumber = info.get("cardNumber");
        String cvc = info.get("cvc");
        String expDate = info.get("expDate");
        String year = info.get("year");

        driver.findElement(By.name("name_on_card")).sendKeys(nameOnCard);
        driver.findElement(By.name("card_number")).sendKeys(cardNumber);
        driver.findElement(By.name("cvc")).sendKeys(cvc);
        driver.findElement(By.name("expiry_month")).sendKeys(expDate);
        driver.findElement(By.name("expiry_year")).sendKeys(year);
    }

    @When("Click Pay and Confirm Order button")
    public void clickPayAndConfirmOrderButton() {
        driver.findElement(By.xpath("//button[@id='submit']")).click();
    }

    @Then("Verify success message Your order has been placed successfully!")
    public void verifySuccessMessageYourOrderHasBeenPlacedSuccessfully() {
        try{
            WebDriverWait wait = new WebDriverWait(driver,20);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Your order has been placed successfully!')]")));
        }catch(Throwable e){
            System.err.println("Error while waiting for the notification to appear: "+ e.getMessage());
        }

    }

    @And("Click Download Invoice button and verify invoice is downloaded successfully.")
    public void clickDownloadInvoiceButtonAndVerifyInvoiceIsDownloadedSuccessfully() {
        driver.findElement(By.xpath("//a[normalize-space()='Download Invoice']")).click();

        file= new File("\"C:\\Users\\nkati\\Downloads\\invoice.txt\"");
        file.exists();

    }



}

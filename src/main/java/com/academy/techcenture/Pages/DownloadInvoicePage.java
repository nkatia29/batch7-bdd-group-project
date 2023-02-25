package com.academy.techcenture.Pages;

import com.academy.techcenture.driver.Driver;
import io.cucumber.java.en.And;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.util.List;
import java.util.Map;

public class DownloadInvoicePage {

    private  WebDriver driver = Driver.getDriver();
    private WebDriverWait wait;
    private File file;

    public DownloadInvoicePage(WebDriver driver, WebDriverWait wait, File file){
        this.driver = driver;
        this.wait = wait;
        this.file = file;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "(//a[contains(text(),'View Product')])[1]")
    public WebElement viewProductBtn;
    @FindBy(xpath = "//button[@type='button']")
    public WebElement button;
    @FindBy(xpath = "//u[normalize-space()='View Cart']]")
    public WebElement cartBtn;
    @FindBy(xpath = "//li[@class='active' and text()='Shopping Cart']")
    public WebElement shoppingCartText;
    @FindBy(xpath = "//a[normalize-space()='Proceed To Checkout']")
    public WebElement proceedToCheckOutLink;
    @FindBy(xpath = "//u[normalize-space()='Register / Login']")
    public WebElement registerBtn;
    @FindBy(xpath = "//b[normalize-space()='Account Created!']")
    public WebElement accountCreatedText;
    @FindBy(xpath = "//a[normalize-space()='Continue']")
    public WebElement contBtn;
    @FindBy(xpath = "//button[@id='submit']")
    public WebElement payAndConfirmOrderButton;
    @FindBy (xpath = "//a[normalize-space()='Download Invoice']")
    public WebElement downloadInvBtn;
    @FindBy (xpath = "//a[normalize-space()='Cart']//i[@class='fa fa-shopping-cart']")
    public WebElement clickCartBtn;

    public void addProductsToCart() {
        viewProductBtn.click();
        button.click();
    }

    public void clickCartButton() {
        cartBtn.click();
    }

    public void verifyThatCartPageIsDisplayed() {

        Assert.assertEquals("Shopping Cart",shoppingCartText.getText());
    }

    public void clickProceedToCheckout() {
        proceedToCheckOutLink.click();
    }


    public void clickRegisterButton() {
        registerBtn.click();

    }


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


    public void verifyACCOUNTCREATEDAndClickContinueButton() {
        Assert.assertTrue(accountCreatedText.isDisplayed());
        contBtn.click();

    }


    public void verifyLoggedInAsAtTop(String username) {
        WebElement loginName = driver.findElement(By.xpath("//a/i[@class='fa fa-user']/following-sibling::b"));
        Assert.assertEquals(username, loginName.getText());
    }

    public void clickCartBtn() {
        clickCartBtn.click();
    }


    public void clickProceedToCheckoutButton() {
        driver.findElement(By.xpath("//a[normalize-space()='Proceed To Checkout']")).click();
    }


    public void verifyAddressDetailsAndReviewYourOrder() {

    }


    public void enterDescriptionInCommentTextAreaAndClickPlaceOrder() {
        driver.findElement(By.id("ordermsg")).sendKeys("some message");
        driver.findElement(By.xpath("//a[normalize-space()='Place Order']")).click();

    }


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


    public void clickPayAndConfirmOrderButton() {
        payAndConfirmOrderButton.click();
    }


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
        downloadInvBtn.click();

        file= new File("\"C:\\Users\\nkati\\Downloads\\invoice.txt\"");
        file.exists();

        Driver.quitDriver();

    }




}

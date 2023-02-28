package com.academy.techcenture.Pages;

import com.academy.techcenture.config.ConfigReader;
import com.academy.techcenture.driver.Driver;
import com.github.javafaker.Faker;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;

;

public class RegisterUserPage {

    private static WebDriver driver = Driver.getDriver();
    Faker faker;

    public RegisterUserPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//button[text()='Signup']")
    public WebElement signUpBtn;
    @FindBy (xpath ="//a[normalize-space()='Signup / Login']" )
    public WebElement signUpLoginBtn;
    @FindBy (xpath = "//h2[contains(.,'New User Signup!')]")
    public WebElement newUserVisibleTxt;
    @FindBy (xpath = "//input[@data-qa='signup-name']")
    public WebElement nameInput;
    @FindBy(xpath = "//input[@data-qa='signup-email']")
    public WebElement eMail;
    @FindBy(xpath = "//a/i[@class='fa fa-user']/following-sibling::b")
    public WebElement loginUsernameText;




   public void verify_that_home_page_is_visible_successfully() throws InterruptedException {
       Thread.sleep(1_000);
       Assert.assertEquals("Automation Exercise", driver.getTitle());

   }

    public void clickOnSignupLoginButton() throws InterruptedException {
       Thread.sleep(2_000);
        signUpLoginBtn.click();
    }

    public void verifyNewUserTextIsVisible() {

       Assert.assertTrue(newUserVisibleTxt.isDisplayed());
    }


    String name1;
    public void enter_name_and_email_address()  {

        faker = new Faker();

        name1 = faker.name().firstName();
        String emailAddress = faker.internet().emailAddress();
        ConfigReader.setProperty(emailAddress,"email");
        ConfigReader.setProperty(name1,"name");

        nameInput.sendKeys(name1);
        eMail.sendKeys(emailAddress);

    }



    public void clickSignupButton() throws InterruptedException {
        signUpBtn.click();
        Thread.sleep(1_000);

    }


//    public void verify_Login_to_your_account_is_visible () {
//        WebElement enterAccountInfoText = driver.findElement(By.xpath("//div/h2/b[text()='Enter Account Information']"));
//        Assert.assertTrue(enterAccountInfoText.isDisplayed());
//
//    }



    public void fill_details_Title_Name_Email_Password_Date_of_birth(List<Map<String, String>> data) {
        Map<String, String> info = data.get(0);

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

    }


    public void selectCheckboxSignUpForOurNewsletter() {
        driver.findElement(By.xpath("//input[@id='newsletter']")).click();
    }


    public void selectCheckboxReceiveSpecialOffersFromOurPartners() {

        driver.findElement(By.id("optin")).click();
    }


    public void fill_details_First_name_Last_name_Company_Address_Address2_Country_State_City_Zipcode_Mobile_Number(List<Map<String, String>> data) {
        Map<String, String> info = data.get(0);
        String firstName = info.get("firstName");
        String lastName = info.get("lastName");
        String company = info.get("Company");
        String address = info.get("Address");
        String address2 = info.get("Address2");
        String country = info.get("Country");
        String state = info.get("State");
        String city = info.get("City");
        String zip = info.get("Zip");
        String mobileNumber = info.get("MobileNumber");


        driver.findElement(By.id("first_name")).sendKeys(firstName);
        driver.findElement(By.id("last_name")).sendKeys(lastName);
        driver.findElement(By.id("company")).sendKeys(company);
        driver.findElement(By.id("address1")).sendKeys(address);
        driver.findElement(By.id("address2")).sendKeys(address2);
        driver.findElement(By.id("country")).sendKeys(country);
        driver.findElement(By.id("state")).sendKeys(state);
        driver.findElement(By.id("city")).sendKeys(city);
        driver.findElement(By.id("zipcode")).sendKeys(zip);
        driver.findElement(By.id("mobile_number")).sendKeys(mobileNumber);

    }


    public void clickCreateAccountButton() {
        driver.findElement(By.xpath("//button[normalize-space()='Create Account']")).click();
    }

    public void verifyThatACCOUNTCREATEDIsVisible() {
        Assert.assertTrue(driver.findElement(By.xpath("//b[normalize-space()='Account Created!']")).isDisplayed());
    }


    public void clickContinueButton() {
        driver.findElement(By.xpath("//div/a[@data-qa='continue-button']")).click();
    }



    public void verifyThatLoggedInAsUsernameIsVisible() {

        Assert.assertEquals(name1, loginUsernameText.getText());

    }








}

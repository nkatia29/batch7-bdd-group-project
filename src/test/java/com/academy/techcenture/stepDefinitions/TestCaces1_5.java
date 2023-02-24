package com.academy.techcenture.stepDefinitions;

import com.academy.techcenture.config.ConfigReader;
import com.academy.techcenture.driver.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class TestCaces1_5 {
    private static WebDriver driver;
    private WebDriverWait wait;

    public TestCaces1_5(WebDriver driver){
        this.driver = driver;
        this.wait= new WebDriverWait(this.driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);

    }
  @FindBy (xpath = "//button[text()='Signup']")
  public WebElement signUpBtn;
  @FindBy (xpath ="//a[normalize-space()='Signup / Login']" )
  public WebElement signUpLoginBtn;
  @FindBy (xpath = "//h2[normalize-space()='New User Signup!']")
  public WebElement newUserVisibleTxt;
  @FindBy (xpath = "//input[@name='name']")
  public WebElement fullName;
  @FindBy(xpath = "//input[@data-qa='signup-email']")
  public WebElement eMail;

    @Given("Launch browser chrome and Navigate to automationexercise.com")
    public void launchBrowserChromeAndNavigateToAutomationexerciseCom() {
        driver = Driver.getDriver();
        driver.get(ConfigReader.getProperty("url"));
    }

    @And("Verify that home page is visible successfully")
    public void verify_that_home_page_is_visible_successfully() {
        Assert.assertEquals("Automation Exercise", driver.getTitle());
    }


    @Then("Click on Signup button")
    public void clickOnSignupLoginButton() {
        signUpLoginBtn.click();
    }

    @Given("Verify New User Signup! is visible")
    public void verifyNewUserTextIsVisible() {
        Assert.assertTrue(newUserVisibleTxt.isDisplayed());
    }

    @When("Enter {string} and {string} address")
    public void enter_and_address(String name, String email) {
        fullName.sendKeys(name); eMail.sendKeys(email);
    }

    @And("Click Signup button")
    public void clickSignupButton() throws InterruptedException {
        signUpBtn.click();
        Thread.sleep(1_000);

    }

    @Then("Verify that ENTER ACCOUNT INFORMATION is visible")
    public void verifyThatIsVisible() throws InterruptedException {
        Thread.sleep(2_000);
        WebElement enterAccountInfoText = driver.findElement(By.xpath("//div/h2/b[text()='Enter Account Information']"));
        Assert.assertTrue(enterAccountInfoText.isDisplayed());

    }


    @Given("Fill details: Title, Name, Email, Password, Date of birth")
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

    @When("Select checkbox Sign up for our newsletter!")
    public void selectCheckboxSignUpForOurNewsletter() {
        driver.findElement(By.xpath("//input[@id='newsletter']")).click();
    }

    @Then("Select checkbox Receive special offers from our partners!")
    public void selectCheckboxReceiveSpecialOffersFromOurPartners() {
        driver.findElement(By.id("optin")).click();
    }

    @And("Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number")
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


    @When("Click Create Account button")
    public void clickCreateAccountButton() {
        driver.findElement(By.xpath("//button[normalize-space()='Create Account']")).click();
    }
    @And("Verify that ACCOUNT CREATED! is visible")
    public void verifyThatACCOUNTCREATEDIsVisible() {
        Assert.assertTrue(driver.findElement(By.xpath("//b[normalize-space()='Account Created!']")).isDisplayed());
    }

    @Then("Click Continue button")
    public void clickContinueButton() {
        driver.findElement(By.xpath("//div/a[@data-qa='continue-button']")).click();
    }


    @And("Verify that Logged in as {string} is visible")
    public void verifyThatLoggedInAsUsernameIsVisible(String username) {
            WebElement loginName = driver.findElement(By.xpath("//a/i[@class='fa fa-user']/following-sibling::b"));
            Assert.assertEquals(username, loginName.getText());

    }
    @When("Verify Login to your account is visible")
    public void verifyLoginToYourAccountIsVisible() {
        WebElement verifyLoginBtn = driver.findElement(By.xpath("//div[@class='login-form']/h2"));
        Assert.assertTrue(verifyLoginBtn.isDisplayed());
    }

    @Then("Enter  {string} email and {string} password correctly")
    public void enterEmailAndPasswordCorrectly(String email, String password) {

        WebElement emailInput = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        WebElement passwordInput = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
    }

    @Then("Click login button")
    public void click_login_button() {
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();
    }

    @Then("Verify that Logged in as username is visible")
    public void verify_that_Logged_in_as_username_is_visible() {
        WebElement loggedInText = driver.findElement(By.xpath("//li[10]//a[1]"));
        Assert.assertTrue(loggedInText.isDisplayed());
    }
    @Then("Enter {string} email address and {string} incorrect password")
    public void enter_email_address_and_incorrect_password(String email, String password) {
        WebElement emailInput = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        WebElement passwordInput = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
    }
// Scenario: Negative scenario  with incorrect email and password
    @Then("Verify error Your email or password is incorrect! is visible")
    public void verify_error_Your_email_or_password_is_incorrect_is_visible() {
        WebElement errorText = driver.findElement(By.xpath("//p[text ()='Your email or password is incorrect!']"));
        Assert.assertTrue(errorText.isDisplayed());
    }
// Scenario: Logout User
    @Then("Click Logout account button")
    public void click_Logout_account_button() {
   driver.findElement(By.xpath("//a[@href='/logout']")).click();
    }

    @Then("Verify that user is navigated to login page")
    public void verifyThatUserIsNavigatedToLoginPage() {
        String loginPageTitle = driver.getTitle();
        Assert.assertEquals("Automation Exercise - Signup / Login", loginPageTitle);
    }




}




package com.academy.techcenture.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RegisterUserTest {
    private WebDriver driver;


    @Given("Launch browser {string} and Navigate to  {string}")
    public void launchBrowserAndNavigateTo(String browser, String url) {

        if(browser.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            Map<String, Object> prefs = new HashMap<String, Object>();
            prefs.put("autofill.profile_enabled", false);
            prefs.put("profile.password_manager_enabled", false);
            prefs.put("profile.default_content_setting_values.notifications", 2);
            prefs.put("profile.managed_default_content_settings.javascript",2);
            options.setExperimentalOption("prefs", prefs);
            driver = new ChromeDriver(options);
        }
        else if (browser.equals("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver =  new FirefoxDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get(url);
    }


    @And("Verify that home page is visible successfully")
    public void verify_that_home_page_is_visible_successfully() {
        Assert.assertEquals("Automation Exercise", driver.getTitle());
    }


    @Then("Click on Signup button")
    public void clickOnSignupLoginButton() {
        driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']")).click();
    }

    @Given("Verify New User Signup! is visible")
    public void verifyNewUserTextIsVisible() {

        WebElement text = driver.findElement(By.xpath("//h2[normalize-space()='New User Signup!']"));
        Assert.assertTrue(text.isDisplayed());
    }

    @When("Enter {string} and {string} address")
    public void enter_and_address(String name, String email) {
        WebElement fullName = driver.findElement(By.xpath("//input[@name='name']"));
        WebElement eMail = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
        fullName.sendKeys(name); eMail.sendKeys(email);
    }

    @And("Click Signup button")
    public void clickSignupButton() throws InterruptedException {
        driver.findElement(By.xpath("//button[text()='Signup']")).click();
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

    @Then("Verify error Your email or password is incorrect! is visible")
    public void verify_error_Your_email_or_password_is_incorrect_is_visible() {
        WebElement errorText = driver.findElement(By.xpath("//p[text ()='Your email or password is incorrect!']"));
        Assert.assertTrue(errorText.isDisplayed());
    }

    @Then("Click Logout account button")
    public void click_Logout_account_button() {
   driver.findElement(By.xpath("//a[@href='/logout']")).click();
    }

    @Then("Verify that user is navigated to login page")
    public void verifyThatUserIsNavigatedToLoginPage() {
        String loginPageTitle = driver.getTitle();
        Assert.assertEquals("Automation Exercise - Signup / Login", loginPageTitle);
    }


    @When("Click on Contact Us button")
    public void click_on_Contact_Us_button() {
        WebElement contactUsBtn = driver.findElement(By.xpath("//a[@href='/contact_us']"));
       contactUsBtn.click();
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

    }



    @Then("Click Submit button")
    public void click_Submit_button() {

    }

    @When("Click OK button")
    public void click_OK_button() {

    }

    @Then("Verify success message Success! Your details have been submitted successfully. is visible")
    public void verify_success_message_Success_Your_details_have_been_submitted_successfully_is_visible() {

    }

    @Then("Click Home button and verify that landed to home page successfully")
    public void click_Home_button_and_verify_that_landed_to_home_page_successfully() {

    }

}

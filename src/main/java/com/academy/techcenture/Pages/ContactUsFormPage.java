package com.academy.techcenture.Pages;

import com.academy.techcenture.driver.Driver;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Map;

public class ContactUsFormPage {

    private Alert alert;
    private WebDriver driver = Driver.getDriver();

    public ContactUsFormPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

  @FindBy (xpath = "//a[href='/contact_us'])")
    public WebElement contactUsBtn;
  @FindBy (xpath = "//div[@class='contact-form']/ h2[@class='title text-center']")
    public WebElement getInTouchText;
  @FindBy (xpath = "//input[@placeholder='Name']")
    public WebElement nameInput;
  @FindBy (xpath = "//input[@placeholder='Email']")
    public WebElement emailInput;
   @FindBy (xpath = "//input[@placeholder='Subject']")
    public WebElement subjectInput;
   @FindBy (xpath = "//textarea[@id='message']")
    public WebElement msgInput;
    @FindBy (name = "upload_file")
    public WebElement uploadFileBtn;
    @FindBy (xpath = "//input[@data-qa='submit-button']")
    public WebElement submitBtn;
    @FindBy (xpath = "//div[@class='status alert alert-success']")
    public WebElement successMsg;




    public void clickOnContactUsButton() {
        contactUsBtn.click();
    }

    public void verify_GET_IN_TOUCH_is_visible() {
        Assert.assertTrue(getInTouchText.isDisplayed());

    }

    public void enter_name_email_subject_and_message(List<Map<String, String>> data) {
        Map<String, String> getIntouchInfo = data.get(0);
        String name = getIntouchInfo.get("name");
        String email = getIntouchInfo.get("email");
        String subject = getIntouchInfo.get("subject");
        String message = getIntouchInfo.get("message");

        nameInput.sendKeys(name);
        emailInput.sendKeys(email);
        subjectInput.sendKeys(subject);
        msgInput.sendKeys(message);
    }


    public void upload_file() {
        String filepath = "src/main/resources/UploadFile/School Pre Enroll.pdf";
        uploadFileBtn.sendKeys(filepath);
    }



    public void click_Submit_button() {

        submitBtn.click();
    }


    public void click_OK_button() {
        alert = driver.switchTo().alert();
        alert.accept();
    }


    public void verify_success_message_Success_Your_details_have_been_submitted_successfully_is_visible() {

        Assert.assertTrue(successMsg.isDisplayed());
    }


    public void click_Home_button_and_verify_that_landed_to_home_page_successfully() {


     Driver.quitDriver();
    }




}

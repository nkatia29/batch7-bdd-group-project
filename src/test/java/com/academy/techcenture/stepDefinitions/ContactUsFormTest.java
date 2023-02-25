package com.academy.techcenture.stepDefinitions;

import com.academy.techcenture.Pages.ContactUsFormPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Map;


public class ContactUsFormTest {

ContactUsFormPage contactUsFormPage;
   private Alert alert;
   WebDriver driver = new ChromeDriver();
    @When("Click on Contact Us button")
    public void clickOnContactUsButton() {
      contactUsFormPage = new ContactUsFormPage(driver);
      contactUsFormPage.clickOnContactUsButton();
    }

    @Then("Verify GET IN TOUCH is visible")
    public void verify_GET_IN_TOUCH_is_visible() {
        contactUsFormPage = new ContactUsFormPage(driver);
        contactUsFormPage.verify_GET_IN_TOUCH_is_visible();

    }

    @Then("Enter name, email, subject and message")
    public void enter_name_email_subject_and_message(List<Map<String, String>> data) {
        contactUsFormPage = new ContactUsFormPage(driver);
        contactUsFormPage.enter_name_email_subject_and_message(data);
    }

    @Then("Upload file")
    public void upload_file() {
        contactUsFormPage = new ContactUsFormPage(driver);
        contactUsFormPage.upload_file();
    }


    @Then("Click Submit button")
    public void click_Submit_button() {
        contactUsFormPage = new ContactUsFormPage(driver);
        contactUsFormPage.click_Submit_button();
    }

    @When("Click OK button")
    public void click_OK_button() {
        contactUsFormPage = new ContactUsFormPage(driver);
        contactUsFormPage.click_OK_button();

    }

    @Then("Verify success message Success! Your details have been submitted successfully. is visible")
    public void verify_success_message_Success_Your_details_have_been_submitted_successfully_is_visible() {
        contactUsFormPage = new ContactUsFormPage(driver);
        contactUsFormPage.verify_success_message_Success_Your_details_have_been_submitted_successfully_is_visible();
    }

    @Then("Click Home button and verify that landed to home page successfully")
    public void click_Home_button_and_verify_that_landed_to_home_page_successfully() {
        contactUsFormPage = new ContactUsFormPage(driver);

    }



}

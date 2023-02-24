package com.academy.techcenture.stepDefinitions;

import com.academy.techcenture.driver.Driver;
import io.cucumber.java.After;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;



    @RunWith(Cucumber.class)
    @CucumberOptions(
            features = "src/test/java/com/academy/techcenture/features",
            glue = "com/academy/techcenture/stepDefinitions")
    public class TestRunner {
//        @After
//        public void tearDown(){
//            Driver.quitDriver();
        }



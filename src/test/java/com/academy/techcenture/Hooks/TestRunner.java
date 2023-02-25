package com.academy.techcenture.Hooks;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;



    @RunWith(Cucumber.class)
    @CucumberOptions(
            features = "src/test/java/com/academy/techcenture/features",
            glue = "stepDefinitions")
    public class TestRunner {

    }


package com.academy.techcenture.Hooks;

import com.academy.techcenture.driver.Driver;
import org.junit.After;
import org.junit.Before;

public class Hooks {

    @Before
    public void setUp() {
        Driver.getDriver();
    }

    @After
    public void tearDown() {
        Driver.quitDriver();
    }


}

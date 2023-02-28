package com.academy.techcenture.driver;

import com.academy.techcenture.config.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Driver {

    public static WebDriver driver;

    private Driver() {}

    public static WebDriver getDriver() {
        if(driver == null) {
            String browser = ConfigReader.getProperty("browser");
            boolean headless = Boolean.parseBoolean(ConfigReader.getProperty("headless"));
            int pageLoadTime = Integer.parseInt(ConfigReader.getProperty("pageLoadTime"));
            int implicitWait = Integer.parseInt(ConfigReader.getProperty("implicitWait"));

            if (browser.trim().equalsIgnoreCase("chrome")) {
                ChromeOptions options = new ChromeOptions();
                options.setHeadless(headless);
                Map<String, Object> prefs = new HashMap<String, Object>();
                prefs.put("autofill.profile_enabled", false);
                prefs.put("profile.password_manager_enabled", false);
                prefs.put("profile.default_content_setting_values.notifications", 2);
                prefs.put("profile.managed_default_content_settings.javascript",2);
                options.setExperimentalOption("prefs", prefs);
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(options);
            } else if (browser.trim().equalsIgnoreCase("edge")) {
                EdgeOptions options = new EdgeOptions();
                options.setCapability("headless", headless);
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            }else{
                throw new RuntimeException("NO DRIVER FOUND");
            }
            driver.manage().timeouts().pageLoadTimeout(pageLoadTime, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
        return driver;
    }
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}

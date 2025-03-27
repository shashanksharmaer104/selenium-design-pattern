package com.automation.seleniumdesign.test;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;

    @BeforeTest
    public void setupDriver() {
        //System.setProperty("webdriver.gecko.driver", "drivers/geckodriver"); // Not require as using Selenium WebDriver v4.30.0
        //this.driver = new FirefoxDriver();
        this.driver = new ChromeDriver();
    }

    @AfterTest
    public void quitDriver() {
        this.driver.quit();
    }

}

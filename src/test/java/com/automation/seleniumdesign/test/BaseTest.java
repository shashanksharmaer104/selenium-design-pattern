package com.automation.seleniumdesign.test;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;

    @BeforeTest
    public void setupDriver() {
        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
        this.driver = new FirefoxDriver();
    }

    @AfterTest
    public void quitDriver() {
        Uninterruptibles.sleepUninterruptibly(4, TimeUnit.SECONDS);
        this.driver.quit();
    }

}

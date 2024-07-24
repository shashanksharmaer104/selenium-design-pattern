package com.automation.seleniumdesign.test.command;

import com.automation.seleniumdesign.command.ElementValidator;
import com.automation.seleniumdesign.command.HomePage;
import com.automation.seleniumdesign.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    private HomePage homePage;

    @BeforeTest
    public void setPages() {
        this.homePage = new HomePage(this.driver);
    }

    @Test
    public void homePageTest() {
        this.homePage.goTo();
        this.homePage.getElementValidators()
                .stream()
                .parallel()
                .map(ElementValidator::validate)
                .forEach(Assert::assertTrue);
    }
}

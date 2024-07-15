package com.automation.seleniumdesign.test.factory;

import com.automation.seleniumdesign.factory.GoogleFactory;
import com.automation.seleniumdesign.factory.GooglePage;
import com.automation.seleniumdesign.test.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GoogleSearchTest extends BaseTest {

    private GooglePage googlePage;

    @Test(dataProvider = "getData")
    public void searchTest(final String language, final String keyword) {

        this.googlePage = GoogleFactory.get(this.driver, language);
        this.googlePage.launchSite();
        this.googlePage.search(keyword);
        int resultCount = this.googlePage.getResultsCount();

        System.out.println("Result count:: " + resultCount);
    }

    @DataProvider
    public Object[][] getData() {
        return new Object[][] {
                {"ENG", "Selenium WebDriver"},
                {"FRE", "Playwright"},
                {"ARB", "Design Patterns"}
        };
    }

}

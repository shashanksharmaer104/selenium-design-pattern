package com.automation.seleniumdesign.test.srp;

import com.automation.seleniumdesign.srp.mainpage.GoogleMainPage;
import com.automation.seleniumdesign.srp.resultpage.GoogleResultPage;
import com.automation.seleniumdesign.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GoogleTest extends BaseTest {

    private GoogleMainPage googleMainPage;
    private GoogleResultPage googleResultPage;

    @BeforeTest
    public void setupPage() {
        this.googleMainPage = new GoogleMainPage(driver);
        this.googleResultPage = new GoogleResultPage(driver);
    }

    @Test(dataProvider = "getData")
    public void googleWorkflow(final String keyword, final int index) {
        googleMainPage.goTo();
        Assert.assertTrue(googleMainPage.getSearchWidget().isDisplayed());

        googleMainPage.getSearchWidget().enter(keyword);
        Assert.assertTrue(googleMainPage.getSearchSuggestion().isDisplayed());

        googleMainPage.getSearchSuggestion().clickSuggestionByIndex(index);
        Assert.assertTrue(googleResultPage.getNavigationBar().isDisplayed());

        googleResultPage.getSearchWidget().enter(keyword);
        Assert.assertTrue(googleResultPage.getSearchSuggestion().isDisplayed());

        googleResultPage.getSearchSuggestion().clickSuggestionByIndex(index);

        googleResultPage.getNavigationBar().goToNews();
        Assert.assertTrue(googleResultPage.getSearchResult().isDisplayed());

        System.out.println("Heading:: " + googleResultPage.getSearchResult().getFirstResultHeading());

        System.out.println("Count is :: " + googleResultPage.getSearchResult().getResultCount());
    }

    @DataProvider
    public Object[][] getData() {
        return new Object[][] {
                {"selenium", 3},
                {"playwright", 4}
        };
    }

}

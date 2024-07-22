package com.automation.seleniumdesign.test.strategyexercise;

import com.automation.seleniumdesign.strategyexercise.BookFlightScreen;
import com.automation.seleniumdesign.strategyexercise.SearchOptionFactory;
import com.automation.seleniumdesign.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Maps;

import java.util.Map;

public class BookFlightTest extends BaseTest {

    private BookFlightScreen bookFlightScreen;

    @BeforeTest
    public void initializeObjects() {
        this.bookFlightScreen = new BookFlightScreen(this.driver);
    }

    @Test(dataProvider = "getData")
    public void fightBookingTest(final String option, final Map<String, String> details) {
        this.bookFlightScreen.goTo();

        //Accept cookies
        if (this.bookFlightScreen.getCookiesHandler().isDisplayed()) {
            this.bookFlightScreen.getCookiesHandler().acceptCookies();
        }

        //Open new search page
        if (this.bookFlightScreen.getRecentSearch().isDisplayed()) {
            this.bookFlightScreen.getRecentSearch().clickNewSearch();
        }

        Assert.assertTrue(this.bookFlightScreen.getLoginContainer().isDisplayed());

        this.bookFlightScreen.setSearchStrategy(SearchOptionFactory.get(this.driver, option));
        this.bookFlightScreen.enterSearchDetails(details);

        this.bookFlightScreen.scrollToSearchBtn();

        this.bookFlightScreen.getCustomDropdownWidget().selectAdults("2");
        this.bookFlightScreen.getCustomDropdownWidget().selectChildren("1");
        this.bookFlightScreen.getCustomDropdownWidget().selectInfants("2");

        this.bookFlightScreen.clickSearch();

        boolean isError = this.bookFlightScreen.errorMessageDisplayed();
        Assert.assertTrue(isError, "Error message not displayed");
    }

    @DataProvider
    private Object[][] getData() {

        Map<String, String> returnDetails = Maps.newHashMap();
        returnDetails.put("DepartureAirport", "Delhi (DEL)");
        returnDetails.put("ArrivalAirport", "Beijing (PEK)");

        Map<String, String> oneWayDetails = Maps.newHashMap();
        oneWayDetails.put("DepartureAirport", "Indianapolis (IND)");
        oneWayDetails.put("ArrivalAirport", "Bahawalpur Airport (BHV)");

        return new Object[][] {
                {"RETURN", returnDetails},
                {"ONEWAY", oneWayDetails}
        };
    }

}

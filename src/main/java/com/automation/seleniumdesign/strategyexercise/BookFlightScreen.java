package com.automation.seleniumdesign.strategyexercise;

import com.automation.seleniumdesign.strategyexercise.commonpage.CookiesHandler;
import com.automation.seleniumdesign.strategyexercise.commonpage.CustomDropdownWidget;
import com.automation.seleniumdesign.strategyexercise.commonpage.RecentSearch;
import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class BookFlightScreen {

    private WebDriver driver;
    private LoginContainer loginContainer;
    private LoginPopup loginPopup;
    private CustomDropdownWidget customDropdownWidget;
    private SearchStrategy searchStrategy;
    private CookiesHandler cookiesHandler;
    private RecentSearch recentSearch;

    @FindBy(css = "input#ctl00_c_CtPrOffer_txtEnterCode")
    private WebElement promotionCode;

    @FindBy(id = "ctl00_c_errorPnl")
    private WebElement errorContainer;

    @FindBy(id = "ctl00_c_IBE_PB_FF")
    private WebElement searchBtn;

    public BookFlightScreen(final WebDriver driver) {
        this.driver = driver;
        this.loginContainer = new LoginContainer(driver);
        this.loginPopup = new LoginPopup(driver);
        this.customDropdownWidget = new CustomDropdownWidget(driver);
        this.cookiesHandler = new CookiesHandler(driver);
        this.recentSearch = new RecentSearch(driver);
        PageFactory.initElements(this.driver, this);
    }

    public LoginContainer getLoginContainer() {
        return loginContainer;
    }

    public LoginPopup getLoginPopup() {
        return loginPopup;
    }

    public CustomDropdownWidget getCustomDropdownWidget() {
        return customDropdownWidget;
    }

    public CookiesHandler getCookiesHandler() {
        return cookiesHandler;
    }

    public RecentSearch getRecentSearch() {
        return recentSearch;
    }

    public void setSearchStrategy(SearchStrategy searchStrategy) {
        this.searchStrategy = searchStrategy;
        PageFactory.initElements(this.driver, this.searchStrategy);
    }

    public void enterSearchDetails(final Map<String, String> searchDetails) {
        this.searchStrategy.enterDetails(searchDetails);
    }

    public void goTo() {
        this.driver.get("https://fly4.emirates.com/CAB/IBE/SearchAvailability.aspx");
    }

    public void scrollToSearchBtn() {
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", this.searchBtn);
    }

    public void clickSearch() {
        this.searchBtn.click();
    }

    public boolean errorMessageDisplayed() {
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        return this.errorContainer.isDisplayed();
    }

}

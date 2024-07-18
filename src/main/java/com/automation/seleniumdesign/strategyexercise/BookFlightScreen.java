package com.automation.seleniumdesign.strategyexercise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookFlightScreen {

    private WebDriver driver;
    private LoginContainer loginContainer;
    private LoginPopup loginPopup;

    @FindBy(css = "input#ctl00_c_CtPrOffer_txtEnterCode")
    private WebElement promotionCode;

    public BookFlightScreen(final WebDriver driver) {
        this.driver = driver;
        this.loginContainer = new LoginContainer(driver);
        this.loginPopup = new LoginPopup(driver);
    }

    public LoginContainer getLoginContainer() {
        return loginContainer;
    }

    public LoginPopup getLoginPopup() {
        return loginPopup;
    }

    public void goTo() {
        this.driver.get("https://fly4.emirates.com/CAB/IBE/SearchAvailability.aspx");
    }
}

package com.automation.seleniumdesign.strategyexercise.commonpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CookiesHandler extends AbstractComponent {

    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElement accept;

    @FindBy(id = "onetrust-pc-btn-handler")
    private WebElement cookiesPreference;

    public CookiesHandler(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isDisplayed() {
        return new WebDriverWait(this.driver, Duration.ofSeconds(5))
                .until(d -> this.accept.isDisplayed());
    }

    public void acceptCookies() {
        this.accept.click();
    }
}

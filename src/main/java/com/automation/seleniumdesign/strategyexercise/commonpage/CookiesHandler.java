package com.automation.seleniumdesign.strategyexercise.commonpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CookiesHandler extends AbstractComponent {

    private WebDriver driver;

    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElement accept;

    @FindBy(id = "onetrust-pc-btn-handler")
    private WebElement cookiesPreference;

    public CookiesHandler(final WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Override
    public boolean isDisplayed() {
        try {
            return new WebDriverWait(this.driver, Duration.ofSeconds(5))
                    .until(d -> this.accept.isDisplayed());
        } catch (Exception e) {
            return false;
        }
    }

    public void acceptCookies() {
        this.accept.click();
    }
}

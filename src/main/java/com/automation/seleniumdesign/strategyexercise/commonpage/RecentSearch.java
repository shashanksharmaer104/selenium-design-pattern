package com.automation.seleniumdesign.strategyexercise.commonpage;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class RecentSearch extends AbstractComponent {

    private WebDriver driver;

    @FindBy(css = "a.ts-session-expire--link")
    private WebElement newSearchBtn;

    public RecentSearch(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Override
    public boolean isDisplayed() {
        try {
            return new WebDriverWait(this.driver, Duration.ofSeconds(5))
                    .until(d -> this.newSearchBtn.isDisplayed());
        } catch (Exception e) {
            return false;
        }
    }

    public void clickNewSearch() {
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        this.newSearchBtn.click();
    }
}

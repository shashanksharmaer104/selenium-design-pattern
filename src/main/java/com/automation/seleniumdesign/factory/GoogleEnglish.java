package com.automation.seleniumdesign.factory;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

class GoogleEnglish extends GooglePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @FindBy(id = "q")
    private WebElement searchBox;

    @FindBy(name = "btnK")
    private WebElement searchBtn;

    @FindBy(css = "div.MjjYud")
    private List<WebElement> results;

    public GoogleEnglish(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        PageFactory.initElements(driver, this);
    }

    @Override
    public void launchSite() {
        this.driver.get("https://www.google.com/");
    }

    @Override
    public void search(final String keyword) {
        this.searchBox.clear();
        for (char ch : keyword.toCharArray()) {
            Uninterruptibles.sleepUninterruptibly(20, TimeUnit.MILLISECONDS);
            this.searchBox.sendKeys(ch + "");
        }
        this.wait.until((d) -> this.searchBtn.isDisplayed());
        this.searchBox.click();
    }

    @Override
    public int getResultsCount() {
        this.wait.until((d) -> this.results.size() > 1);
        return this.results.size();
    }
}

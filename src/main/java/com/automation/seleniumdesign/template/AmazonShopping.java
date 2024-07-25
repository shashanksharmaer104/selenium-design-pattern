package com.automation.seleniumdesign.template;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class AmazonShopping extends ShoppingTemplate {

    private WebDriver driver;
    private WebDriverWait wait;
    private String product;

    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchBox;

    @FindBy(id = "nav-search-submit-button")
    private WebElement searchBtn;

    @FindBy(css = "span.a-size-medium")
    private WebElement item;

    @FindBy(xpath = "((//div[@id='corePrice_desktop'])[1]//span)[3]")
    private WebElement price;

    public AmazonShopping(final WebDriver driver, final String product) {
        this.driver = driver;
        this.product = product;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    @Override
    public void launchSite() {
        this.driver.get("https://www.amazon.com/");
    }

    @Override
    public void searchForProduct() {
        this.wait.until(d -> this.searchBox.isDisplayed());
        this.searchBox.sendKeys(this.product);
        this.searchBtn.click();
    }

    @Override
    public void selectProduct() {
        this.wait.until(d -> this.item.isDisplayed());
        this.item.click();
    }

    @Override
    public void buy() {
        this.wait.until(d -> this.price.isDisplayed());
        //Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
        //this.wait.until(ExpectedConditions.visibilityOf(this.price));
        System.out.println("Price: " + this.price.getText());
    }
}

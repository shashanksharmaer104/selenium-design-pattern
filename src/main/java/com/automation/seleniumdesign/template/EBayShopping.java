package com.automation.seleniumdesign.template;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class EBayShopping extends ShoppingTemplate {

    private WebDriver driver;
    private WebDriverWait wait;
    private String product;

    private String parentWindow;

    @FindBy(id = "gh-ac")
    private WebElement searchBox;

    @FindBy(id = "gh-btn")
    private WebElement searchBtn;

    @FindBy(xpath = "(//span[@role='heading'])[position()>2]") //(//a[@class='s-item__link'])[position()>2]
    private WebElement item;

    @FindBy(xpath = "//*[@data-testid='x-price-section']//span")
    private WebElement price;

    public EBayShopping(final WebDriver driver, final String product) {
        this.driver = driver;
        this.product = product;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    @Override
    public void launchSite() {
        this.driver.get("https://www.ebay.com/");
    }

    @Override
    public void searchForProduct() {
        this.searchBox.sendKeys(this.product);
        this.searchBtn.click();
    }

    @Override
    public void selectProduct() {
        this.wait.until(d -> this.item.isDisplayed());
        this.parentWindow = this.driver.getWindowHandle();
        this.item.click();
    }

    @Override
    public void buy() {
        Set<String> windowsSet = this.driver.getWindowHandles();

        for (String childWindow: windowsSet) {
            if (!this.parentWindow.equals(childWindow)) {
                this.driver.switchTo().window(childWindow);

                this.wait.until(d -> this.price.isDisplayed());
                System.out.println("Price: " + this.price.getText().trim());
                break;
            }
        }

        this.driver.switchTo().window(this.parentWindow);
    }
}

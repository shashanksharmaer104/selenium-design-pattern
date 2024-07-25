package com.automation.seleniumdesign.template.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AmazonProductDescPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "((//div[@id='corePrice_desktop'])[1]//span)[3]")
    private WebElement price;

    public AmazonProductDescPage(final WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    public void buy() {
        this.wait.until(d -> this.price.isDisplayed());
        System.out.println("Price: " + this.price.getText());
    }

}

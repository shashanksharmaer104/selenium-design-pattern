package com.automation.seleniumdesign.command;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

public class HomePage {

    private final WebDriver driver;

    //buttons
    @FindBy(css = "div.button-box button.btn-info")
    private WebElement infoBtn;

    @FindBy(css = "div.button-box button.btn-warning")
    private WebElement warningBtn;

    @FindBy(css = "div.button-box button.btn-success")
    private WebElement successBtn;

    @FindBy(css = "div.button-box button.btn-danger")
    private WebElement dangerBtn;

    //notifications
    @FindBy(css = "div.jq-icon-info")
    private WebElement infoAlert;

    @FindBy(css = "div.jq-icon-warning")
    private WebElement warningAlert;

    @FindBy(css = "div.jq-icon-success")
    private WebElement successAlert;

    @FindBy(css = "div.jq-icon-error")
    private WebElement dangerAlert;

    //dismissal alerts
    @FindBy(xpath = "//h4[text()='Dissmissal Alert']//following-sibling::div[contains(@class,'alert-info')]")
    private WebElement dismissInfoAlert;

    @FindBy(xpath = "//h4[text()='Dissmissal Alert']//following-sibling::div[contains(@class,'alert-success')]")
    private WebElement dismissSuccessAlert;

    @FindBy(xpath = "//h4[text()='Dissmissal Alert']//following-sibling::div[contains(@class,'alert-danger')]")
    private WebElement dismissDanderAlert;

    @FindBy(xpath = "//h4[text()='Dissmissal Alert']//following-sibling::div[contains(@class,'alert-warning')]")
    private WebElement dismissWarnAlert;

    public HomePage(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goTo() {
        this.driver.get("https://vins-udemy.s3.amazonaws.com/ds/admin-template/admin-template.html");
    }

    public List<ElementValidator> getElementValidators() {
        return Arrays.asList(
                //notification
                new NotificationValidator(infoBtn, infoAlert),
                new NotificationValidator(warningBtn, warningAlert),
                new NotificationValidator(successBtn, successAlert),
                new NotificationValidator(dangerBtn, dangerAlert),
                //dismiss
                new DismissalAlertValidator(dismissInfoAlert),
                new DismissalAlertValidator(dismissSuccessAlert),
                new DismissalAlertValidator(dismissWarnAlert),
                new DismissalAlertValidator(dismissDanderAlert)
        );
    }
}

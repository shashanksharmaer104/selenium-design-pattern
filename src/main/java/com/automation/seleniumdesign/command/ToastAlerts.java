package com.automation.seleniumdesign.command;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ToastAlerts extends AbstractComponent {

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

    public ToastAlerts(WebDriver driver) {
        super(driver);
    }

    public WebElement getSuccessAlert() {
        return successAlert;
    }

    public WebElement getInfoBtn() {
        return infoBtn;
    }

    public WebElement getWarningBtn() {
        return warningBtn;
    }

    public WebElement getSuccessBtn() {
        return successBtn;
    }

    public WebElement getDangerBtn() {
        return dangerBtn;
    }

    public WebElement getInfoAlert() {
        return infoAlert;
    }

    public WebElement getWarningAlert() {
        return warningAlert;
    }

    public WebElement getDangerAlert() {
        return dangerAlert;
    }
}

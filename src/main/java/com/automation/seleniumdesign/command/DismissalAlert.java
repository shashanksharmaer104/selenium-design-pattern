package com.automation.seleniumdesign.command;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DismissalAlert extends AbstractComponent {

    //dismissal alerts
    @FindBy(xpath = "//h4[text()='Dissmissal Alert']//following-sibling::div[contains(@class,'alert-info')]")
    private WebElement dismissInfoAlert;

    @FindBy(xpath = "//h4[text()='Dissmissal Alert']//following-sibling::div[contains(@class,'alert-success')]")
    private WebElement dismissSuccessAlert;

    @FindBy(xpath = "//h4[text()='Dissmissal Alert']//following-sibling::div[contains(@class,'alert-danger')]")
    private WebElement dismissDanderAlert;

    @FindBy(xpath = "//h4[text()='Dissmissal Alert']//following-sibling::div[contains(@class,'alert-warning')]")
    private WebElement dismissWarnAlert;

    public DismissalAlert(final WebDriver driver) {
        super(driver);
    }

    public WebElement getDismissSuccessAlert() {
        return dismissSuccessAlert;
    }

    public WebElement getDismissInfoAlert() {
        return dismissInfoAlert;
    }

    public WebElement getDismissDanderAlert() {
        return dismissDanderAlert;
    }

    public WebElement getDismissWarnAlert() {
        return dismissWarnAlert;
    }
}

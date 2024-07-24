package com.automation.seleniumdesign.command;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

public class HomePage {

    private final WebDriver driver;

    private final ToastAlerts toastAlerts;
    private final DismissalAlert dismissalAlert;

    public HomePage(final WebDriver driver) {
        this.driver = driver;
        this.toastAlerts = new ToastAlerts(this.driver);
        this.dismissalAlert = new DismissalAlert(this.driver);
    }

    public void goTo() {
        this.driver.get("https://vins-udemy.s3.amazonaws.com/ds/admin-template/admin-template.html");
    }

    public List<ElementValidator> getElementValidators() {
        return Arrays.asList(
                //notification
                new NotificationValidator(this.toastAlerts.getInfoBtn(),
                        this.toastAlerts.getInfoAlert()),
                new NotificationValidator(this.toastAlerts.getWarningBtn(),
                        this.toastAlerts.getWarningAlert()),
                new NotificationValidator(this.toastAlerts.getSuccessBtn(),
                        this.toastAlerts.getSuccessAlert()),
                new NotificationValidator(this.toastAlerts.getDangerBtn(),
                        this.toastAlerts.getDangerAlert()),
                //dismiss
                new DismissalAlertValidator(this.dismissalAlert.getDismissInfoAlert()),
                new DismissalAlertValidator(this.dismissalAlert.getDismissSuccessAlert()),
                new DismissalAlertValidator(this.dismissalAlert.getDismissWarnAlert()),
                new DismissalAlertValidator(this.dismissalAlert.getDismissDanderAlert())
        );
    }
}

package com.automation.seleniumdesign.command;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DismissalAlertValidator extends ElementValidator {

    private final WebElement dismissalAlert;

    public DismissalAlertValidator(final WebElement dismissalAlert) {
        this.dismissalAlert = dismissalAlert;
    }

    @Override
    public boolean validate() {
        boolean result1 = this.dismissalAlert.isDisplayed(); //true
        this.dismissalAlert.findElement(By.cssSelector("button.close")).click();
        boolean result2 = this.dismissalAlert.isDisplayed(); //false
        return result1 && (!result2);
    }
}

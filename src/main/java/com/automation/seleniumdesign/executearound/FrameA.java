package com.automation.seleniumdesign.executearound;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FrameA {

    @FindBy(name = "fn")
    private WebElement firstName;

    @FindBy(name = "ln")
    private WebElement lastName;

    @FindBy(name = "addr")
    private WebElement address;

    @FindBy(name = "area")
    private WebElement message;

    public void setFirstName(final String firstName) {
        this.firstName.sendKeys(firstName);
    }

    public void setLastName(final String lastName) {
        this.lastName.sendKeys(lastName);
    }

    public void setAddress(final String address) {
        this.address.sendKeys(address);
    }

}

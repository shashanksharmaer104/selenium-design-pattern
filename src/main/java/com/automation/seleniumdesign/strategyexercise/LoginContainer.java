package com.automation.seleniumdesign.strategyexercise;

import com.automation.seleniumdesign.strategyexercise.commonpage.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginContainer extends AbstractComponent {

    @FindBy(id = "btnLogin")
    private WebElement loginBtn;

    public LoginContainer(final WebDriver driver) {
        super(driver);
    }

    public void clickLoginBtn() {
        this.loginBtn.click();
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until(d -> this.loginBtn.isDisplayed());
    }
}

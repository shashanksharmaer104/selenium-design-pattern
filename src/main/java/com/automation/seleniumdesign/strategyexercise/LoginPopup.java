package com.automation.seleniumdesign.strategyexercise;

import com.automation.seleniumdesign.strategyexercise.commonpage.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPopup extends AbstractComponent {

    @FindBy(className = "login-form__heading")
    private WebElement loginHeaderLbl;

    @FindBy(css = "input#sso-email")
    private WebElement emailTextbox;

    @FindBy(css = "input#sso-password")
    private WebElement passTextbox;

    @FindBy(css = "button#login-button")
    private WebElement loginBtn;

    public LoginPopup(WebDriver driver) {
        super(driver);
    }

    public void enterEmail(final String email) {
        this.emailTextbox.clear();
        this.emailTextbox.sendKeys(email);
    }

    public void enterPassword(final String pass) {
        this.passTextbox.clear();
        this.passTextbox.sendKeys(pass);
    }

    public void clickLogin() {
        this.loginBtn.click();
    }

    public void login(final String email, final String pass) {
        this.enterEmail(email);
        this.enterPassword(pass);
        this.clickLogin();
    }

    @Override
    protected boolean isDisplayed() {
        return this.wait.until(d -> this.loginHeaderLbl.isDisplayed());
    }
}

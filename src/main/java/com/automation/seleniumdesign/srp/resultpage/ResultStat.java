package com.automation.seleniumdesign.srp.resultpage;

import com.automation.seleniumdesign.srp.commonpage.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResultStat extends AbstractComponent {

    @FindBy(id = "resultStats")
    private WebElement stat;

    public ResultStat(WebDriver driver) {
        super(driver);
    }

    public String getStat() {
        return this.stat.getText().trim();
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until(driver -> this.stat.isDisplayed());
    }


}

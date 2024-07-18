package com.automation.seleniumdesign.strategyexercise;

import com.automation.seleniumdesign.strategyexercise.commonpage.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

public class AdvancedSearchStrategy extends AbstractComponent implements SearchStrategy {

    @FindBy(css = "input#ctl00_c_CtWNW_ddlFrom1-suggest")
    private WebElement departureAirport;

    @FindBy(css = "input#ctl00_c_CtWNW_ddlFrom2-suggest")
    private WebElement arrivalAirport;

    @FindBy(css = "")
    private WebElement departingDate;

    public AdvancedSearchStrategy(WebDriver driver) {
        super(driver);
    }

    @Override
    public void enterDetails(Map<String, String> searchDetails) {
        this.departureAirport.clear();
        this.departureAirport.sendKeys(searchDetails.get("DA"));

        this.arrivalAirport.clear();
        this.arrivalAirport.sendKeys(searchDetails.get("AA"));
    }

    @Override
    protected boolean isDisplayed() {
        return this.wait.until(d -> this.departureAirport.isDisplayed());
    }
}

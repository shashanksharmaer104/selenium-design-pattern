package com.automation.seleniumdesign.strategyexercise;

import com.automation.seleniumdesign.strategyexercise.commonpage.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

public class ReturnStrategy extends AbstractComponent implements SearchStrategy {

    @FindBy(css = "input#ctl00_c_CtWNW_ddlFrom-suggest")
    private WebElement departureAirport;

    @FindBy(css = "input#ctl00_c_CtWNW_ddlTo-suggest")
    private WebElement arrivalAirport;

    @FindBy(css = "")
    private WebElement departingDate;

    @FindBy(css = "")
    private WebElement returningDate;

    @FindBy(xpath = "//div[@id='Div1' and @data-radio=\"RT_OW\"]")
    private WebElement returnRadioBtn;

    public ReturnStrategy(WebDriver driver) {
        super(driver);
    }

    public void selectReturnOption() {
        this.returnRadioBtn.click();
    }

    @Override
    public void enterDetails(Map<String, String> searchDetails) {

        selectReturnOption();

        this.departureAirport.clear();
        this.departureAirport.sendKeys(searchDetails.get("DepartureAirport"));

        this.arrivalAirport.clear();
        this.arrivalAirport.sendKeys(searchDetails.get("ArrivalAirport"));
    }

    @Override
    protected boolean isDisplayed() {
        return this.wait.until(d -> this.departureAirport.isDisplayed());
    }
}

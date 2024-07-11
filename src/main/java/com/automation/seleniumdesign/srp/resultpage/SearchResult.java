package com.automation.seleniumdesign.srp.resultpage;

import com.automation.seleniumdesign.srp.commonpage.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResult extends AbstractComponent {

    @FindBy(xpath = "//div[@data-hveid='CBEQAA']")
    private WebElement resultsSection;

    public SearchResult(WebDriver driver) {
        super(driver);
    }

    public int getResultCount() {
        return this.resultsSection.findElements(By.xpath("//div[@class='SoaBEf']")).size();
    }

    public String getFirstResultHeading() {
        return this.resultsSection.findElements(By.xpath("//div[@class='SoaBEf']"))
                .get(1).findElement(By.xpath("//div[@role='heading']"))
                .getText().trim();
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until(driver -> resultsSection.isDisplayed());
    }


}

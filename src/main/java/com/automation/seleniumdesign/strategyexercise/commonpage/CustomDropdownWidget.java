package com.automation.seleniumdesign.strategyexercise.commonpage;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class CustomDropdownWidget extends AbstractComponent {

    @FindBy(css = "div#ctl00_c_CtNoOfTr_numberAdults_chosen a")
    private WebElement adultsBtn;

    @FindBy(css = "div#ctl00_c_CtNoOfTr_numberChildren_chosen a")
    private WebElement childrenBtn;

    @FindBy(css = "div#ctl00_c_CtNoOfTr_numberinfants_chosen a")
    private WebElement infantsBtn;

    @FindBy(className = "chosen-results")
    private WebElement listContainer;

    @FindBy(xpath = "//li//span")
    private List<WebElement> listOptions;

    public CustomDropdownWidget(WebDriver driver) {
        super(driver);
    }

    public void selectAdults(final String value) {
        this.adultsBtn.click();
        getOptionElement(this.adultsBtn, value).click();
    }

    public void selectChildren(final String value) {
        this.childrenBtn.click();
        getOptionElement(this.childrenBtn, value).click();
    }

    public void selectInfants(final String value) {
        this.infantsBtn.click();
        getOptionElement(this.infantsBtn, value).click();
    }

    private WebElement getOptionElement(final WebElement parentButton, final String value) {
        Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
        return parentButton.findElement(By.xpath("//*[@class='chosen-results']"))
                .findElements(By.xpath("//li//span"))
                .stream().filter(el -> el.getText().equalsIgnoreCase(value))
                .collect(Collectors.toList()).get(0);
    }

    @Override
    protected boolean isDisplayed() {
        return this.wait.until(d -> this.adultsBtn.isDisplayed());
    }
}

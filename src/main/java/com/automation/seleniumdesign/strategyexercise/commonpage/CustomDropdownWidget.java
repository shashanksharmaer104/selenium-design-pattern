package com.automation.seleniumdesign.strategyexercise.commonpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
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
        List<WebElement> element = this.adultsBtn.findElement(By.xpath("//*[@class='chosen-results']"))
                .findElements(By.xpath("//li//span"))
                .stream().filter(el -> el.getText().equalsIgnoreCase(value))
                .collect(Collectors.toList());
        element.get(0).click();
    }

    public void selectChildren(final String value) {
        this.childrenBtn.click();
        List<WebElement> element = this.childrenBtn.findElement(By.xpath("//*[@class='chosen-results']"))
                .findElements(By.xpath("//li//span"))
                .stream().filter(el -> el.getText().equalsIgnoreCase(value))
                .collect(Collectors.toList());
        element.get(0).click();
    }

    public void selectInfants(final String value) {
        this.infantsBtn.click();
        List<WebElement> element = this.infantsBtn.findElement(By.xpath("//*[@class='chosen-results']"))
                .findElements(By.xpath("//li//span"))
                .stream().filter(el -> el.getText().equalsIgnoreCase(value))
                .collect(Collectors.toList());
        element.get(0).click();
    }

    @Override
    protected boolean isDisplayed() {
        return this.wait.until(d -> this.adultsBtn.isDisplayed());
    }
}

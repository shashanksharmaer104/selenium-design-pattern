package com.automation.seleniumdesign.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GoogleArabic extends GoogleEnglish {

    @FindBy(css = "div#gws-output-pages-elements-homepage_additional_languages__als a")
    private List<WebElement> languageList;

    @FindBy(css = "span.ly0Ckb")
    private WebElement keyboardBtn;

    @FindBy(id = "kbd")
    private WebElement arabicKeyboad;

    public GoogleArabic(WebDriver driver) {
        super(driver);
    }

    @Override
    public void launchSite() {
        this.driver.get("https://www.google.com.sa/");
        this.languageList.get(0).click();
    }

    @Override
    public void search(final String keyword) {
        // convert to arabic
        this.wait.until(d -> keyboardBtn.isDisplayed());
        this.keyboardBtn.click();
        this.wait.until(d -> this.arabicKeyboad.isDisplayed());

        // search the keyword
        super.search(keyword);
    }
}

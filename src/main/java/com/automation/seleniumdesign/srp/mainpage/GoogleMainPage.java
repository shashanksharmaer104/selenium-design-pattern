package com.automation.seleniumdesign.srp.mainpage;

import com.automation.seleniumdesign.srp.commonpage.SearchSuggestion;
import com.automation.seleniumdesign.srp.commonpage.SearchWidget;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GoogleMainPage {

    private WebDriver driver;
    private SearchWidget searchWidget;
    private SearchSuggestion searchSuggestion;

    public GoogleMainPage(final WebDriver driver) {
        this.driver = driver;
        searchWidget = PageFactory.initElements(driver, SearchWidget.class);
        searchSuggestion = PageFactory.initElements(driver, SearchSuggestion.class);
    }

    public void goTo() {
        this.driver.get("https://www.google.com/");
    }

    public SearchWidget getSearchWidget() {
        return searchWidget;
    }

    public SearchSuggestion getSearchSuggestion() {
        return searchSuggestion;
    }
}

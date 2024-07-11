package com.automation.seleniumdesign.srp.resultpage;

import com.automation.seleniumdesign.srp.commonpage.SearchSuggestion;
import com.automation.seleniumdesign.srp.commonpage.SearchWidget;
import org.openqa.selenium.WebDriver;

public class GoogleResultPage {

    private SearchWidget searchWidget;
    private SearchSuggestion searchSuggestion;
    private NavigationBar navigationBar;
    private ResultStat resultStat;
    private SearchResult searchResult;


    public GoogleResultPage(final WebDriver driver) {
        searchWidget = new SearchWidget(driver);
        searchSuggestion = new SearchSuggestion(driver);
        navigationBar = new NavigationBar(driver);
        resultStat = new ResultStat(driver);
        searchResult = new SearchResult(driver);
    }

    public SearchWidget getSearchWidget() {
        return searchWidget;
    }

    public SearchSuggestion getSearchSuggestion() {
        return searchSuggestion;
    }

    public NavigationBar getNavigationBar() {
        return navigationBar;
    }

    public ResultStat getResultStat() {
        return resultStat;
    }

    public SearchResult getSearchResult() {
        return searchResult;
    }
}

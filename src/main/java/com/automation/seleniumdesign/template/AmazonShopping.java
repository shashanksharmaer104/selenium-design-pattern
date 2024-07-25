package com.automation.seleniumdesign.template;

import com.automation.seleniumdesign.template.pages.AmazonProductDescPage;
import com.automation.seleniumdesign.template.pages.AmazonResultsPage;
import com.automation.seleniumdesign.template.pages.AmazonSearchPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AmazonShopping extends ShoppingTemplate {

    private WebDriver driver;
    private String product;

    private AmazonSearchPage amazonSearchPage;
    private AmazonResultsPage amazonResultsPage;
    private AmazonProductDescPage amazonProductDescPage;

    public AmazonShopping(final WebDriver driver, final String product) {
        this.driver = driver;
        this.product = product;
        this.amazonSearchPage = PageFactory.initElements(driver, AmazonSearchPage.class);
        this.amazonResultsPage = new AmazonResultsPage(driver);
        this.amazonProductDescPage = new AmazonProductDescPage(driver);
    }

    @Override
    public void launchSite() {
        this.amazonSearchPage.launchSite();
    }

    @Override
    public void searchForProduct() {
        this.amazonSearchPage.searchForProduct(this.product);
    }

    @Override
    public void selectProduct() {
        this.amazonResultsPage.selectProduct();
    }

    @Override
    public void buy() {
        this.amazonProductDescPage.buy();
    }
}

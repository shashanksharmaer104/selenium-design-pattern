package com.automation.seleniumdesign.srp.resultpage;

import com.automation.seleniumdesign.srp.commonpage.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigationBar extends AbstractComponent {


    @FindBy(id = "hdtb-sc")
    private WebElement bar;

    @FindBy(linkText = "All")
    private WebElement all;

    @FindBy(linkText = "Images")
    private WebElement images;

    @FindBy(linkText = "Videos")
    private WebElement videos;

    @FindBy(linkText = "News")
    private WebElement news;

    public NavigationBar(WebDriver driver) {
        super(driver);
    }

    public void goToImages() {
        this.images.click();
    }

    public void goToVideos() {
        this.videos.click();
    }

    public void goToNews() {
        this.news.click();
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until(driver -> this.bar.isDisplayed());
    }


}

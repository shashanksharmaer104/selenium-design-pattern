package com.automation.seleniumdesign.test.executearound;

import com.automation.seleniumdesign.executearound.MainPage;
import com.automation.seleniumdesign.test.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FrameTest extends BaseTest {

    private MainPage mainPage;

    @BeforeTest
    public void setMainPage() {
        this.mainPage = new MainPage(driver);
    }

    @Test
    public void testFames() {
        this.mainPage.goTo();

        this.mainPage.onFrameA(a -> {
            a.setFirstName("fn1");
            a.setAddress("This is test message for Frame A");
        });

        this.mainPage.onFrameC(c -> c.setLastName("ln3"));

        this.mainPage.onFrameB(b -> b.setAddress("This is test message for Frame B"));

        this.mainPage.onFrameA(a -> a.setLastName("ln1"));


    }


}

package com.automation.seleniumdesign.test.decorator;

import com.automation.seleniumdesign.decorator.DashboardPage;
import com.automation.seleniumdesign.test.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.function.Consumer;

public class DashboardPageTest extends BaseTest {

    private DashboardPage dashboardPage;

    @BeforeTest
    public void setDashboardPage() {
        this.dashboardPage = new DashboardPage(driver);
    }

    @Test(dataProvider = "getData")
    public void roleTest(final Consumer<DashboardPage> consumer) {
        this.dashboardPage.goTo();
        consumer.accept(this.dashboardPage);
    }

    @DataProvider
    private Object[] getData() {
        return new Object[] {
                Decorators.guestPage,
                Decorators.superuserPage,
                Decorators.adminPage
        };
    }

}

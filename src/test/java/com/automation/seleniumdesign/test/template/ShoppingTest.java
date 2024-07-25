package com.automation.seleniumdesign.test.template;

import com.automation.seleniumdesign.template.AmazonShopping;
import com.automation.seleniumdesign.template.EBayShopping;
import com.automation.seleniumdesign.template.ShoppingTemplate;
import com.automation.seleniumdesign.test.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ShoppingTest extends BaseTest {

    @Test(dataProvider = "getData")
    public void shoppingTest(final ShoppingTemplate shoppingTemplate) {
        shoppingTemplate.shop();
    }

    @DataProvider
    public Object[] getData() {
        return new Object[] {
                new AmazonShopping(driver, "iphone"),
                new EBayShopping(driver, "iphone")
        };
    }

}

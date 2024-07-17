package com.automation.seleniumdesign.test.strategy;

import com.automation.seleniumdesign.strategy.*;
import com.automation.seleniumdesign.test.BaseTest;
import com.google.common.util.concurrent.Uninterruptibles;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Maps;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class PaymentScreenTest extends BaseTest {

    private PaymentScreen paymentScreen;

    @BeforeTest
    public void setPaymentScreen() {
        this.paymentScreen = new PaymentScreen(this.driver);
    }

    @Test(dataProvider = "getData")
    public void paymentTest(final PaymentOption paymentOption, final Map<String, String> paymentDetails ) {
        this.paymentScreen.goTo("https://vins-udemy.s3.amazonaws.com/ds/strategy.html");
        this.paymentScreen.getUserInformation().enterDetails("shash", "sharma", "sharma@test.com");
        this.paymentScreen.setPaymentOption(paymentOption);
        this.paymentScreen.pay(paymentDetails);
        String orderNumber = this.paymentScreen.getOrder().placeOrder();

        System.out.println("Order number: " + orderNumber);

        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
    }

    @DataProvider
    private Object[][] getData() {

        Map<String, String> cc = Maps.newHashMap();
        cc.put("cc", "1234567890");
        cc.put("year", "2024");
        cc.put("cvv", "123");

        Map<String, String> nb = Maps.newHashMap();
        nb.put("bank", "WELLS FARGO");
        nb.put("account", "myaccount123");
        nb.put("pin", "999");

        Map<String, String> pp = Maps.newHashMap();
        pp.put("username", "testuser");
        pp.put("password", "testpassword");

        return new Object[][] {
                {new CreditCard(), cc},
                {new NetBanking(), nb},
                {new Paypal(), pp}
        };
    }

}

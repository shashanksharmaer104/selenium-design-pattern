package com.automation.seleniumdesign.strategy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

public class PaymentScreen {

    private WebDriver driver;
    private UserInformation userInformation;
    private Order order;
    private PaymentOption paymentOption;

    public PaymentScreen(final WebDriver driver) {
        this.driver = driver;
        this.userInformation = new UserInformation(driver);
        this.order = new Order(driver);
    }

    public UserInformation getUserInformation() {
        return userInformation;
    }

    public Order getOrder() {
        return order;
    }

    public void setPaymentOption(PaymentOption paymentOption) {
        this.paymentOption = paymentOption;
        PageFactory.initElements(driver, this.paymentOption);
    }

    public void pay(Map<String, String> paymentDetails) {
        this.paymentOption.enterPaymentInformation(paymentDetails);
    }

    public void goTo(final String url) {
        this.driver.get(url);
    }
}

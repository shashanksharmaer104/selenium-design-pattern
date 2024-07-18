package com.automation.seleniumdesign.strategy;

import java.util.HashMap;
import java.util.function.Supplier;

public class PaymentOptionFactory {

    private static final Supplier<PaymentOption> CC = () -> new CreditCard();
    private final static Supplier<PaymentOption> NB = () -> new NetBanking();
    private final static Supplier<PaymentOption> PP = () -> new Paypal();

    private final static HashMap<String, Supplier<PaymentOption>> MAP = new HashMap<>();

    static {
        MAP.put("CC", CC);
        MAP.put("NB", NB);
        MAP.put("PP", PP);
    }

    public static PaymentOption get(final String option) {
        return MAP.get(option).get();
    }

}

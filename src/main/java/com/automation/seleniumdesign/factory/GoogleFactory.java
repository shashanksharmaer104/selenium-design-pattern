package com.automation.seleniumdesign.factory;

import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class GoogleFactory {

    private static final Function<WebDriver, GooglePage> ENG = GoogleEnglish::new;
    private static final Function<WebDriver, GooglePage> FRE = GoogleFrench::new;
    private static final Function<WebDriver, GooglePage> ARB = GoogleArabic::new;

    private static final Map<String, Function<WebDriver, GooglePage>> MAP = new HashMap<>();

    static {
        MAP.put("ENG", ENG);
        MAP.put("FRE", FRE);
        MAP.put("ARB", ARB);
    }

    public static GooglePage get(final WebDriver driver, final String language) {
        return MAP.get(language).apply(driver);
    }
}

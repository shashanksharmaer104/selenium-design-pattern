package com.automation.seleniumdesign.strategyexercise;

import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class SearchOptionFactory {

    private final static Function<WebDriver, SearchStrategy> RETURN = ReturnStrategy::new;
    private final static Function<WebDriver, SearchStrategy> ONEWAY = OneWayStrategy::new;
    private final static Function<WebDriver, SearchStrategy> ADVANCED = AdvancedSearchStrategy::new;

    private final static Map<String, Function<WebDriver, SearchStrategy>> MAP = new HashMap<>();

    static {
        MAP.put("RETURN", RETURN);
        MAP.put("ONEWAY", ONEWAY);
        MAP.put("ADVANCED", ADVANCED);
    }

    public static SearchStrategy get(final WebDriver driver, final String option) {
        return MAP.get(option).apply(driver);
    }


}

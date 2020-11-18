package org.selenium.pom.factory;

import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author Bharath.MC
 * @since Nov-2020
 */
public class GoogleFactory {

    private static final Function<WebDriver, GooglePage> ENG = (driver) -> new GoogleEnglish(driver);
    private static final Function<WebDriver, GooglePage> FRENCH = (driver) -> new GoogleFrench(driver);
    private static final Function<WebDriver, GooglePage> GERMAN = (driver) -> new GoogleGerman(driver);

    private static Map<String, Function<WebDriver, GooglePage>> MAP = new HashMap<>();

    static {
        MAP.put("ENGLISH", ENG);
        MAP.put("FRENCH", FRENCH);
        MAP.put("GERMAN", GERMAN);
    }

    public static GooglePage get(String language, WebDriver driver){
        return MAP.get(language).apply(driver);
    }
}

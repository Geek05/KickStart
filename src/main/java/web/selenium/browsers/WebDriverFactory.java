package web.selenium.browsers;

import org.demo.selenium.BROWSER;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * @author Bharath.MC
 * @since Nov-2020
 */
public class WebDriverFactory {
    private static Function<BROWSER, WebDriver> CHROME = (browser -> new ChromeDriverHelper().GetChromeDriver());
    private static Function<BROWSER, WebDriver> DRIVERLESS = (browser -> new PhanthomJSHelper().GetPhanthomJSDriver());
    private static Map<BROWSER, Function<BROWSER, WebDriver>> MAP = new HashMap<>();

    static {
        MAP.put(BROWSER.CHROME, CHROME);
        MAP.put(BROWSER.DRIVERLESS, DRIVERLESS);
    }

    public static WebDriver Get(BROWSER browser){
        return MAP.get(browser).apply(browser);
    }
}

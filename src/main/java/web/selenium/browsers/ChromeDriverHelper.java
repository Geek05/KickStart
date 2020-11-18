package web.selenium.browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverHelper {

    static {
        String ChromeDriverPath;
        if (System.getProperty("os.name").equalsIgnoreCase("Mac OS X")) {
            ChromeDriverPath = System.getProperty("user.dir") + "/Externals/mac/chromedriver";
        } else {
            ChromeDriverPath = System.getProperty("user.dir") + "/Externals/windows/chromedriver.exe";
        }
        System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
    }


    public static WebDriver GetChromeDriver() {
        return new ChromeDriver();
    }

}

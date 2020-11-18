package org.selenium;

import com.google.common.util.concurrent.Uninterruptibles;
import org.demo.selenium.BROWSER;
import org.demo.selenium.WebDriverService;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

/**
 * @author Bharath.MC
 * @since Nov-2020
 */
public class BaseTest {
    protected WebDriver driver;

    @BeforeTest
    public void setupDriver() {
        driver = WebDriverService.getInstance(BROWSER.CHROME);
    }

    @AfterTest
    public void tearDown() {
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
        WebDriverService.deConstructDriver(driver);
    }
}

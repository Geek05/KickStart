package org.demo.selenium.Driver2;

import org.openqa.selenium.WebDriver;

/**
 * @author Bharath.MC
 * @since Nov-2020
 */
public abstract class DriverManager {
//https://www.vinsguru.com/selenium-webdriver-design-patterns-in-test-automation-factory-pattern/

    protected WebDriver driver;
    protected abstract void startService();
    protected abstract void stopService();
    protected abstract void createDriver();

    public void quitDriver() {
        if (null != driver) {
            driver.quit();
            driver = null;
        }
    }

    public WebDriver getDriver() {
        if (null == driver) {
            startService();
            createDriver();
        }
        return driver;
    }
}

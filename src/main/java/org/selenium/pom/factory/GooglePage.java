package org.selenium.pom.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Bharath.MC
 * @since Nov-2020
 */
public abstract class GooglePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public abstract void launchSite();
    public abstract void searchKeyword(String keyword);
    public abstract int getResultsCount();

    public GooglePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }
}

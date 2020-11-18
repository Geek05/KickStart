package org.selenium.pom.google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Bharath.MC
 * @since Nov-2020
 */
public abstract class AbstractComponent {
    protected WebDriverWait wait;
    protected WebDriver driver;

    public AbstractComponent(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 60);
        PageFactory.initElements(driver, this);
    }


    public abstract Boolean isDisplayed();
}

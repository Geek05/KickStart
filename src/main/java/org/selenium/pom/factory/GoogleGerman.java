package org.selenium.pom.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * @author Bharath.MC
 * @since Nov-2020
 */
public class GoogleGerman extends GooglePage{

    public GoogleGerman(WebDriver driver){
        super(driver);
    }

    @FindBy(name = "q")
    WebElement searchBox;

    @FindBy(name= "btnk")
    WebElement searchBtn;

    @FindBy(css= "div.rc")
    List<WebElement> results;

    @Override
    public void launchSite() {
        this.driver.get("http://www.google.com");
    }

    @Override
    public void searchKeyword(String keyword) {
        searchBtn.sendKeys(keyword);
        this.wait.until(d -> searchBtn.isDisplayed());
        searchBtn.click();
    }

    @Override
    public int getResultsCount() {
        this.wait.until(tmpDrv -> results.size()>0);
        return this.results.size();
    }
}

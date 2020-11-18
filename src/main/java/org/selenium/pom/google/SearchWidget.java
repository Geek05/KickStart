package org.selenium.pom.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Bharath.MC
 * @since Nov-2020
 */
public class SearchWidget extends AbstractComponent{

    public SearchWidget(WebDriver driver){
        super(driver);
    }

    @FindBy(name = "q")
    WebElement searchTextBox;

    public void enterSearchQuery(String query){
        searchTextBox.clear();
        searchTextBox.sendKeys(query);
    }

    @Override
    public Boolean isDisplayed() {
        this.wait.until(ExpectedConditions.visibilityOf(searchTextBox));
        //return this.searchTextBox.isDisplayed();
        //java 8
        return this.wait.until(tempDriver -> searchTextBox.isDisplayed()); //wait till its true
    }
}

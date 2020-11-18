package org.selenium.pom.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * @author Bharath.MC
 * @since Nov-2020
 */
public class SearchSuggestion extends AbstractComponent{

    public SearchSuggestion(WebDriver driver){
        super(driver);
    }

    @FindBy(css = "li.sbct")
    List<WebElement> searchSuggestions;

    public void selectSearchSuggestion(int suggestionIndex){
        this.searchSuggestions.get(suggestionIndex).click();
    }

    @Override
    public Boolean isDisplayed() {
        return this.wait.until(waitDriver -> this.searchSuggestions.size() > 5);
    }
}

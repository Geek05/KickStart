package org.selenium.pom.google.main;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.selenium.pom.google.SearchSuggestion;
import org.selenium.pom.google.SearchWidget;

/**
 * @author Bharath.MC
 * @since Nov-2020
 */
public class GoogleMainPage {
    private WebDriver driver;
    @Getter
    private SearchWidget searchWidget;
    @Getter
    private SearchSuggestion searchSuggestion;

    public GoogleMainPage(final WebDriver driver){
        this.driver = driver;
        this.searchWidget = PageFactory.initElements(driver, SearchWidget.class);
        this.searchSuggestion = PageFactory.initElements(driver, SearchSuggestion.class);
    }

    public void goTo(){
        this.driver.get("https://www.google.com/");
        System.out.println("Page on opening page "+driver.getTitle());
    }
}

package org.selenium.pom.google.main;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.selenium.pom.google.NavigationBar;
import org.selenium.pom.google.ResultStat;
import org.selenium.pom.google.SearchSuggestion;
import org.selenium.pom.google.SearchWidget;

/**
 * @author Bharath.MC
 * @since Nov-2020
 */
@Getter
public class GoogleResultPage {
    private SearchWidget searchWidget;
    private SearchSuggestion searchSuggestion;
    private NavigationBar navigationBar;
    private ResultStat resultStat;

    public GoogleResultPage(final WebDriver driver){
        this.searchWidget = PageFactory.initElements(driver, SearchWidget.class);
        this.searchSuggestion = PageFactory.initElements(driver, SearchSuggestion.class);
        this.navigationBar = PageFactory.initElements(driver, NavigationBar.class);
        this.resultStat = PageFactory.initElements(driver, ResultStat.class);
    }

}

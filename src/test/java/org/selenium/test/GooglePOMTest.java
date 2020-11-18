package org.selenium.test;

import org.selenium.BaseTest;
import org.selenium.pom.google.main.GoogleMainPage;
import org.selenium.pom.google.main.GoogleResultPage;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @author Bharath.MC
 * @since Nov-2020
 */
public class GooglePOMTest extends BaseTest {

    private GoogleMainPage googleMainPage;
    private GoogleResultPage googleResultPage;

    @BeforeTest
    public void setupPages(){
        this.googleMainPage = new GoogleMainPage(driver);
        this.googleResultPage = new GoogleResultPage(driver);
    }

    @Test(enabled=true)
    public void testGoogleWorkFlowUsingPOM() {
        String searchKeyword = "selenium webdriver";
        googleMainPage.goTo();
        Assert.assertTrue(googleMainPage.getSearchWidget().isDisplayed(), "Search Widget not found on google page.");

        googleMainPage.getSearchWidget().enterSearchQuery(searchKeyword);
        Assert.assertTrue(googleMainPage.getSearchSuggestion().isDisplayed());

        googleMainPage.getSearchSuggestion().selectSearchSuggestion(3);
        Assert.assertTrue(googleResultPage.getNavigationBar().isDisplayed());

        googleResultPage.getSearchWidget().enterSearchQuery(searchKeyword);
        Assert.assertTrue(googleResultPage.getSearchSuggestion().isDisplayed());

        googleResultPage.getSearchSuggestion().selectSearchSuggestion(3);
        Assert.assertTrue(googleResultPage.getNavigationBar().isDisplayed());

        googleResultPage.getNavigationBar().gotoNews();
        Assert.assertTrue(googleResultPage.getResultStat().isDisplayed());

        String stats = googleResultPage.getResultStat().getStats();
        System.out.println("stats = "+stats);

        googleResultPage.getNavigationBar().gotoImages();
        Assert.assertTrue(googleResultPage.getResultStat().isDisplayed());

        googleResultPage.getNavigationBar().gotoNews();
        Assert.assertTrue(googleResultPage.getResultStat().isDisplayed());

        stats = googleResultPage.getResultStat().getStats();
        System.out.println("stats = "+stats);
    }
}

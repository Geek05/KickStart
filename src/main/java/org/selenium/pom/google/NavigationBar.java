package org.selenium.pom.google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * @author Bharath.MC
 * @since Nov-2020
 */
public class NavigationBar extends AbstractComponent {

    public NavigationBar(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "hdtbSum")
    private WebElement searchBar;

    @FindBy(linkText = "Images")
    private WebElement images;

    @FindBy(linkText = "News")
    private WebElement news;

    @FindBy(linkText = "Videos")
    private WebElement videos;

    public void gotoNews() {
        videos.click();
    }

    public void gotoImages() {
        images.click();
    }

    public void gotoVideos() {
        videos.click();
    }

    @Override
    public Boolean isDisplayed() {
        return this.wait.until(tempDrv -> searchBar.isDisplayed());
    }
}

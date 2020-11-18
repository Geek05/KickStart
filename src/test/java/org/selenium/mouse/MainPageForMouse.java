package org.selenium.mouse;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author Bharath.MC
 * @since Nov-2020
 */
public class MainPageForMouse {

    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;

    public MainPageForMouse(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.actions = new Actions(driver);
        this.wait = new WebDriverWait(driver, 30);
    }

    @FindBy(xpath = "//span[contains(text(),'Development')]")
    private WebElement developmentTab;

    @FindBy(xpath = "(//span[contains(text(),'Development')]/ancestor::a/ancestor::li/ul[@class='sub-menu']/li/a/span[@class='zita-menu-link'])")
    private List<WebElement> developmentCoursesOnHover;

    public void goTo(){
        driver.get("https://www.vinsguru.com/selenium-webdriver-design-patterns-in-test-automation-factory-pattern/");
    }

    public void hoverOnDevelopment(){
        wait.until(tmpDrv -> developmentTab.isDisplayed());
        actions.moveToElement(developmentTab).perform();
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        System.out.println(developmentCoursesOnHover.size());
        System.out.println(developmentCoursesOnHover);
        developmentCoursesOnHover.stream()
                .forEach(developmentCourse -> System.out.println(developmentCourse.getText()));
    }
}

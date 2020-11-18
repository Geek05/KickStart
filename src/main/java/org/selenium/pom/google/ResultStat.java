package org.selenium.pom.google;

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
public class ResultStat extends AbstractComponent{

    public ResultStat(WebDriver driver){
        super(driver);
    }

    @FindBy(id = "result-stats")
    private WebElement resultStat;



    public String getStats(){
        return resultStat.getText();
    }

    @Override
    public Boolean isDisplayed() {
        return this.wait.until(tempDriver -> this.resultStat.isDisplayed());
    }
}

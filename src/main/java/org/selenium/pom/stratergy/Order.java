package org.selenium.pom.stratergy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Bharath.MC
 * @since Nov-2020
 */
public class Order {

    public Order(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "buy")
    private WebElement buyButton;

    @FindBy(id = "ordernumber")
    private WebElement orderNumber;

    public String placeOrder(){
        buyButton.click();
        return this.orderNumber.getText();
    }
}

package org.selenium.pom.stratergy.payments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

/**
 * @author Bharath.MC
 * @since Nov-2020
 */
public class CreditCard implements PaymentOption{

    @FindBy(id="cc")
    WebElement cc;

    @FindBy(id="year")
    WebElement year;

    @FindBy(id="cvv")
    WebElement cvv;

    @Override
    public void enterPaymentInformation(Map<String, String> paymentDetails) {
        cc.sendKeys(paymentDetails.get("cc"));
        year.sendKeys(paymentDetails.get("year"));
        cvv.sendKeys(paymentDetails.get("cvv"));
    }
}

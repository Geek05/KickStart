package org.selenium.pom.stratergy.payments;

import cucumber.api.java.eo.Se;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.Map;

/**
 * @author Bharath.MC
 * @since Nov-2020
 */
public class NetBanking implements PaymentOption{

    @FindBy(id="bank")
    WebElement bank;

    @FindBy(id="acc_number")
    WebElement accountNumber;

    @FindBy(id="pin")
    WebElement pin;

    @Override
    public void enterPaymentInformation(Map<String, String> paymentDetails) {
        Select bankDropdown = new Select(bank);
        bankDropdown.selectByValue(paymentDetails.get("bank"));
        accountNumber.sendKeys(paymentDetails.get("acc_number"));
        pin.sendKeys(paymentDetails.get("pin"));
    }
}

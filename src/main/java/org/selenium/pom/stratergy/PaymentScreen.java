package org.selenium.pom.stratergy;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.selenium.pom.stratergy.payments.PaymentOption;

import java.util.Map;

/**
 * @author Bharath.MC
 * @since Nov-2020
 * Page Object
 */
public class PaymentScreen {
    WebDriver driver;
    @Getter
    UserInformation userInformation;
    @Getter
    Order order;
    @Getter
    PaymentOption paymentOption;

    public PaymentScreen(WebDriver driver){
        this.driver = driver;
        this.userInformation = PageFactory.initElements(driver , UserInformation.class);
        this.order = PageFactory.initElements(driver, Order.class);
    }

    public void setPaymentOption(PaymentOption paymentOption){
        this.paymentOption = paymentOption;
        PageFactory.initElements(driver, this.paymentOption);
    }

    public void pay(Map<String, String> paymentData){
        paymentOption.enterPaymentInformation(paymentData);
    }

    public void goTo(){
        driver.get("https://vins-udemy.s3.amazonaws.com/ds/strategy.html");
    }
}

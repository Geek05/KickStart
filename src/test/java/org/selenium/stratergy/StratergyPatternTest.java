package org.selenium.stratergy;

import com.google.common.util.concurrent.Uninterruptibles;
import org.selenium.BaseTest;
import org.selenium.pom.stratergy.PaymentScreen;
import org.selenium.pom.stratergy.payments.CreditCard;
import org.selenium.pom.stratergy.payments.NetBanking;
import org.selenium.pom.stratergy.payments.PaymentOption;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Maps;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author Bharath.MC
 * @since Nov-2020
 */
public class StratergyPatternTest extends BaseTest {

    PaymentScreen paymentScreen;

    @BeforeTest
    public void setup(){
        paymentScreen = new PaymentScreen(driver);
    }

    @Test(dataProvider = "paymentDataProvider")
    public void testStratergyPattern(PaymentOption paymentOption, Map<String, String> paymentData){
        paymentScreen.goTo();
        paymentScreen.getUserInformation().enterDetails("Bharath", "MC", "abc@gmail.com");
        paymentScreen.setPaymentOption(paymentOption);
        paymentScreen.pay(paymentData);
        String orderNumber = paymentScreen.getOrder().placeOrder();
        System.out.println("orderNumber="+orderNumber);
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
    }

    @DataProvider
    public Object[][] paymentDataProvider(){
        Map<String, String> credCard = Maps.newHashMap();
        credCard.put("cc", "123");
        credCard.put("year","2021");
        credCard.put("cvv","122");

        Map<String, String> netBanking = Maps.newHashMap();
        netBanking.put("bank", "BOFA");
        netBanking.put("acc_number","3232432");
        netBanking.put("pin","1345");

        return new Object[][]{
                {new CreditCard(), credCard },
                {new NetBanking(), netBanking }
        };
    }
}

package org.selenium.pom.stratergy.payments;

import java.util.Map;

/**
 * @author Bharath.MC
 * @since Nov-2020
 */
public interface PaymentOption {

    void enterPaymentInformation(Map<String, String> paymentDetails);
}

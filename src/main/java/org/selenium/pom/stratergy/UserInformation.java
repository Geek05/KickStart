package org.selenium.pom.stratergy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Bharath.MC
 * @since Nov-2020
 */
public class UserInformation {

    public UserInformation(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id= "fn")
    private WebElement firstName;

    @FindBy(id= "ln")
    private WebElement lastName;

    @FindBy(id= "email")
    private WebElement email;

    public void enterDetails(String fName, String lName, String emailId){
        firstName.sendKeys(fName);
        lastName.sendKeys(lName);
        email.sendKeys(emailId);
    }
}

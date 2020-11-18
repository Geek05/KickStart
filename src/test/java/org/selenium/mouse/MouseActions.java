package org.selenium.mouse;

import org.selenium.BaseTest;
import org.testng.annotations.Test;

/**
 * @author Bharath.MC
 * @since Nov-2020
 */
public class MouseActions extends BaseTest {

    @Test
    public void testMouseAction(){
        MainPageForMouse mainPageForMouse = new MainPageForMouse(driver);
        mainPageForMouse.goTo();
        mainPageForMouse.hoverOnDevelopment();
    }
}

package org.demo.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import web.selenium.browsers.ChromeDriverHelper;
import web.selenium.browsers.PhanthomJSHelper;
import web.selenium.browsers.WebDriverFactory;

public class WebDriverService {
	private static WebDriver driver = null;
	
	public static Integer IMPLICIT_WAITTIME = 180;
	public static Integer PAGELOAD_TIMEOUT = 180;
	
	private WebDriverService(){}

	public static WebDriver getInstance(BROWSER browserType) {
		if(driver==null) {
			driver = WebDriverFactory.Get(browserType);
			driverBasicInitilization();
		}
		return driver;
	}


	private static void driverBasicInitilization() {
		driver.manage().timeouts().implicitlyWait(PAGELOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(PAGELOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	public static void deConstructDriver(WebDriver driver) {
		if(driver!=null) {
			driver.close();
			driver.quit();
		}		
		driver = null;
	}
}

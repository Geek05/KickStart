package org.train.examples;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

	private static WebDriver driver = null;

	private static void initilizeDriver() {
		final String ChromeDriverPath = System.getProperty("user.dir")+"/Externals/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);				
	}

	private static void DoLogin() {
		try {
			initilizeDriver();
			driver.get("http://www.store.demoqa.com");
			driver.findElement(By.xpath(".//*[@id='account']/a")).click();
			driver.findElement(By.id("log")).sendKeys("testuser_1"); 
			driver.findElement(By.id("pwd")).sendKeys("Test@123");
			driver.findElement(By.id("login")).click();
			System.out.println("Login Successfully");
			DoLogout();
		}
		catch(Exception e) {
			System.out.println("Exception "+e.getMessage());
			e.printStackTrace();
		}
		finally {
			if(driver!=null) {
				driver.close();
				driver.quit();
			}
		}
	}

	private static void DoLogout() {
		driver.findElement (By.xpath(".//*[@id='account_logout']/a")).click();
		System.out.println("LogOut Successfully");
	}


	public static void main(String[] args) {		
		DoLogin();
	}
}
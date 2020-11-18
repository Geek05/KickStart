package org.selenium.test;

import org.demo.selenium.BROWSER;
import org.demo.selenium.WebDriverService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.selenium.pom.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class SeleniumTest {

	WebDriver driver = WebDriverService.getInstance(BROWSER.CHROME);
	
	@Test(enabled=false)
	public void testSelenium_DataTable() {
		System.out.println(driver);
		driver.get("http://toolsqa.com/automation-practice-table/#");
		System.out.println(driver.getTitle());		
		String Country = "China";
		WebElement element = driver.findElement(By.xpath("//table//td[text()='"+Country+"']/ancestor::tr/td[5]"));
		System.out.println(Country+" Rank is "+element.getText());
	}
	
	
	@Test(enabled=true)
	public void testSelenium_POM() {
		String userName = "Admin";
		String password = "admin123";
		LoginPage loginPage = new LoginPage(driver);
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		System.out.println("Page on opening page "+driver.getTitle());
		loginPage.setCredentials(userName, password);
		loginPage.login();
		System.out.println("Page Title after login"+driver.getTitle());
		Assert.assertEquals("Welcome "+userName, driver.findElement(By.id("welcome")).getText());
	}
	
	@AfterClass
	public void tearDown() {
		WebDriverService.deConstructDriver(driver);
	}
}

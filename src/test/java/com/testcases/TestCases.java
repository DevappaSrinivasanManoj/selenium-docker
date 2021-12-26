package com.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.newtours.pages.RegistrationPage;

public class TestCases extends Base {

	
	@Test
	public void tc001() throws InterruptedException {
	
		WebDriverWait wait = new WebDriverWait(driver, 50);
		RegistrationPage rp = new RegistrationPage(driver);
		rp.goTo();
		rp.enterUserDetails("Test", "Test");
		rp.enterUserCredentials("Test", "Test");
		//Thread.sleep(2000);
		rp.submit();
		//Thread.sleep(2000);
		driver.findElement(By.id("flight-link")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("findFlights")));
		driver.findElement(By.id("findFlights")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("reserveFlights")));
		driver.findElement(By.id("reserveFlights")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buyFlights")));
		driver.findElement(By.id("buyFlights")).click();
		String s = driver.findElement(By.xpath("//font[normalize-space()='$584 USD']")).getText();
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(s, "$584 USD");
		soft.assertAll();
	}

}

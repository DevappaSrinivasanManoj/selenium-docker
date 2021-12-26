package com.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestCases1 extends Base{
		
	@Test
	public void tc001() throws InterruptedException {
	
		WebDriverWait wait = new WebDriverWait(driver, 50);
		driver.get("https://duckduckgo.com/");
		driver.findElement(By.id("search_form_input_homepage")).sendKeys("sfe");
		driver.findElement(By.id("search_form_input_homepage")).sendKeys(Keys.ENTER);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[data-zci-link='videos']")));
		driver.findElement(By.cssSelector("a[data-zci-link='videos']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Any license']"))); Thread.sleep(1000);
		int a = driver.findElements(By.xpath("//div/img")).size();
		SoftAssert sAssert = new SoftAssert();
		if(a<10) {
			sAssert.assertTrue(false, "Number of videos is lesser than 10!!!!");
		}
		sAssert.assertAll();
	}
}

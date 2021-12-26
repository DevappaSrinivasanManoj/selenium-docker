package com.newtours.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public RegistrationPage(WebDriver driver) {
		this.driver=driver;
		wait = new WebDriverWait(driver, 30);
	}
	
	public void goTo() {
		driver.get("https://vins-udemy.s3.amazonaws.com/docker/docker-book-flight.html");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstName")));
	}
	
	public void enterUserDetails(String firstName, String lastName) {
		driver.findElement(By.name("firstName")).sendKeys(firstName);
		driver.findElement(By.name("lastName")).sendKeys(lastName);
	}
	
	public void enterUserCredentials(String userName, String pwd) {
		driver.findElement(By.id("email")).sendKeys(userName);
		driver.findElement(By.name("password")).sendKeys(pwd);
		driver.findElement(By.name("confirmPassword")).sendKeys(pwd);
	}
	
	public void submit() {
		driver.findElement(By.id("register-btn")).click();
	}

}

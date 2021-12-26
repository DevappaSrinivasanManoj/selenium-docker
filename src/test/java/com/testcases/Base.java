package com.testcases;


import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Base {
	public WebDriver driver; 
	
	@BeforeClass
	public void openBrowser() throws MalformedURLException {
		
		String host = "localhost";
		DesiredCapabilities dc;
		
		if(System.getProperty("BROWSER")!=null && System.getProperty("BROWSER").equalsIgnoreCase("firefox")) {
			dc = DesiredCapabilities.firefox();
		}
		else{
			dc = DesiredCapabilities.chrome();
		}
		
		if(System.getProperty("HUB_HOST")!=null) {
			host=System.getProperty("HUB_HOST");
		}
		
		String completeUrl = "http://"+host+":4444/wd/hub";
		this.driver = new RemoteWebDriver(new URL(completeUrl), dc);
		
//		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
}

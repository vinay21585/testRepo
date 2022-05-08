package com.test.sample.practice_automation.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public WebDriver driver ;
	
	@BeforeSuite
	public void setupBrowserDriverPath() {
		  WebDriverManager.chromedriver().browserVersion(Utilities.getheValueFromPropertiesFile("browser_version")).setup(); //setting up the chrome browser specific driver using web driver manager 
		  														//browser version should be matching your system browser version
		  //WebDriverManager.chromedriver().version("101").setup(); //setting up the chrome browser specific driver using web driver manager 

	}
	
	@BeforeMethod
	public void initBrowser() {
		
		driver = new ChromeDriver();  // will launch chrome browser & start the session
		driver.manage().window().maximize();
		driver.get(Utilities.getheValueFromPropertiesFile("url"));
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
	}
	
	
	@AfterMethod
	public void teardown() {
		
		driver.quit();  // will terminate the browser session
	}
	
	
	
}

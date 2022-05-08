package com.test.sample.practice_automation.pages;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.test.sample.practice_automation.base.Base;

public class AllLinksPage extends Base{


	public AllLinksPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		final WebDriverWait wait = new WebDriverWait(driver, 10L);
		try {
			wait.until(ExpectedConditions.visibilityOf(txtWelcomeToTheInternet));
		}
		catch (Exception e) {
		}

	}

	@FindBy(xpath = "//a[text()='File Upload']") private WebElement fileUploadLink;

	@FindBy(xpath = "//h1[text()='Welcome to the-internet']") private WebElement txtWelcomeToTheInternet;

	@FindBy(xpath = "//a[text()='Form Authentication']") private WebElement formAuthLink;
	
	@FindBy(xpath = "//a[text()='Checkboxes']") private WebElement chooseBoxesLink;
	
	

	public FileUploadPage clickFileUpload() {
		fileUploadLink.click();
		return new FileUploadPage(driver);
	}

	public LoginPage clickFormAuthentication() {
		formAuthLink.click();
		return new LoginPage(driver);
	}

	public ChooseBoxesPage clickChooseBoxes() {
		chooseBoxesLink.click();
		return new ChooseBoxesPage(driver);
	}


}

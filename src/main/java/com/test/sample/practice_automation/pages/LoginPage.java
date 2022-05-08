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

public class LoginPage extends Base{
	
    
	public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        final WebDriverWait wait = new WebDriverWait(driver, 10L);
        try {
            wait.until(ExpectedConditions.visibilityOf(uNameField));
        }
        catch (Exception e) {
        }
     
    }
	

	//String expectedText = "You logged into a secure area!";
    
    @FindBy(id = "username") private WebElement uNameField;
    @FindBy(id = "password") private WebElement pwdFiled;
    @FindBy(xpath = "//button[@type='submit']") private WebElement submitButton;
    @FindBy(id = "flash") private WebElement flashMessage;
  
    public LoginPage enterUserName(String uName) {
    	
    	uNameField.sendKeys(uName);
    	return this;
    }

    public LoginPage enterPassword(String pwd) {
    	
    	pwdFiled.sendKeys(pwd);
    	return this;
    }
    
    public LoginPage clickSubmit() {
    	submitButton.click();
    	return this;
    }
    
    public String getFlashMessage() {
    	
    	return flashMessage.getText();
    }
    
}

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

public class FileUploadPage extends Base{
	
    
	public FileUploadPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        final WebDriverWait wait = new WebDriverWait(driver, 10L);
        try {
            wait.until(ExpectedConditions.visibilityOf(txtFileUploader));
        }
        catch (Exception e) {
        }
     
    }
	
	@FindBy(xpath = "//h3[text()='File Uploader']") private WebElement txtFileUploader;
	@FindBy(id = "file-upload") private WebElement filePickerChooseFile;
	@FindBy(id = "file-submit") private WebElement btnSubmit;
	@FindBy(id = "uploaded-files") private WebElement txtuploadedFileName;
	
	public FileUploadPage chooseFile(String filePath) {
		filePickerChooseFile.sendKeys(filePath);
		return this;
	}
	
	public FileUploadPage clickSubmit() {
		btnSubmit.click();
		return this;
	}
	
	public String getUploadedFileName() {
		
		return txtuploadedFileName.getText();
	}
	
}

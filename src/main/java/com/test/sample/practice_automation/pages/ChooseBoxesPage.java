package com.test.sample.practice_automation.pages;
import java.util.List;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.test.sample.practice_automation.base.Base;

public class ChooseBoxesPage extends Base{


	public ChooseBoxesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		final WebDriverWait wait = new WebDriverWait(driver, 10L);
		try {
			wait.until(ExpectedConditions.visibilityOf(listOfCheckbox.get(0)));
		}
		catch (Exception e) {
		}

	}

	@FindBy(xpath = "//input[@type='checkbox']") private List<WebElement> listOfCheckbox;

	public List<WebElement> getListOFCheckboxes() {
		
		return listOfCheckbox;
	}


}

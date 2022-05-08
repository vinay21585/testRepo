package com.test.sample.practice_automation.tests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.test.sample.practice_automation.base.Base;
import com.test.sample.practice_automation.base.Utilities;
import com.test.sample.practice_automation.pages.AllLinksPage;

public class AutomationScripts extends Base {

	@Test(priority=0)
	public void validateBasicAuthByProvidingCorrectUNandPWD() {

		//Set the username
		String username = "admin";
		//Set the password
		String password = "admin";
		//Expectd text after successful basic auth
		String expectedText = "Congratulations! You must have the proper credentials.";


		/*	The basic authentication pop-up is similar to the alert that pop-ups when the browser is navigated to a specific web page. 
		To handle the basic authentication popup, we can pass the username and password along with the web page’s URL.*/

		String URL = "https://" +username +":" +password +"@"+ "the-internet.herokuapp.com/basic_auth";
		driver.get(URL);

		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

		String title = driver.getTitle();
		System.out.println("The page title is "+title);

		String actualText = driver.findElement(By.tagName("p")).getText();
		System.out.println("The text present in page is ==> "+actualText);

		//Do assertion
		Assert.assertEquals(actualText, expectedText);


	}

	@Test(priority=1)
	public void validateFileUpload() {

		String expectedFileName = "test_Upload.pdf";

		String actualFileName = new AllLinksPage(driver).
				clickFileUpload().
				chooseFile(System.getProperty("user.dir")+"/input/test_Upload.pdf").
				clickSubmit().
				getUploadedFileName();

		//validation part
		Assert.assertEquals(actualFileName, expectedFileName);
	}

	@Test(priority=2)
	public void validateFormAuthenticationForValidUNandPWD() {

		String actualText =	new AllLinksPage(driver).
				clickFormAuthentication().
				enterUserName(Utilities.getheValueFromPropertiesFile("valid_username")).
				enterPassword(Utilities.getheValueFromPropertiesFile("valid_password")).
				clickSubmit().
				getFlashMessage();

		String expectedText = "You logged into a secure area!";

		//validation part
		Assert.assertTrue(actualText.contains(expectedText));

	}

	@Test(priority=3)
	public void validateFormAuthenticationForInvalidUNandPWD() {


		String actualText =	new AllLinksPage(driver).
				clickFormAuthentication().
				enterUserName(Utilities.getheValueFromPropertiesFile("invalid_username")).
				enterPassword(Utilities.getheValueFromPropertiesFile("valid_password")).
				clickSubmit().
				getFlashMessage();

		String expectedText = "Your username is invalid!";

		Assert.assertTrue(actualText.contains(expectedText));

	}

	@Test(priority=4)
	public void validateCheckboxStatus() {

		List<WebElement> listOfCheckboxes = new AllLinksPage(driver).
		clickChooseBoxes().
		getListOFCheckboxes();
		
		boolean firstCheckboxStatus = listOfCheckboxes.get(0).isSelected();
		boolean secondCheckboxStatus = listOfCheckboxes.get(1).isSelected();

		if(firstCheckboxStatus) {
			System.out.println("First checkbox is selected");
		}else {
			System.out.println("First checkbox is NOT selected");
		}

		if(secondCheckboxStatus) {
			System.out.println("Second checkbox is selected");
		}else {
			System.out.println("Second checkbox is NOT selected");
		}



	}


}

package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.base.BasePage;
import com.qa.util.ElementActions;

public class LoginPage extends BasePage {

	WebDriver driver;
	ElementActions elementActions;

	// OR:
	By username = By.id("user-name");
	By password = By.id("password");
	By loginBtn = By.xpath("//input[@class='btn_action']");
	

	// Initializing the Page Objects:
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementActions = new ElementActions(this.driver);
	}

	// Actions:
	public String validateLoginPageTitle() {
		System.out.println(driver.getTitle());
		return driver.getTitle();
	}

	/*public boolean validateTractionImage() {
		return elementActions.isElementDisplayed(tractionLogo);
	}*/

	public HomePage doLogin(String un, String pwd) {
		elementActions.doSendKeys(username, un);
		elementActions.doSendKeys(password, pwd);
		elementActions.getElement(loginBtn).click();
		return new HomePage();
	}

}

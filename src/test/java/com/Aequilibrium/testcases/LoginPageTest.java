package com.Aequilibrium.testcases;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.base.BasePage;
import com.qa.pages.LoginPage;

public class LoginPageTest extends BasePage {
	BasePage basePage;
	Properties prop;
	WebDriver driver;
	LoginPage loginPage;
	String browser;

	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.init_properties();
		driver = basePage.init_driver(prop);
		loginPage = new LoginPage(driver);
	}

	@Test(priority = 1)
	public void LoginTest() {
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 2)
	public void LoginTestWithInvalidPassword() {
		loginPage.doLogin(prop.getProperty("username"), "InvalidUsername");
		loginPage.invalidCredentialsTest();
	}

	@Test(priority = 3)
	public void LoginTestWithInvalidUsername() {
		loginPage.doLogin("invalidUsername", prop.getProperty("password"));
		loginPage.invalidCredentialsTest();
	}

	@Test(priority = 4)
	public void LoginTestWithInvalidUsernamePassword() {
		loginPage.doLogin("invalidUsername", "invalidPassword");
		loginPage.invalidCredentialsTest();
	}

	@Test(priority = 5)
	public void LoginTestWithBlankUsernamePassword() {
		loginPage.doLogin("", "");
		loginPage.invalidCredentialsTest();
	}

	@Test(priority = 6)
	public void LoginTestWithASpaceInUsernameAndPassword() {
		loginPage.doLogin(" ", " ");
		loginPage.invalidCredentialsTest();
	}

	@Test(priority = 7)
	public void LoginTestWithNoUsername() {
		loginPage.doLogin("", prop.getProperty("password"));
		loginPage.noUserNameTest();
	}

	@Test(priority = 8)
	public void LoginTestWithNoPassword() {
		loginPage.doLogin(prop.getProperty("username"), "");
		loginPage.noPasswordTest();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}

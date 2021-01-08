package com.E2EPracticeProject001.DemoWebSite;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.E2EPracticeProject001.pageObjects.HomePage;
import com.E2EPracticeProject001.pageObjects.LoginPage;
import com.E2EPracticeProject001.resources.base;

import junit.framework.Assert;

public class LoginFunctionalityTest extends base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initializeTest() throws IOException {
		driver = initializeDriver();
		driver.get(propertyFile.getProperty("URL"));
	}

	@Test
	public void LoginFunctionality() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.getUsername().sendKeys("standard_user");
		loginPage.getPassword().sendKeys("secret_sauce");
		HomePage homePage = loginPage.getLogin();
		Assert.assertTrue(homePage.gethomePage().isDisplayed());
	}

	@AfterTest
	public void deinitializeTest() {
		driver.close();
	}

}

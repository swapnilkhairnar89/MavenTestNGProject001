package com.e2eproject001.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	private By username = By.xpath("//input[@id='user-name']");
	private By password = By.xpath("//input[@id='password']");
	private By loginButton = By.xpath("//input[@id='login-button']");

	public WebElement getUsername() {
		return driver.findElement(username);
	}

	public WebElement getPassword() {
		return driver.findElement(password);
	}

	public HomePage getLogin() {
		driver.findElement(loginButton).click();
		return new HomePage(driver);
	}

}

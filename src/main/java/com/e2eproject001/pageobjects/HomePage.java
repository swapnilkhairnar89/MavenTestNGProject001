package com.e2eproject001.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	public WebDriver driver;

	public HomePage(WebDriver driver)
	{
		this.driver = driver;
	}

	private By homePage = By.xpath("//div[@class='product_label']");

	public WebElement gethomePage() {
		return driver.findElement(homePage);
	}
}

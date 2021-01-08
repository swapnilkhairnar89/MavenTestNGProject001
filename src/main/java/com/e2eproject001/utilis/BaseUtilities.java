package com.e2eproject001.utilis;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BaseUtilities {

	public WebDriver driver;
	public Properties propertyFile;

	public WebDriver initializeDriver() throws IOException {
		propertyFile = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\com\\e2eproject001\\resources\\config.properties");
		propertyFile.load(fis);
		String browserName = propertyFile.getProperty("Browser");

		switch (browserName) {

		case "chrome":
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + propertyFile.getProperty("chromeDriverPath"));
			driver = new ChromeDriver();
			break;

		case "firefox":
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + propertyFile.getProperty("firefoxDriverPath"));
			driver = new FirefoxDriver();
			break;

		case "ieexplorer":
			System.setProperty("webdriver.ie.driver",
					System.getProperty("user.dir") + propertyFile.getProperty("ieDriverPath"));
			driver = new InternetExplorerDriver();
			break;

		}
		driver.manage().window().maximize();
		return driver;
	}

	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
		String destinationFilePath = System.getProperty("user.dir") + "\\reports\\" + testCaseName + "_" + timestamp
				+ ".png";
		FileUtils.copyFile(source, new File(destinationFilePath));
		return destinationFilePath;
	}
}

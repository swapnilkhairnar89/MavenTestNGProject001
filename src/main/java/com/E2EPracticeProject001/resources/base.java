package com.E2EPracticeProject001.resources;

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

public class base {

	public WebDriver driver;
	public Properties propertyFile;

	public WebDriver initializeDriver() throws IOException {
		propertyFile = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "\\src\\main\\java\\com\\E2EPracticeProject001\\resources\\data.properties");
		propertyFile.load(fis);
		String browserName = propertyFile.getProperty("Browser");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "/BrowserDrivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "\\BrowserDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		if (browserName.equals("ieexplorer")) {
			System.setProperty("webdriver.ie.driver",
					System.getProperty("user.dir") + "\\rowserDrivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
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

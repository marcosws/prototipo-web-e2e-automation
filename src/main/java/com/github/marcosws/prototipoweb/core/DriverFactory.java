package com.github.marcosws.prototipoweb.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.manager.SeleniumManager;

public class DriverFactory {
	
	private static WebDriver driver;
	private static String driverPath;
	
	public enum Browser{
		CHROME, FIREFOX, EDGE;
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
	
	public static void setDriver(Browser browser) {
		
		switch(browser){
		
			case CHROME:
				ChromeOptions chromeOptions = new ChromeOptions();
				driver = new ChromeDriver(chromeOptions);
				driverPath = SeleniumManager.getInstance().getDriverPath(chromeOptions);
				break;
			case FIREFOX:
				FirefoxOptions firefoxOptions = new FirefoxOptions();
				driver = new FirefoxDriver(firefoxOptions);
				driverPath = SeleniumManager.getInstance().getDriverPath(firefoxOptions);
				break;
			case EDGE:
			default:
				EdgeOptions edgeOptions = new EdgeOptions();
				driver = new EdgeDriver(edgeOptions);
				driverPath = SeleniumManager.getInstance().getDriverPath(edgeOptions);
				break;
		}
		System.out.println(driverPath);
		
	}
	
	public static void quitDriver() {
		driver.quit();
	}

}

package com.github.marcosws.prototipoweb.core;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class BasePage {
	
	private WebDriver driver;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void validateTitle(String title) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		assertEquals(title, driver.getTitle());
	}
	
	public void clickElement(WebElement element){
		highLight(element);
		element.click();
	}
	
	public void editElement(WebElement element, String text){
		highLight(element);
		element.sendKeys(text);
	}
	
	public void validateTextElement(WebElement element, String text) {
		highLight(element);
		assertEquals(text, element.getText());
	}
	
	public void validateIsVisible(WebElement element) {
		assertTrue(waitElementIsVisible(element, 7));
		highLight(element);
	}
	
	public boolean waitElement(WebElement element, int timeOutSegundos) {
		try {
			WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(timeOutSegundos));
			element = webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
			if(element == null) return false;
			return true;
		}
		catch(Exception e){
			return false;
		}
	}
	
	public boolean waitElementIsVisible(WebElement element, int timeOutSegundos) {
		try {
			WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(timeOutSegundos));
			element = webDriverWait.until(ExpectedConditions.visibilityOf(element));
			if(element == null) return false;
			return true;
		}
		catch(Exception e){
			return false;
		}
	}
	
    private void highLight(WebElement webElement) {
	    String script = "arguments[0].setAttribute('style', arguments[1]);";
	    String arguments = "color: white; border: 2px solid rgb(109,254,48); text-shadow: 1px 1px rgb(48,156,1);";
	    for (int i = 0; i < 3; i++) {
			this.executeJavaScript(script, webElement, arguments);
			sleep(100);
			this.executeJavaScript(script, webElement);
			sleep(100);
	    }
    }

	private void executeJavaScript(String script, WebElement webElement, String arguments) {
		 JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		 javascriptExecutor.executeScript(script, webElement, arguments);
	}

	private void executeJavaScript(String script, WebElement webElement) {
		 JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		 javascriptExecutor.executeScript(script, webElement);
	}
	
	private void sleep(int mills) {
		try {
			Thread.sleep(mills);
		}
		catch (InterruptedException e) {}
	}
	

}

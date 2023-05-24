package com.github.marcosws.prototipoweb.core;

import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class BasePage {
	
	private WebDriver driver;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void validateTitle(String title) {
		assertEquals(title, driver.getTitle());
	}
	
	public void clickElement(WebElement element){
		element.click();
	}
	
	public void editElement(WebElement element, String text){
		element.sendKeys(text);
	}
	
	public void validateTextElement(WebElement element, String text) {
		assertEquals(text, element.getText());
	}
	
	public void elementIsDisplayed(WebElement element) {
		
	}
	

}

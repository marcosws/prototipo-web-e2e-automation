package com.github.marcosws.prototipoweb.core;

import java.time.Duration;

import com.github.marcosws.prototipoweb.core.DriverFactory.Browser;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	
	
	@Before
	public void beforeScenario() {
		DriverFactory.setDriver(Browser.CHROME);
		DriverFactory.getDriver().manage().window().maximize();
		DriverFactory.getDriver().get(Consts.WEB_APPLICATION);
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofMinutes(7));
	}
	
	@After
	public void afterScenario() {
		DriverFactory.quitDriver();
	}
	
	


}

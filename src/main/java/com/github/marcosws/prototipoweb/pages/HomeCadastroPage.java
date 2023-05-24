package com.github.marcosws.prototipoweb.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.github.marcosws.prototipoweb.core.BasePage;
import com.github.marcosws.prototipoweb.core.DriverFactory;

public class HomeCadastroPage extends BasePage  {
	
	@FindBy(xpath="//*[@id=\"container\"]/h1")
	private WebElement labelTituloHomeCadastroDeCliente;

	public HomeCadastroPage() {
		super(DriverFactory.getDriver());
		PageFactory.initElements(DriverFactory.getDriver(), this);
	}
	
	public void validarTituloHomeCadastroDeCliente() {
		this.validateTitle("Home : Cadastro de Cliente");
	}
	
	public void validarLabelHomeCadastroDeCliente() {
		this.validateTextElement(labelTituloHomeCadastroDeCliente, "Home - Cadastro de Cliente");
	}

}

package com.github.marcosws.prototipoweb.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.github.marcosws.prototipoweb.core.BasePage;
import com.github.marcosws.prototipoweb.core.DriverFactory;

public class LoginCadastroPage extends BasePage {
	
	@FindBy(xpath="//*[@id=\"container\"]/h1")
	private WebElement labelTituloLoginCadastroDeCliente;
	
	@FindBy(id="login")
	private WebElement campoNome;
	
	@FindBy(id="senha")
	private WebElement campoSenha;
	
	@FindBy(id="cadastrar")
	private WebElement botaoEntrar;
	
	@FindBy(id="label-login-erro")
	private WebElement labelErro;
	
	
	public LoginCadastroPage() {
		super(DriverFactory.getDriver());
		PageFactory.initElements(DriverFactory.getDriver(), this);
	}
	
	public void validarTituloLoginCadastroDeCliente() {
		this.validateTitle("Login : Cadastro de Cliente");
	}
	
	public void validarLabelLoginCadastroDeCliente() {
		this.validateTextElement(labelTituloLoginCadastroDeCliente, "Login - Cadastro de Cliente");
	}
	
	public void editarCampoNome(String nome) {
		this.editElement(campoNome, nome);
	}
	
	public void editarCampoSenha(String senha) {
		this.editElement(campoSenha, senha);
	}
	
	public void clicarBotaoEntrar() {
		this.clickElement(botaoEntrar);
	}
	
	public void validarLabelMensagemEntreComOLoginESenha() {
		this.validateTextElement(labelErro, "Entre com o login e senha!");
	}
	
	public void validarLabelMensagemLoginOuSenhaInvalidos() {
		this.validateTextElement(labelErro, "Login ou senha inválidos!");
	}

}

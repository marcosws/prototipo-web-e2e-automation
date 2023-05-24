package com.github.marcosws.prototipoweb.steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

import com.github.marcosws.prototipoweb.pages.HomeCadastroPage;
import com.github.marcosws.prototipoweb.pages.LoginCadastroPage;



public class LoginCadastroSteps {
	
	LoginCadastroPage loginCadastro = new LoginCadastroPage();
	HomeCadastroPage homeCadastro = new HomeCadastroPage();
	
	@Dado("que tenho acesso a pagina de login do cadastro")
	public void que_tenho_acesso_a_pagina_de_login_do_cadastro() {
		loginCadastro.validarTituloLoginCadastroDeCliente();
		loginCadastro.validarLabelLoginCadastroDeCliente();
	}

	@Quando("digito o login {string} no campo login")
	public void digito_o_login_no_campo_login(String string) {
		loginCadastro.editarCampoNome(string);
	}

	@Quando("digito a senha {string} no campo senha")
	public void digito_a_senha_no_campo_senha(String string) {
		loginCadastro.editarCampoSenha(string);
	}

	@Quando("clico no botão Entrar")
	public void clico_no_botão_entrar() {
		loginCadastro.clicarBotaoEntrar();
	}

	@Então("valido que apresentou a tela Home do Cadastro")
	public void valido_que_apresentou_a_tela_home_do_cadastro() {
		homeCadastro.validarTituloHomeCadastroDeCliente();
		homeCadastro.validarLabelHomeCadastroDeCliente();
	}

	@Então("valido que apresentou a label Login e senha inválidos")
	public void valido_que_apresentou_a_label_login_e_senha_inválidos() {
		loginCadastro.validarLabelMensagemLoginOuSenhaInvalidos();
	}

	@Então("valido que apresentou a label Entre com o login e senha")
	public void valido_que_apresentou_a_label_entre_com_o_login_e_senha() {
		loginCadastro.validarLabelMensagemEntreComOLoginESenha();
	}

}

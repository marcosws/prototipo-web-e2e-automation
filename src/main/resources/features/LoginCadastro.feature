#language: pt

@global @login
Funcionalidade: Acessar o cadastro de cliente

	@positivo
	Cenário: Acessar o cadastro de cliente com login e senha válidos
		Dado que tenho acesso a pagina de login do cadastro
		Quando digito o login "Admin" no campo login
		E digito a senha "admin123" no campo senha
		E clico no botão Entrar
		Então valido que apresentou a tela Home do Cadastro
		
	@negativo	
	Cenário: Acessar o cadastro de cliente com login e senha inválidos
		Dado que tenho acesso a pagina de login do cadastro
		Quando digito o login "Admin" no campo login
		E digito a senha "admin" no campo senha
		E clico no botão Entrar
		Então valido que apresentou a label Login e senha inválidos
		
	@negativo	
	Cenário: Acessar o cadastro de cliente com login e senha vazios
		Dado que tenho acesso a pagina de login do cadastro
		Quando clico no botão Entrar
		Então valido que apresentou a label Entre com o login e senha

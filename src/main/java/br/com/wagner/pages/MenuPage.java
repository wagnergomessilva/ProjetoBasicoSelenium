package br.com.wagner.pages;

import br.com.wagner.core.BasePage;

public class MenuPage extends BasePage {
	
	public void acessarTelaInserirConta() {
		clicarLink("Contas");
		clicarLink("Adicionar");
	}
	
	public void acessarTelaListarConta() {
		clicarLink("Contas");
		clicarLink("Listar");
	}
	
	public void acessarTelaInserirMovimentacao() {
		clicarLink("Criar Movimenta��o");		
	}
	
	public void acessarTelaResumoMensal() {
		clicarLink("Resumo Mensal");		
	}
	
	public void acessarTelaPrincipall() {
		clicarLink("Home");		
	}
}

package br.com.wagner.pages;

import br.com.wagner.core.BasePage;

public class MenuPage extends BasePage {
	
	public void acessarTelaInserirConta() {
		clicarLink("Contas");
		clicarLink("Adicionar");
	}	
}

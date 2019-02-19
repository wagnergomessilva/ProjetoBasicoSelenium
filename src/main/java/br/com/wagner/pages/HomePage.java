package br.com.wagner.pages;

import br.com.wagner.core.BasePage;

public class HomePage extends BasePage {
	
	public String obterSaldoConta(String nome) {
		return obterCelulaTabela("Conta", nome, "Saldo", "tabelaSaldo").getText();
	}
}

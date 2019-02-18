package br.com.wagner.testes;

import org.junit.Assert;
import org.junit.Test;

import br.com.wagner.core.BaseTeste;
import br.com.wagner.pages.ContasPage;
import br.com.wagner.pages.MenuPage;

public class ContaTeste extends BaseTeste {
	
	MenuPage menuPage = new MenuPage();
	ContasPage contasPage = new ContasPage();
	
	@Test
	public void testeInserirConta() {
		menuPage.acessarTelaInserirConta();
		contasPage.setNome("Conta do teste");
		contasPage.salvar();
		Assert.assertEquals("Conta adicionada com sucesso!", contasPage.obterMensagemSucesso());
	}
	
	@Test
	public void testeAlterarConta() {
		menuPage.acessarTelaListarConta();
		
		contasPage.clicarAlterarConta("Conta do teste");
		contasPage.setNome("Conta do Teste alterada");
		contasPage.salvar();
		Assert.assertEquals("Conta alterada com sucesso!", contasPage.obterMensagemSucesso());
	}
	
	@Test
	public void testeInserirContaMesmoNome() {
		menuPage.acessarTelaInserirConta();
		contasPage.setNome("Conta do Teste alterada");
		contasPage.salvar();
		Assert.assertEquals("Já existe uma conta com esse nome!", contasPage.obterMensagemErro());
	}
}

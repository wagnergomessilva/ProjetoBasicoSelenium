package br.com.wagner.testes;

import org.junit.Assert;
import org.junit.Test;

import br.com.wagner.core.BaseTeste;
import br.com.wagner.core.Propriedades;
import br.com.wagner.pages.ContasPage;
import br.com.wagner.pages.MenuPage;

public class RemoverMovimentacaoContaTeste extends BaseTeste {
	
	MenuPage menuPage = new MenuPage();
	ContasPage contasPage = new ContasPage();
	
	@Test
	public void testeExcluirContaConMovimentacao() {
		
		menuPage.acessarTelaListarConta();
		
		contasPage.clicarexcluirConta(Propriedades.NOME_CONTA_ALTERADA);
		Assert.assertEquals("Conta em uso na movimentações", contasPage.obterMensagemErro());
	}
}

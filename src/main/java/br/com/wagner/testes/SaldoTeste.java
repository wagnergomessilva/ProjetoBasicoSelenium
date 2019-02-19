package br.com.wagner.testes;

import org.junit.Assert;
import org.junit.Test;

import br.com.wagner.core.BaseTeste;
import br.com.wagner.core.Propriedades;
import br.com.wagner.pages.HomePage;
import br.com.wagner.pages.MenuPage;

public class SaldoTeste extends BaseTeste {
	
	HomePage homePage = new HomePage();
	MenuPage menuPage = new MenuPage();
	
	@Test
	public void testeSaldoConta() {
		menuPage.acessarTelaPrincipall();
		Assert.assertEquals("500.00", homePage.obterSaldoConta(Propriedades.NOME_CONTA_ALTERADA));
	}
}

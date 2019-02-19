package br.com.wagner.testes;

import org.junit.Assert;
import org.junit.Test;

import br.com.wagner.core.BaseTeste;
import br.com.wagner.pages.MenuPage;
import br.com.wagner.pages.ResumoPage;

public class ResumoTeste extends BaseTeste {
	
	private MenuPage menuPage = new MenuPage();
	private ResumoPage resumoPage = new ResumoPage(); 
	
	@Test
	public void testeExcluirMovimentacao() {
		
		menuPage.acessarTelaResumoMensal();
		
		resumoPage.excluirMovimentacao();
		
		Assert.assertEquals("Movimentação removida com sucesso!", resumoPage.obterMensagemSucesso());
		
	}
}

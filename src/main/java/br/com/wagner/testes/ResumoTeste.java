package br.com.wagner.testes;

import static br.com.wagner.core.DriverFactory.getDriver;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.wagner.core.BaseTeste;
import br.com.wagner.pages.MenuPage;
import br.com.wagner.pages.ResumoPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ResumoTeste extends BaseTeste {
	
	private MenuPage menuPage = new MenuPage();
	private ResumoPage resumoPage = new ResumoPage(); 
	
	@Test
	public void teste1_ExcluirMovimentacao() {		
		menuPage.acessarTelaResumoMensal();		
		resumoPage.excluirMovimentacao();		
		Assert.assertEquals("Movimenta��o removida com sucesso!", resumoPage.obterMensagemSucesso());		
	}
	
	@Test
	public void teste2_ResumoMensal() {
		menuPage.acessarTelaResumoMensal();		
		Assert.assertEquals("Seu Barriga - Extrato", getDriver().getTitle());
	}
}

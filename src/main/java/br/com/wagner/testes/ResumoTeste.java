package br.com.wagner.testes;

import static br.com.wagner.core.DriverFactory.getDriver;

import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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
		Assert.assertEquals("Movimentação removida com sucesso!", resumoPage.obterMensagemSucesso());		
	}
	
	@Test
	public void teste2_ResumoMensal() {
		menuPage.acessarTelaResumoMensal();		
		Assert.assertEquals("Seu Barriga - Extrato", getDriver().getTitle());
		
		List<WebElement> elementosEncontrados = 
			getDriver().findElements(By.xpath("//*[@id='tabelaExtrato']/tbody/tr"));
		
		Assert.assertEquals(0, elementosEncontrados.size());
	}
}

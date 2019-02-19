package br.com.wagner.testes;

import static utils.DataUtils.obterDataFormatada;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.wagner.core.BaseTeste;
import br.com.wagner.pages.MenuPage;
import br.com.wagner.pages.MovimentacaoPage;
import utils.DataUtils;

public class MovimentacaoTeste extends BaseTeste{
	
	private MenuPage menuPage = new MenuPage();
	private MovimentacaoPage movPage = new MovimentacaoPage();
	
	@Test
	public void testeInserirMovimentacao() {
		
		menuPage.acessarTelaInserirMovimentacao();
		
		movPage.setDataMovimentacao(obterDataFormatada(new Date()));
		movPage.setDataPagamento(obterDataFormatada(new Date()));
		movPage.setDescricao("Movimenta��o do Teste");
		movPage.setInteressado("Interessado qualquer");
		movPage.setValor("500");
		movPage.setConta("Conta do Teste alterada");
		movPage.setStatusPago();
		movPage.salvar();
		
		Assert.assertEquals("Movimenta��o adicionada com sucesso!", movPage.obterMensagemSucesso());
	}
	
	@Test
	public void testeCamposObrigatoris() {
		menuPage.acessarTelaInserirMovimentacao();
		movPage.salvar();
		List<String> errosMovimentacao = movPage.obterErrosMovimentacao();
		//Assert.assertEquals("Data da Movimenta��o � obrigat�rio", errosMovimentacao.get(0));
		//Assert.assertTrue(errosMovimentacao.contains("Data da Movimenta��o � obrigat�rio"));
		Assert.assertTrue(errosMovimentacao.containsAll(Arrays.asList(
						"Data da Movimenta��o � obrigat�rio", 
						"Data do pagamento � obrigat�rio",
						"Descri��o � obrigat�rio", 
						"Interessado � obrigat�rio", 
						"Valor � obrigat�rio",
						"Valor deve ser um n�mero")));
		Assert.assertEquals(6, errosMovimentacao.size());
	}
	
	@Test
	public void inserirMovimentacaoFutura() {
		menuPage.acessarTelaInserirMovimentacao();
		
		Date dataFutura = DataUtils.obterDataComDiferencaDias(5);
		
		movPage.setDataMovimentacao(obterDataFormatada(dataFutura));
		movPage.setDataPagamento(obterDataFormatada(dataFutura));
		movPage.setDescricao("Movimenta��o do Teste");
		movPage.setInteressado("Interessado qualquer");
		movPage.setValor("500");
		movPage.setConta("Conta do Teste alterada");
		movPage.setStatusPago();
		movPage.salvar();
		
		List<String> errosMovimentacaoFutura = movPage.obterErrosMovimentacao();
		Assert.assertTrue(errosMovimentacaoFutura.contains(
											("Data da Movimenta��o deve ser menor ou igual � data atual")));
		Assert.assertEquals(1, errosMovimentacaoFutura.size());
	}
}

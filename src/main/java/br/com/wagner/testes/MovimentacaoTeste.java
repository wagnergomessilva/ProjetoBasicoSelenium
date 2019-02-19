package br.com.wagner.testes;

import static utils.DataUtils.obterDataFormatada;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.wagner.core.BaseTeste;
import br.com.wagner.core.Propriedades;
import br.com.wagner.pages.MenuPage;
import br.com.wagner.pages.MovimentacaoPage;
import utils.DataUtils;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MovimentacaoTeste extends BaseTeste{
	
	private MenuPage menuPage = new MenuPage();
	private MovimentacaoPage movPage = new MovimentacaoPage();
	
	@Test
	public void teste1_InserirMovimentacao() {
		
		menuPage.acessarTelaInserirMovimentacao();
		
		movPage.setDataMovimentacao(obterDataFormatada(new Date()));
		movPage.setDataPagamento(obterDataFormatada(new Date()));
		movPage.setDescricao("Movimentação do Teste");
		movPage.setInteressado("Interessado qualquer");
		movPage.setValor("500");
		movPage.setConta(Propriedades.NOME_CONTA_ALTERADA);
		movPage.setStatusPago();
		movPage.salvar();
		
		Assert.assertEquals("Movimentação adicionada com sucesso!", movPage.obterMensagemSucesso());
	}
	
	@Test
	public void teste2_CamposObrigatoris() {
		menuPage.acessarTelaInserirMovimentacao();
		movPage.salvar();
		List<String> errosMovimentacao = movPage.obterErrosMovimentacao();
		//Assert.assertEquals("Data da Movimentação é obrigatório", errosMovimentacao.get(0));
		//Assert.assertTrue(errosMovimentacao.contains("Data da Movimentação é obrigatório"));
		Assert.assertTrue(errosMovimentacao.containsAll(Arrays.asList(
						"Data da Movimentação é obrigatório", 
						"Data do pagamento é obrigatório",
						"Descrição é obrigatório", 
						"Interessado é obrigatório", 
						"Valor é obrigatório",
						"Valor deve ser um número")));
		Assert.assertEquals(6, errosMovimentacao.size());
	}
	
	@Test
	public void teste3_inserirMovimentacaoFutura() {
		menuPage.acessarTelaInserirMovimentacao();
		
		Date dataFutura = DataUtils.obterDataComDiferencaDias(5);
		
		movPage.setDataMovimentacao(obterDataFormatada(dataFutura));
		movPage.setDataPagamento(obterDataFormatada(dataFutura));
		movPage.setDescricao("Movimentação do Teste");
		movPage.setInteressado("Interessado qualquer");
		movPage.setValor("500");
		movPage.setConta(Propriedades.NOME_CONTA_ALTERADA);
		movPage.setStatusPago();
		movPage.salvar();
		
		List<String> errosMovimentacaoFutura = movPage.obterErrosMovimentacao();
		Assert.assertTrue(errosMovimentacaoFutura.contains(
											("Data da Movimentação deve ser menor ou igual à data atual")));
		Assert.assertEquals(1, errosMovimentacaoFutura.size());
	}
}

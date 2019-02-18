package br.com.wagner.testes;

import org.junit.Assert;
import org.junit.Test;

import br.com.wagner.core.BaseTeste;
import br.com.wagner.pages.MenuPage;
import br.com.wagner.pages.MovimentacaoPage;

public class MovimentacaoTeste extends BaseTeste{
	
	private MenuPage menuPage = new MenuPage();
	private MovimentacaoPage movPage = new MovimentacaoPage();
	
	@Test
	public void testeInserirMovimentacao() {
		menuPage.acessarTelaInserirMovimentacao();
		
		movPage.setDataMovimentacao("01/09/2017");
		movPage.setDataPagamento("02/09/2017");
		movPage.setDescricao("Movimentação do Teste");
		movPage.setInteressado("Interessado qualquer");
		movPage.setValor("500");
		movPage.setConta("Conta do Teste alterada");
		movPage.setStatusPago();
		movPage.salvar();
		
		Assert.assertEquals("Movimentação adicionada com sucesso!", movPage.obterMensagemSucesso());
	}
}

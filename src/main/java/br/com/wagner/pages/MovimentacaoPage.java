package br.com.wagner.pages;

import static br.com.wagner.core.DriverFactory.getDriver;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.wagner.core.BasePage;

public class MovimentacaoPage extends BasePage {
	
	public void setDataMovimentacao(String dataMovimentacao) {
		escrever("data_transacao", dataMovimentacao);
	}
	
	public void setDataPagamento(String dataPagamento) {
		escrever("data_pagamento", dataPagamento);
	}
	
	public void setDescricao(String descricao) {
		escrever("descricao", descricao);
	}
	
	public void setInteressado(String interessado) {
		escrever("interessado", interessado);
	}
	
	public void setValor(String valor) {
		escrever("valor", valor);
	}
	
	public void setConta(String conta) {
		selecionarCombo("conta", conta);
	}
	
	public void setStatusPago() {
		clicarRadio("status_pago");
	}
	
	public void salvar() {
		clicarBotaoPorTexto("Salvar");
	}
	
	public String obterMensagemSucesso() {
		return obterTexto(By.xpath("//div[@class='alert alert-success']"));
	}
	
	public List<String> obterErrosMovimentacao(){
		List<WebElement> errosMovimentacao = getDriver().findElements(By.xpath("//div[@class='alert alert-danger']//li"));
		List<String> retorno = new ArrayList<String>();
		for (WebElement erro: errosMovimentacao) {
			retorno.add(erro.getText());
		}
		return retorno;
	}
}

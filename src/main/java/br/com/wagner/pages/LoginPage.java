package br.com.wagner.pages;

import static br.com.wagner.core.DriverFactory.getDriver;

import org.openqa.selenium.By;

import br.com.wagner.core.BasePage;

public class LoginPage extends BasePage {
	public void acessarTelaInicial() {
		getDriver().get("https://seubarriga.wcaquino.me/login");
	}
	
	public void setEmail(String email) {
		escrever("email", email);
	}
	
	public void setSenha(String senha) {
		escrever("senha", senha);
	}
	
	public void entrar() {
		clicarBotao(By.xpath("//button[.='Entrar']"));
	}
}

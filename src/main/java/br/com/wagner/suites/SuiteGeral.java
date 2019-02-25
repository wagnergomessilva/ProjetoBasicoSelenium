package br.com.wagner.suites;

import static br.com.wagner.core.DriverFactory.killDriver;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.wagner.pages.LoginPage;
import br.com.wagner.testes.ContaTeste;
import br.com.wagner.testes.MovimentacaoTeste;
import br.com.wagner.testes.RemoverMovimentacaoContaTeste;
import br.com.wagner.testes.ResumoTeste;
import br.com.wagner.testes.SaldoTeste;

@RunWith(Suite.class)
@SuiteClasses({
	ContaTeste.class,
	MovimentacaoTeste.class,
	RemoverMovimentacaoContaTeste.class,
	SaldoTeste.class,
	ResumoTeste.class
})
public class SuiteGeral {
	
	private static LoginPage page = new LoginPage();
	
	@BeforeClass
	public static void reset() {
		page.acessarTelaInicial();
		page.setEmail("wag.gomes2015@gmail.com");
		page.setSenha("abcd1234");
		page.entrar();
		
		page.resetarDados();
		
		killDriver();
	}
}

package br.com.wagner.core;

import static br.com.wagner.core.DriverFactory.getDriver;
import static br.com.wagner.core.DriverFactory.killDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import br.com.wagner.pages.LoginPage;

public class BaseTeste {
		
	@Rule
	public TestName testnome = new TestName(); 
	
	private LoginPage page = new LoginPage();
	
	@Before
	public void inicializa() {
		
		page.acessarTelaInicial();
		
		page.setEmail("wag.gomes2015@gmail.com");
		page.setSenha("abcd1234");
		page.entrar();
	}
	
	@After
	public void finaliza() throws IOException{
		
		TakesScreenshot screenshot = (TakesScreenshot) getDriver();
		File arquivo = screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquivo, new File("target"+File.separator+"screenshot"+File.separator + testnome.getMethodName() + ".jpg"));
		
		if (Propriedades.FECHAR_BROWSER) {
			killDriver();
		}
	}
}

package br.com.wagner.core;

import static br.com.wagner.core.DriverFactory.getDriver;
import static br.com.wagner.core.DriverFactory.killDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class BaseTeste {
	
	@Rule
	public TestName testnome = new TestName(); 
	
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

package br.com.wagner.core;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import br.com.wagner.core.Propriedades.TipoExecucao;

public class DriverFactory {
	
	//private static WebDriver driver;
	private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>() {
		@Override
		protected synchronized WebDriver initialValue() {
			return initDriver();
		}
	};
	
	private DriverFactory() {}
	
	public static WebDriver getDriver() {
		return threadDriver.get();
	}
	
	public static WebDriver initDriver() {
		
		WebDriver driver = null;		
		if (Propriedades.TIPO_EXECUCAO == TipoExecucao.LOCAL) {
			switch (Propriedades.NAVEGADOR) {
				case FIREFOX: System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");  driver = new FirefoxDriver(); break;
				case CHROME:  System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");  driver = new ChromeDriver(); break;
			}
		}
		if (Propriedades.TIPO_EXECUCAO == TipoExecucao.GRID) {
			DesiredCapabilities cap = null;
			switch (Propriedades.NAVEGADOR) {
				case FIREFOX: System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe"); cap = DesiredCapabilities.firefox(); break;
				case CHROME:  System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); cap = DesiredCapabilities.chrome(); break;
			}
			try {
				driver = new RemoteWebDriver(new URL("http://192.168.0.106:4444/wd/hub"), cap);
			} catch (MalformedURLException e) {
				System.err.println("Falha na conex�o com o Grid!");
				e.printStackTrace();
			}
		}
					
		driver.manage().window().maximize();
		
		return driver;
	}
	
	public static void killDriver() {
		WebDriver driver = getDriver();
		if (driver != null) {
			driver.quit();
			driver= null;
		}
		if (threadDriver!=null) {
			threadDriver.remove();
		}
	}
}

package br.com.wagner.core;

public class Propriedades {
	
	public static boolean FECHAR_BROWSER = true;
	
	public static Browsers NAVEGADOR = Browsers.CHROME;
	
	public static TipoExecucao TIPO_EXECUCAO = TipoExecucao.GRID;
	
	public enum Browsers{
		CHROME,
		FIREFOX
	}
	
	public enum TipoExecucao {
		LOCAL,
		GRID
	}
}

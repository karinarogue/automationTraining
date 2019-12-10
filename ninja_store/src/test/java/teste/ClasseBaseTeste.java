package teste;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClasseBaseTeste {
	
	protected WebDriver driver; 
	
public void iniciaAplicacao() {
		
		System.setProperty(ConfiguracoesTeste.NOME_DRIVER,ConfiguracoesTeste.CAMINHO_DRIVER);
		driver = new ChromeDriver();	// Instancia o driver
		driver.get(ConfiguracoesTeste.URL_APLICACAO);	// Abre a aplicacao 
		driver.manage().window().maximize();	// Maximiza o browser
			
	}
}

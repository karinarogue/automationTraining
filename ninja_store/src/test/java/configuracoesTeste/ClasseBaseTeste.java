package configuracoesTeste;

import org.openqa.selenium.WebDriver;


public class ClasseBaseTeste {

	protected WebDriver driver;

	public void iniciaAplicacao() {

		driver = DriverFactory.createDriver("chrome");
		driver.get(ConfiguracoesTeste.URL_APLICACAO);// abre a aplicacao
		driver.manage().window().maximize();

	}
}

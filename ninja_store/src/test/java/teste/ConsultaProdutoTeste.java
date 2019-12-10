package teste;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import configuracoesTeste.ClasseBaseTeste;
import pageobject.HomePagPagina;

public class ConsultaProdutoTeste extends ClasseBaseTeste{
	
	private HomePagPagina homePagPagina;
	
	@Before
	public void antesDoTeste() {
		iniciaAplicacao();
		homePagPagina = new HomePagPagina(driver);
	}
	
	@Test
	public void consultaProdutoTest() {
		homePagPagina.selecionaProduto();		
	}
	
	@After
	public void depoisDoTeste() {
		driver.quit();
	}
}

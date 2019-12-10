package teste;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import configuracoesTeste.ClasseBaseTeste;
import pageobject.AdicionaNoCarrinhoPagina;
import pageobject.HomePagPagina;

public class DeletaProdutoCartTeste extends ClasseBaseTeste {
	
private HomePagPagina homePagPagina;
private AdicionaNoCarrinhoPagina adicionaNoCarrinhoPagina;
	
	@Before
	public void antesDoTeste() {
		iniciaAplicacao();
		homePagPagina = new HomePagPagina(driver);
		adicionaNoCarrinhoPagina = new AdicionaNoCarrinhoPagina(driver);
	}
	
	@Test
	public void consultaProdutoTest() {
		homePagPagina.selecionaProduto();
		adicionaNoCarrinhoPagina.adicionaProduto();	
		adicionaNoCarrinhoPagina.deletaProduto();		
	}
	
	@After
	public void depoisDoTeste() {
		driver.quit();
	}
	

}

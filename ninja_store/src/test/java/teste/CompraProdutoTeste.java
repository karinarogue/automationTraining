package teste;



import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import configuracoesTeste.ClasseBaseTeste;
import pageobject.AdicionaNoCarrinhoPagina;
import pageobject.CheckOutPagina;
import pageobject.HomePagPagina;

public class CompraProdutoTeste extends ClasseBaseTeste{
	
private HomePagPagina homePagPagina;
private AdicionaNoCarrinhoPagina adicionaNoCarrinhoPagina;
private CheckOutPagina checkOutPagina;

	@Before
	public void antesDoTeste() {
		iniciaAplicacao();
		homePagPagina = new HomePagPagina(driver);
		adicionaNoCarrinhoPagina = new AdicionaNoCarrinhoPagina(driver);
		checkOutPagina = new CheckOutPagina(driver);
	}
	
	@Test
	public void adiconandoProdutoTest() {
		homePagPagina.selecionaProduto();
		adicionaNoCarrinhoPagina.adicionaProduto();	
		checkOutPagina.checkOutNoCarrinho();
		Assert.assertTrue(checkOutPagina.verificaCompraComSucesso());
	}
	
	@After
	public void depoisDoTeste() {
		driver.quit();
	}	
}

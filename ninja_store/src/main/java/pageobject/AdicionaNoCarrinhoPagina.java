package pageobject;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import massateste.MensagensNinja;

public class AdicionaNoCarrinhoPagina extends ClasseBasePageObject {
	
	public AdicionaNoCarrinhoPagina(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	private WebDriverWait wait;
		
	@FindBy(id = "button-cart")
	private WebElement addCart;
	
	@FindBy(xpath = "//*/div[@class='alert alert-success alert-dismissible']")
	private WebElement aguardaMensagem;
	
	@FindBy(id = "cart-total")
	private WebElement botaoItensCarrinho;
	
	@FindBy (xpath = "//*[@id='cart']/ul/li[2]/div/p/a[1]/strong")
	private WebElement viewCart;
	
	@FindBy(xpath = "//*/button[@class='btn btn-danger']")
	private WebElement botaoRemoveProduto;
	
	@FindBy(xpath = "//*/div[@class='pull-right']/a[@href='http://tutorialsninja.com/demo/index.php?route=common/home']")
	private WebElement confirmaMsgRemove;
	
	public void adicionaProduto() {
		
		addCart.click();
		
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(aguardaMensagem));	
		
		Assert.assertTrue(driver.getPageSource().contains(MensagensNinja.MENSAGEM_ADD_CARRINHO));
		
		botaoItensCarrinho.click();
		wait.until(ExpectedConditions.elementToBeClickable(viewCart)).click();;	
		
	}
	
	public void deletaProduto() {
		botaoRemoveProduto.click();
		
		wait.until(ExpectedConditions.visibilityOf(confirmaMsgRemove));
		Assert.assertTrue(driver.getPageSource().contains(MensagensNinja.MENSAGEM_REMOVE_CARRINHO));
		
	}
	
	public boolean verificaProdutoRemovidoDoCarrinho() {
		return(driver.getPageSource().contains(MensagensNinja.MENSAGEM_REMOVE_CARRINHO));
	}	
	
	public boolean verificaAddProdutoNoCarrinho() {
		return(driver.getPageSource().contains(MensagensNinja.MENSAGEM_ADD_CARRINHO));
	}		
}

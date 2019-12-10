package pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import massateste.MassaTeste;
import massateste.MensagensNinja;


public class CheckOutPagina extends ClasseBasePageObject{

	public CheckOutPagina(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	private Select select;
	private WebDriverWait wait;
	
	//criando um list de radio
	@FindBys({ 
		@FindBy(name="account")	
	})
	private List <WebElement> aguardaNewCustom;
	
	@FindBy(xpath ="//*[@id=\"content\"]/div[3]/div[2]/a")
	private WebElement checkOut;
		
	@FindBy(xpath="//*[@id=\"collapse-checkout-option\"]/div/div/div[1]/div[2]/label/input")
	private WebElement comboGuestCheck;
	
	@FindBy(xpath ="//*[@id=\"collapse-checkout-option\"]/div/div/div[1]/h2")
	private WebElement aguardaStep1;
	
	@FindBy(id="button-account")
	private WebElement botaoContinua;
	
	@FindBy(xpath ="//*[@id=\"account\"]/legend")
	private WebElement aguardaStep2;
	
	@FindBy (id ="input-payment-firstname")
	private WebElement nome;
	
	@FindBy (id ="input-payment-lastname")
	private WebElement sobrenome;
	
	@FindBy (id ="input-payment-email")
	private WebElement email;
	
	@FindBy (id ="input-payment-telephone")
	private WebElement telefone;
	
	@FindBy (id ="input-payment-address-1")
	private WebElement endereco1;
	
	@FindBy (id ="input-payment-city")
	private WebElement cidade;
	
	@FindBy (id ="input-payment-postcode")
	private WebElement postCod;
	
	@FindBy (id ="input-payment-country")
	private WebElement comboCountry;
	
	@FindBy (id ="input-payment-zone")
	private WebElement comboRegionState;
	
	@FindBy (id ="button-guest")
	private WebElement botaoContinueStep;
	
	@FindBy (name ="comment")
	private WebElement campoComentario;
	
	@FindBy (id ="button-shipping-method")
	private WebElement botaoStep5;
	
	@FindBy (id ="button-payment-method")
	private WebElement botaoStep6;
	
	@FindBy (id ="button-confirm")
	private WebElement botaoConfirmOrder;
	
	
	
	public void checkOutNoCarrinho() {
		checkOut.click();	
		
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(aguardaStep1));
		
		//seleciona o radio
		aguardaNewCustom.get(1).click();
		
		botaoContinua.click();
		
		wait.until(ExpectedConditions.visibilityOf(aguardaStep2));
		
		nome.sendKeys(MassaTeste.NOME);
		sobrenome.sendKeys(MassaTeste.SOBRENOME);
		email.sendKeys(MassaTeste.EMAIL);
		telefone.sendKeys(MassaTeste.TELEFONE);
		endereco1.sendKeys(MassaTeste.ENDERECO1);
		cidade.sendKeys(MassaTeste.CIDADE);
		postCod.sendKeys(MassaTeste.POST_COD);
		

		select = new Select(comboCountry); 
		select.selectByVisibleText(MassaTeste.COUNTRY);
		
		select = new Select(comboRegionState);
		wait.until(ExpectedConditions.textToBePresentInElement(comboRegionState, MassaTeste.REGION_STATE));
		select.selectByVisibleText(MassaTeste.REGION_STATE);	
		botaoContinueStep.click();
		
		wait.until(ExpectedConditions.visibilityOf(botaoStep5));		
		campoComentario.sendKeys(MassaTeste.COMENTARIO);
		botaoStep5.click();
		
		wait.until(ExpectedConditions.visibilityOf(botaoStep6));
		List<WebElement> checkAgree = driver.findElements(By.name("agree"));
		checkAgree.get(0).click();		
		botaoStep6.click();
		
		wait.until(ExpectedConditions.visibilityOf(botaoConfirmOrder));
		botaoConfirmOrder.click();
						
	}
	
	public boolean verificaCompraComSucesso() {
		wait.until(ExpectedConditions.urlContains("success"));
		return(driver.getPageSource().contains(MensagensNinja.MENSAGEM_COMPRA_FINALIZADA));
	}	
	
}

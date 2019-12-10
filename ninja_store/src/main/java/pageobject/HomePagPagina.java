package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePagPagina extends ClasseBasePageObject {
	
	Actions actions; // para utilizar o foco
	
	public HomePagPagina(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);	 
	}
	

	@FindBy(xpath ="//*[@id=\"menu\"]/div[2]/ul/li[1]/a")
	private WebElement clicaDesktops;
	
	@FindBy(xpath ="//*[@id=\"menu\"]/div[2]/ul/li[1]/div/div/ul/li[2]/a")
	private WebElement clicaProduto;
			
	@FindBy(xpath ="//*[@id=\"content\"]/div[2]/div/div/div[1]/a/img")
	private WebElement abreProduto;
	
	public void selecionaProduto() {
		
		new Actions(driver).moveToElement(clicaDesktops).perform();
				
		clicaProduto.click();
		
		abreProduto.click();
	}
	
	

}

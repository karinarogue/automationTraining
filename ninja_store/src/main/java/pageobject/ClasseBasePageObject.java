package pageobject;

import org.openqa.selenium.WebDriver;

public class ClasseBasePageObject {
	
	protected WebDriver driver;
		
		public ClasseBasePageObject(WebDriver driver) {
			this.driver = driver;
		}
}

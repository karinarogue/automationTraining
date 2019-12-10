package configuracoesTeste;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.ie.InternetExplorerDriver;

public abstract class DriverFactory {
	
	private static WebDriver driver;
	private static final String DRIVER_CHROME = "chrome";
	private static final String DRIVER_IE = "ie";
	private static final String HEADLESS_CHROME = "chrome-headless";

	public static WebDriver createDriver(String browserName) {
	   
	   if (browserName.equals(DRIVER_CHROME)) {
	      System.setProperty("webdriver.chrome.driver", "C:\\Users\\karina.rodrigues\\Desktop\\w_karina\\ninja_store\\src\\test\\resources\\chromedriver.exe");
	      driver = new ChromeDriver();
	   } 
	   
	   else if (browserName.equals(DRIVER_IE)) {
	      System.setProperty("webdriver.ie.driver", "C:\\Users\\karina.rodrigues\\Desktop\\w_karina\\ninja_store\\src\\test\\resources\\IEDriverServer.exe");
	      driver = new InternetExplorerDriver();
	   } 
	   
	  // else if (browserName.equals(DRIVER_FIREFOX)) {
	  //   System.setProperty("webdriver.gecko.driver", "C:\\Users\\karina.rodrigues\\Desktop\\w_karina\\ninja_store\\src\\test\\resources\\geckodriver.exe");
	  //   driver = new FirefoxDriver();
	  // } 
	   
	   else if (browserName.equals(HEADLESS_CHROME)) {
	      System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
	      ChromeOptions options = new ChromeOptions();
	      options.addArguments("--headless");
	      driver = new ChromeDriver(options);
	   } 
	   
	   return driver;
	   }
}



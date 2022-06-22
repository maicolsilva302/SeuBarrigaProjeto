package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
	
	private static WebDriver driver;
	
	private DriverFactory() {}
	
	public static WebDriver getDriver(){
		if(driver == null) {
			switch (Propriedades.browser) {
				case CHROME: driver = new ChromeDriver(); break;
			}
			driver.manage().window().maximize();	
		}
		return driver;
	}

	public static void killDriver(){
		if(driver != null) {
			driver.quit();
			driver = null;
		}
	}
}

package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage {

	
	public static final String ABOUT_US_NAVBAR_XPATH = "//*[@id=\"navbarSupportedContent\"]/ul/li[6]/a";
	public static final String ABOUT_US_POPUP_XPATH = "//a[@href='https://www.humanity.com/about']";
	public static final String LOGIN_XPATH = "//a/p[contains(text(),'LOGIN')]";
	public static final String URL = "https://www.humanity.com/";
	
	
	public static void mouseOverElement(WebDriver driver, String xPath) {
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(By.xpath(xPath));
		action.moveToElement(we).build().perform();
		
	}
	
	public static void goToHomePage(WebDriver driver) {
		driver.get(URL);
		driver.manage().window().maximize();
		driver.navigate().refresh();
	}
	
	public static void clickOnAboutUSPopupLink(WebDriver driver) {
		driver.findElement(By.xpath(ABOUT_US_POPUP_XPATH)).click();
	}
	
	public static void clickOnLogin(WebDriver driver) {
		driver.findElement(By.xpath(LOGIN_XPATH)).click();
	}

}

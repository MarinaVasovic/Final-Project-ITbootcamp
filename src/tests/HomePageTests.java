package tests;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import objects.HomePage;


public class HomePageTests {
	
	private static WebDriver driver = null;
	
	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Marina\\eclipse-workspace\\Projekat\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

	}
	
	@Test
	public static void takeScreenshotAboutUsPage() {
		
		HomePage.goToHomePage(driver);
		HomePage.mouseOverElement(driver, HomePage.ABOUT_US_NAVBAR_XPATH);
		HomePage.clickOnAboutUSPopupLink(driver);
		
		TakesScreenshot scrShot =(TakesScreenshot)driver;
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile=new File("C:\\Users\\Marina\\eclipse-workspace\\Projekat\\screenshots\\screenshot.jpg");
		try {
			FileHandler.copy(SrcFile, DestFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@AfterClass
	public static void afterTests() {
		driver.quit();		
	}

}

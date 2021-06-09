package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import objects.DashboardPage;
import objects.HomePage;
import objects.LoginPage;

public class LoginPageTests {
private static WebDriver driver = null;
	
	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Marina\\eclipse-workspace\\Projekat\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

	}
	
	@Test
	public static void testLogin() {
		
		String email = "belgrade2021@humanity.fr";
		String password = "testing";
		
		HomePage.goToHomePage(driver);
		HomePage.clickOnLogin(driver);
		LoginPage.typeEmail(driver, email);
		LoginPage.typePassword(driver, password);
		LoginPage.clickLoginButton(driver);
			
		Assert.assertEquals(driver.getCurrentUrl(), DashboardPage.DASHBOARD_URL);

	}
	
	@AfterMethod
	public static void afterTest() {
		driver.manage().deleteAllCookies();

	}
	
	@AfterClass
	public static void afterTests() {
		driver.quit();		
	}
}

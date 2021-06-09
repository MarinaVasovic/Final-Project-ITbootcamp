package tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import objects.DashboardPage;
import objects.HomePage;
import objects.LoginPage;
import objects.SettingsPage;

public class SettingsPageTests {

	private static WebDriver driver = null;

	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Marina\\eclipse-workspace\\Projekat\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

	}

	@Test
	public static void testChangeLanguage() {

		try {

			String email = "belgrade2021@humanity.fr";
			String password = "testing";
			String language = "Serbian (machine)";

			HomePage.goToHomePage(driver);
			HomePage.clickOnLogin(driver);
			LoginPage.typeEmail(driver, email);
			LoginPage.typePassword(driver, password);
			LoginPage.clickLoginButton(driver);

			DashboardPage.clickOnSettings(driver);
			SettingsPage.chooseLanguage(driver, language);
			SettingsPage.saveSettings(driver);

			Assert.assertTrue(SettingsPage.isSaveSettingsMessageSuccessfull(driver));
		} finally {
			DashboardPage.clickOnSettings(driver);
			SettingsPage.chooseLanguage(driver, "American English");
			SettingsPage.saveSettings(driver);

		}

	}

	@Test
	public static void testDisableNotifications() {

		try {
			String email = "belgrade2021@humanity.fr";
			String password = "testing";

			HomePage.goToHomePage(driver);
			HomePage.clickOnLogin(driver);
			LoginPage.typeEmail(driver, email);
			LoginPage.typePassword(driver, password);
			LoginPage.clickLoginButton(driver);

			DashboardPage.clickOnSettings(driver);

			SettingsPage.uncheckEmailNotification(driver);
			SettingsPage.uncheckSmsNotification(driver);
			SettingsPage.uncheckMobilePushNotification(driver);

			SettingsPage.saveSettings(driver);

			Assert.assertTrue(SettingsPage.isSaveSettingsMessageSuccessfull(driver));

			DashboardPage.clickOnDashboard(driver);
			DashboardPage.clickOnSettings(driver);

			SoftAssert sa = new SoftAssert();

			sa.assertFalse(SettingsPage.isEmailNotificationChecked(driver));
			sa.assertFalse(SettingsPage.isSmsNotificationChecked(driver));
			sa.assertFalse(SettingsPage.isMobilePushNotificationChecked(driver));

			sa.assertAll();
		}

		finally {

			DashboardPage.clickOnSettings(driver);
			SettingsPage.checkEmailNotification(driver);
			SettingsPage.checkSmsNotification(driver);
			SettingsPage.checkMobilePushNotification(driver);
		}
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

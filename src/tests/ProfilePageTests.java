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
import objects.ProfilePage;

public class ProfilePageTests {
	private static WebDriver driver = null;

	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Marina\\eclipse-workspace\\Projekat\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

	}

	@Test
	public static void testChangeBaseRatePayroll() {

		String email = "belgrade2021@humanity.fr";
		String password = "testing";
		String baseRate = "40";

		try {

			HomePage.goToHomePage(driver);
			HomePage.clickOnLogin(driver);
			LoginPage.typeEmail(driver, email);
			LoginPage.typePassword(driver, password);
			LoginPage.clickLoginButton(driver);

			Assert.assertEquals(driver.getCurrentUrl(), DashboardPage.DASHBOARD_URL);

			DashboardPage.clickOnProfilePic(driver);
			DashboardPage.clickOnProfileLink(driver);
			ProfilePage.clickOnPayroll(driver);
			ProfilePage.typeBaseRate(driver, baseRate);
			ProfilePage.savePayrollDetails(driver);

			Assert.assertTrue(ProfilePage.isUpdatePayrollMessageSuccessful(driver));

		} finally {

			DashboardPage.clickOnDashboard(driver);
			DashboardPage.clickOnProfilePic(driver);
			DashboardPage.clickOnProfileLink(driver);
			ProfilePage.clickOnPayroll(driver);
			ProfilePage.typeBaseRate(driver, "");
			ProfilePage.savePayrollDetails(driver);
		}

	}

	@Test
	public static void testEnableLeave() {

		String email = "belgrade2021@humanity.fr";
		String password = "testing";

		try {

			HomePage.goToHomePage(driver);
			HomePage.clickOnLogin(driver);
			LoginPage.typeEmail(driver, email);
			LoginPage.typePassword(driver, password);
			LoginPage.clickLoginButton(driver);

			Assert.assertEquals(driver.getCurrentUrl(), DashboardPage.DASHBOARD_URL);

			DashboardPage.clickOnProfilePic(driver);
			DashboardPage.clickOnProfileLink(driver);
			ProfilePage.clickOnLeave(driver);
			ProfilePage.clickEnable(driver);

			Assert.assertTrue(ProfilePage.isEnabled(driver));

		} finally {

			DashboardPage.clickOnDashboard(driver);
			DashboardPage.clickOnProfilePic(driver);
			DashboardPage.clickOnProfileLink(driver);
			ProfilePage.clickOnLeave(driver);
			ProfilePage.clickDisable(driver);

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

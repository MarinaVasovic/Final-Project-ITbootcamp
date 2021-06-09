package tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import objects.DashboardPage;
import objects.HomePage;
import objects.LoginPage;

public class DashboardTests {

	private static WebDriver driver = null;

	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Marina\\eclipse-workspace\\Projekat\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

	}

	@Test
	public static void testTopMenuPages() {
		String email = "belgrade2021@humanity.fr";
		String password = "testing";

		SoftAssert sa = new SoftAssert();

		HomePage.goToHomePage(driver);
		HomePage.clickOnLogin(driver);
		LoginPage.typeEmail(driver, email);
		LoginPage.typePassword(driver, password);
		LoginPage.clickLoginButton(driver);

		DashboardPage.clickOnDashboard(driver);

		sa.assertTrue(DashboardPage.isKeywordFound(driver, "dashboard"));

		DashboardPage.clickOnShiftplanning(driver);

		sa.assertTrue(DashboardPage.isKeywordFound(driver, "schedule"));

		DashboardPage.clickOnTimeClock(driver);

		sa.assertTrue(DashboardPage.isKeywordFound(driver, "timeclock"));

		DashboardPage.clickOnLeave(driver);

		sa.assertTrue(DashboardPage.isKeywordFound(driver, "vacation"));

		DashboardPage.clickOnTraining(driver);

		sa.assertTrue(DashboardPage.isKeywordFound(driver, "training"));

		DashboardPage.clickOnStaff(driver);

		sa.assertTrue(DashboardPage.isKeywordFound(driver, "staff"));

		DashboardPage.clickOnAvailability(driver);

		sa.assertTrue(DashboardPage.isKeywordFound(driver, "availability"));

		DashboardPage.clickOnPayroll(driver);

		sa.assertTrue(DashboardPage.isKeywordFound(driver, "payroll"));

		DashboardPage.clickOnReports(driver);

		sa.assertTrue(DashboardPage.isKeywordFound(driver, "reports"));

		sa.assertAll();

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

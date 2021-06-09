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
import objects.StaffPage;
import utils.ExcelUtils;

public class StaffPageTests {
	private static WebDriver driver = null;

	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Marina\\eclipse-workspace\\Projekat\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

	}

	@Test
	public static void testAddEmployee() {

		String email = "belgrade2021@humanity.fr";
		String password = "testing";
		String employeeFirstName = "Peter";
		String employeeLastName = "Peterson";

		try {

			HomePage.goToHomePage(driver);
			HomePage.clickOnLogin(driver);
			LoginPage.typeEmail(driver, email);
			LoginPage.typePassword(driver, password);
			LoginPage.clickLoginButton(driver);

			Assert.assertEquals(driver.getCurrentUrl(), DashboardPage.DASHBOARD_URL);

			DashboardPage.clickOnStaff(driver);
			StaffPage.clickOnAddEmployees(driver);
			StaffPage.typeFirstName(driver, employeeFirstName);
			StaffPage.typeLastName(driver, employeeLastName);
			StaffPage.clickOnSaveButton(driver);

			Assert.assertTrue(StaffPage.isAddingEmployeeMessageSuccessfull(driver));

			DashboardPage.clickOnStaff(driver);

			Assert.assertTrue(StaffPage.isEmployeeInStaffList(driver, employeeFirstName, employeeLastName));
		} finally {
			DashboardPage.clickOnStaff(driver);
			if (StaffPage.isEmployeeInStaffList(driver, employeeFirstName, employeeLastName)) {
				StaffPage.clickOnEmployee(driver, employeeFirstName, employeeLastName);
				ProfilePage.deleteEmployee(driver);
			}
		}

	}

	@Test
	public static void testChangeEmployeeName() {

		String email = "belgrade2021@humanity.fr";
		String password = "testing";
		String employeeFirstName = "John";
		String employeeLastName = "Johnson";
		String employeeChangedFirstName = "Marco";

		try {

			HomePage.goToHomePage(driver);
			HomePage.clickOnLogin(driver);
			LoginPage.typeEmail(driver, email);
			LoginPage.typePassword(driver, password);
			LoginPage.clickLoginButton(driver);

			Assert.assertEquals(driver.getCurrentUrl(), DashboardPage.DASHBOARD_URL);

			DashboardPage.clickOnStaff(driver);
			StaffPage.clickOnAddEmployees(driver);
			StaffPage.typeFirstName(driver, employeeFirstName);
			StaffPage.typeLastName(driver, employeeLastName);
			StaffPage.clickOnSaveButton(driver);

			Assert.assertTrue(StaffPage.isAddingEmployeeMessageSuccessfull(driver));

			DashboardPage.clickOnStaff(driver);

			Assert.assertTrue(StaffPage.isEmployeeInStaffList(driver, employeeFirstName, employeeLastName));

			StaffPage.clickOnEmployee(driver, employeeFirstName, employeeLastName);
			ProfilePage.clickOnEditDetails(driver, employeeFirstName, employeeLastName);

			ProfilePage.changeFirstName(driver, employeeChangedFirstName);
			ProfilePage.clickOnSaveEmployee(driver);

			Assert.assertTrue(ProfilePage.isUpdateEmployeeMessageSuccessful(driver));

			DashboardPage.clickOnStaff(driver);

			Assert.assertTrue(StaffPage.isEmployeeInStaffList(driver, employeeChangedFirstName, employeeLastName));
		} finally {
			DashboardPage.clickOnStaff(driver);
			if (StaffPage.isEmployeeInStaffList(driver, employeeFirstName, employeeLastName)) {
				StaffPage.clickOnEmployee(driver, employeeFirstName, employeeLastName);
				ProfilePage.deleteEmployee(driver);
			}
		}

	}

	@Test
	public static void addMultipleEmployees() {

		String email = "belgrade2021@humanity.fr";
		String password = "testing";
		ExcelUtils.readFromExcelFile("Employees.xlsx");
		ExcelUtils.getSheet(0);
		int numberOfRows = ExcelUtils.getNumberOfRows();

		try {

			HomePage.goToHomePage(driver);
			HomePage.clickOnLogin(driver);
			LoginPage.typeEmail(driver, email);
			LoginPage.typePassword(driver, password);
			LoginPage.clickLoginButton(driver);

			Assert.assertEquals(driver.getCurrentUrl(), DashboardPage.DASHBOARD_URL);

			for (int i = 1; i <= numberOfRows; i++) {

				DashboardPage.clickOnStaff(driver);
				StaffPage.clickOnAddEmployees(driver);
				StaffPage.typeFirstName(driver, ExcelUtils.getData(i, 0));
				StaffPage.typeLastName(driver, ExcelUtils.getData(i, 1));
				StaffPage.clickOnSaveButton(driver);

				Assert.assertTrue(StaffPage.isAddingEmployeeMessageSuccessfull(driver));

				DashboardPage.clickOnStaff(driver);

				Assert.assertTrue(
						StaffPage.isEmployeeInStaffList(driver, ExcelUtils.getData(i, 0), ExcelUtils.getData(i, 1)));
			}
		} finally {
			DashboardPage.clickOnStaff(driver);
			for (int i = 1; i <= numberOfRows; i++) {
				if (StaffPage.isEmployeeInStaffList(driver, ExcelUtils.getData(i, 0), ExcelUtils.getData(i, 1))) {
					StaffPage.clickOnEmployee(driver, ExcelUtils.getData(i, 0), ExcelUtils.getData(i, 1));
					ProfilePage.deleteEmployee(driver);
				}
			}
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

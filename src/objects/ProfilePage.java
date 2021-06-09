package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {
	public static final String EDIT_DETAILS = "//a[contains(text(),'Edit Details')]";
	public static final String FIRST_NAME_EDIT_DETAILS_ID = "first_name";
	public static final String SAVE_EMPLOYEE_EDIT_DETAILS_XPATH = "//button[contains(text(),'Save Employee')]";
	public static final String UPDATE_EMPLOYEE_MESSAGE = "Employee Updated";
	public static final String DELETE_CLICK_XPATH = "//a[contains(text(),'Click Here')]";
	public static final String PAYROLL_PROFILE_XPATH = "//*[@id=\"_cd_staff\"]/div[2]/div[2]/div[1]/a[8]";
	public static final String BASE_RATE_INPUT_XPATH = "//*[@id=\"emp_pr\"]/table/tbody/tr[2]/td[3]/input";
	public static final String UPDATE_PAYROLL_RATES_MESSAGE = "Rates Updated";
	public static final String SAVE_PAYROLL_DETAILS_CSS = "button#emp_pr_update";
	public static final String LEAVE_PROFILE_XPATH = "//*[@id=\"_cd_staff\"]/div[2]/div[2]/div[1]/a[4]";
	public static final String LEAVE_ENABLE_XPATH = "//a[contains(text(),'Enable')]";
	public static final String LEAVE_DISABLE_XPATH = "//a[contains(text(),'Disable')]";

	public static void clickOnEditDetails(WebDriver driver, String firstName, String LastName) {
		driver.findElement(By.xpath(EDIT_DETAILS)).click();
	}

	public static void changeFirstName(WebDriver driver, String firstName) {
		WebElement element = driver.findElement(By.id(FIRST_NAME_EDIT_DETAILS_ID));
		element.clear();
		element.sendKeys(firstName);
	}

	public static void clickOnSaveEmployee(WebDriver driver) {
		driver.findElement(By.xpath(SAVE_EMPLOYEE_EDIT_DETAILS_XPATH)).click();
	}

	public static boolean isUpdateEmployeeMessageSuccessful(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement search = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.id(StaffPage.ALERT_MESSAGE_ID)));
		String alertMessage = search.getText();
		return alertMessage.equals(UPDATE_EMPLOYEE_MESSAGE);
	}

	public static void deleteEmployee(WebDriver driver) {
		driver.findElement(By.xpath(DELETE_CLICK_XPATH)).click();
		driver.switchTo().alert().accept();
	}

	public static void clickOnPayroll(WebDriver driver) {
		driver.findElement(By.xpath(PAYROLL_PROFILE_XPATH)).click();
	}

	public static void clickOnLeave(WebDriver driver) {
		driver.findElement(By.xpath(LEAVE_PROFILE_XPATH)).click();
	}

	public static void typeBaseRate(WebDriver driver, String baseRate) {
		WebElement element = driver.findElement(By.xpath(BASE_RATE_INPUT_XPATH));
		element.clear();
		element.sendKeys(baseRate);
	}

	public static void savePayrollDetails(WebDriver driver) {
		driver.findElement(By.cssSelector(SAVE_PAYROLL_DETAILS_CSS)).click();
	}

	public static boolean isUpdatePayrollMessageSuccessful(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement search = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.id(StaffPage.ALERT_MESSAGE_ID)));
		String alertMessage = search.getText();
		return alertMessage.equals(UPDATE_PAYROLL_RATES_MESSAGE);
	}

	public static String getBaseRate(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath(BASE_RATE_INPUT_XPATH));
		return element.getText();
	}

	public static boolean isEnabled(WebDriver driver) {
		try {
			WebElement element = driver.findElement(By.xpath(LEAVE_ENABLE_XPATH));
			return false;
		} catch (NoSuchElementException e) {
			return true;
		}
	}

	public static boolean isDisabled(WebDriver driver) {
		try {
			WebElement element = driver.findElement(By.xpath(LEAVE_DISABLE_XPATH));
			return false;
		} catch (NoSuchElementException e) {
			return true;
		}
	}

	public static void clickEnable(WebDriver driver) {
		if (!isEnabled(driver)) {
			driver.findElement(By.xpath(LEAVE_ENABLE_XPATH)).click();
			sleepInSeconds(3);
		}
	}

	public static void clickDisable(WebDriver driver) {
		if (isEnabled(driver)) {
			driver.findElement(By.xpath(LEAVE_DISABLE_XPATH)).click();
			driver.switchTo().alert().accept();
		}

	}

	public static void sleepInSeconds(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

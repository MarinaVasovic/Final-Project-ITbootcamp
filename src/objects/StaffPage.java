package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StaffPage {

	public static final String ADD_EMPLOYEES_BUTTON_XPATH = "//button[contains(text(),'Add Employees')]";
	public static final String EMPLOYEE1_FIRST_NAME = "//tr[contains(@alt,'1')]/td[2]/input";
	public static final String EMPLOYEE1_LAST_NAME = "//tr[contains(@alt,'1')]/td[3]/input";
	public static final String EMPLOYEE1_EMAIL = "//tr[contains(@alt,'1')]/td[3]/input";
	public static final String SAVE_BUTTON_CSS = "button#_as_save_multiple";
	public static final String ALERT_MESSAGE_ID = "_status";
	public static final String ADD_EMPLOYEE_MESSAGE = "1 employee saved!";
	
	
	public static void clickOnAddEmployees(WebDriver driver) {
		driver.findElement(By.xpath(ADD_EMPLOYEES_BUTTON_XPATH)).click();
	}

	public static void clickOnSaveButton(WebDriver driver) {
		driver.findElement(By.cssSelector(SAVE_BUTTON_CSS)).click();
	}

	public static void typeFirstName(WebDriver driver, String firstName) {
		WebElement emailElement = driver.findElement(By.xpath(EMPLOYEE1_FIRST_NAME));
		emailElement.clear();
		emailElement.sendKeys(firstName);
	}

	public static void typeLastName(WebDriver driver, String lastName) {

		WebElement passwordElement = driver.findElement(By.xpath(EMPLOYEE1_LAST_NAME));
		passwordElement.clear();
		passwordElement.sendKeys(lastName);
	}

	public static boolean isAddingEmployeeMessageSuccessfull(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(ALERT_MESSAGE_ID)));
		String alertMessage = search.getText();
		return alertMessage.equals(ADD_EMPLOYEE_MESSAGE);
	}

	public static boolean isEmployeeInStaffList(WebDriver driver, String firstName, String lastName) {
		return driver
				.findElements(By
						.xpath("//div[@class='staff-list']//a[contains(text(),'" + firstName + " " + lastName + "')]"))
				.size() > 0;
	}

	public static void clickOnEmployee(WebDriver driver, String firstName, String LastName) {
		driver.findElement(
				By.xpath("//div[@class='staff-list']//a[contains(text(),'" + firstName + " " + LastName + "')]"))
				.click();
	}

	
}

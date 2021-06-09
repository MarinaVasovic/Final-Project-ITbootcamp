package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	public static final String EMAIL_ID = "email";
	public static final String PASSWORD_ID = "password";
	public static final String LOGIN_NAME = "login";


	public static void typeEmail(WebDriver driver, String email) {
		WebElement emailElement = driver.findElement(By.id(EMAIL_ID));
		emailElement.clear();
		emailElement.sendKeys(email);
	}

	public static void typePassword(WebDriver driver, String password) {

		WebElement passwordElement = driver.findElement(By.id(PASSWORD_ID));
		passwordElement.clear();
		passwordElement.sendKeys(password);
	}

	public static void clickLoginButton(WebDriver driver) {

		driver.findElement(By.name(LOGIN_NAME)).click();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DashboardPage.HUMANITY_LOGO_XPATH)));
	}

}

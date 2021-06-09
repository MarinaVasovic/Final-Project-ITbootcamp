package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SettingsPage {

	public static final String LANGUAGE_SELECT_NAME = "language";
	public static final String SAVE_SETTINGS_ID = "act_primary";
	public static final String ALERT_MESSAGE_ID = "_status";
	public static final String SAVE_SETTINNGS_MESSAGE = "Settings Updated";
	public static final String EMAIL_CHECKBOX_ID = "pref_pref_email";
	public static final String SMS_CHECKBOX_ID = "pref_pref_sms";
	public static final String MOBILE_CHECKBOX_ID = "pref_pref_mobile_push";
	
	
	public static void chooseLanguage(WebDriver driver, String language) {
		Select lang = new Select(driver.findElement(By.name(LANGUAGE_SELECT_NAME)));
		lang.selectByVisibleText(language);	
	}
	
	public static void saveSettings(WebDriver driver) {
		driver.findElement(By.id(SAVE_SETTINGS_ID)).click();
	}

	public static boolean isSaveSettingsMessageSuccessfull (WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(ALERT_MESSAGE_ID)));
		String alertMessage = 	search.getText();
		return alertMessage.equals(SAVE_SETTINNGS_MESSAGE);
		}
	
	public static void uncheckEmailNotification(WebDriver driver) {
		WebElement emailCheckbox = driver.findElement(By.id(EMAIL_CHECKBOX_ID));
		if(emailCheckbox.isSelected()) {
			emailCheckbox.click();
		}
	}
	
	public static void uncheckSmsNotification(WebDriver driver) {
		WebElement emailCheckbox = driver.findElement(By.id(SMS_CHECKBOX_ID));
		if(emailCheckbox.isSelected()) {
			emailCheckbox.click();
		}
	}
	
	public static void uncheckMobilePushNotification(WebDriver driver) {
		WebElement emailCheckbox = driver.findElement(By.id(MOBILE_CHECKBOX_ID));
		if(emailCheckbox.isSelected()) {
			emailCheckbox.click();
		}
	}
	
	public static void checkMobilePushNotification(WebDriver driver) {
		WebElement emailCheckbox = driver.findElement(By.id(MOBILE_CHECKBOX_ID));
		if(!emailCheckbox.isSelected()) {
			emailCheckbox.click();
		}	
}
	public static void checkEmailNotification(WebDriver driver) {
		WebElement emailCheckbox = driver.findElement(By.id(EMAIL_CHECKBOX_ID));
		if(!emailCheckbox.isSelected()) {
			emailCheckbox.click();
		}
	}
	
	public static void checkSmsNotification(WebDriver driver) {
		WebElement emailCheckbox = driver.findElement(By.id(SMS_CHECKBOX_ID));
		if(!emailCheckbox.isSelected()) {
			emailCheckbox.click();
		}
	}
	
	public static boolean isSmsNotificationChecked(WebDriver driver) {
		WebElement smsCheckbox = driver.findElement(By.id(SMS_CHECKBOX_ID));
		return smsCheckbox.isSelected();
	}
	
	public static boolean isEmailNotificationChecked(WebDriver driver) {
		WebElement emailCheckbox = driver.findElement(By.id(EMAIL_CHECKBOX_ID));
		return emailCheckbox.isSelected();
	}
	
	public static boolean isMobilePushNotificationChecked(WebDriver driver) {
		WebElement mobileCheckbox = driver.findElement(By.id(MOBILE_CHECKBOX_ID));
		return mobileCheckbox.isSelected();
	}
	
}

package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {

	
	public static final String DASHBOARD_URL = "https://marinavasovic.humanity.com/app/dashboard/";
	public static final String HUMANITY_LOGO_XPATH = "//*[@id=\"_nav\"]/div[1]/img";
	public static final String DASHBOARD_XPATH = "//p[contains(text(),'Dashboard')]";
	public static final String SHIFTPLANNING_XPATH = "//p[contains(text(),'ShiftPlanning')]";
	public static final String TIME_CLOCK_XPATH = "//p[contains(text(),'Time Clock')]";
	public static final String LEAVE_XPATH = "//p[contains(text(),'Leave')]";
	public static final String TRAINING_XPATH = "//p[contains(text(),'Training')]";
	public static final String STAFF_XPATH = "//p[contains(text(),'Staff')]";
	public static final String AVAILABILITY_XPATH = "//p[contains(text(),'Availability')]";
	public static final String PAYROLL_XPATH = "//p[contains(text(),'Payroll')]";
	public static final String REPORTS_XPATH = "//p[contains(text(),'Reports')]";
	public static final String SETTINGS_XPATH = "//*[@id=\"sn_admin\"]/span/i";
	public static final String NAVBAR_LABEL_XPATH = "//*[@id='_topnavLabel']";
	public static final String PROFILE_PIC_ID ="tr_avatar";
	public static final String PROFILE_LINK_XPATH ="//a[contains(text(),'Profile')]";
	public static final String UNAVAILABILITY_REQUEST_XPATH= "//div[@class='BaseButton-content' and contains(text(),'Unavailability Request')]";

	
	
    public static void sleepInSeconds(int seconds) {
    	try {
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
	
	public static void clickOnDashboard(WebDriver driver) {
		driver.findElement(By.xpath(DASHBOARD_XPATH)).click();
		waitUntilElementIsVisible(driver, NAVBAR_LABEL_XPATH);
	
	}
	
	public static void clickOnShiftplanning(WebDriver driver) {
		driver.findElement(By.xpath(SHIFTPLANNING_XPATH)).click();
		waitUntilElementIsVisible(driver, NAVBAR_LABEL_XPATH);

	}
	
	public static void clickOnTimeClock(WebDriver driver) {
		driver.findElement(By.xpath(TIME_CLOCK_XPATH)).click();
     	waitUntilElementIsVisible(driver, NAVBAR_LABEL_XPATH);

	}
	
	public static void clickOnLeave(WebDriver driver) {
		driver.findElement(By.xpath(LEAVE_XPATH)).click();
		waitUntilElementIsVisible(driver, NAVBAR_LABEL_XPATH);

	}
	
	public static void clickOnTraining(WebDriver driver) {
		driver.findElement(By.xpath(TRAINING_XPATH)).click();
		waitUntilElementIsVisible(driver, NAVBAR_LABEL_XPATH);

	}
	
	public static void clickOnStaff(WebDriver driver) {
		driver.findElement(By.xpath(STAFF_XPATH)).click();
		waitUntilElementIsVisible(driver, NAVBAR_LABEL_XPATH);
		sleepInSeconds(6);
	}
	
	public static void clickOnAvailability(WebDriver driver) {
		driver.findElement(By.xpath(AVAILABILITY_XPATH)).click();
		waitUntilElementIsVisible(driver, UNAVAILABILITY_REQUEST_XPATH);
		sleepInSeconds(6);

	}
	
	public static void clickOnPayroll(WebDriver driver) {
		driver.findElement(By.xpath(PAYROLL_XPATH)).click();
		waitUntilElementIsVisible(driver, NAVBAR_LABEL_XPATH);

	}
	
	public static void clickOnReports(WebDriver driver) {
		driver.findElement(By.xpath(REPORTS_XPATH)).click();
		waitUntilElementIsVisible(driver, NAVBAR_LABEL_XPATH);

	}
	
	public static void clickOnSettings(WebDriver driver) {
		driver.findElement(By.xpath(SETTINGS_XPATH)).click();
		sleepInSeconds(5);
		waitUntilElementIsVisible(driver, NAVBAR_LABEL_XPATH);

	}
	
	public static void clickOnProfilePic(WebDriver driver) {
		driver.findElement(By.id(PROFILE_PIC_ID)).click();
		waitUntilElementIsVisible(driver, NAVBAR_LABEL_XPATH);

	}
	
	public static void clickOnProfileLink(WebDriver driver) {
		driver.findElement(By.xpath(PROFILE_LINK_XPATH)).click();
		waitUntilElementIsVisible(driver, ProfilePage.PAYROLL_PROFILE_XPATH);
        sleepInSeconds(6);
        driver.navigate().refresh();
	}
	
	public static void waitUntilElementIsVisible(WebDriver driver, String xPath) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));
	}
	
	public static boolean isKeywordFound(WebDriver driver, String keyword) {
		String currURL = driver.getCurrentUrl();
		String[] words = currURL.split("/");
		for(String word: words) {
			if(word.equals(keyword)) {
				return true;
			}
		}
		return false;
	}
}

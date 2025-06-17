package com.creatio.crm.framework.web.commons;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.creatio.crm.framework.base.BasePage;
import com.creatio.crm.framework.constants.Constants;
import com.creatio.crm.framework.reports.Reports;
import com.creatio.crm.framework.utilities.PropUtil;


public class WebCommons {

	public WebDriver driver = BasePage.getDriver();
	Properties prop = PropUtil.readData("Config.properties");

	public void launchApplication() {
		driver.get(prop.getProperty("APP_URL"));

	}

	public void scrollToElement(WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void click(WebElement element) {
		scrollToElement(element);
		element.click();
	}

	public void jsClick(WebElement element) {
		scrollToElement(element);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);

	}

	public void doubleClick(WebElement element) {
		scrollToElement(element);
		new Actions(driver).scrollToElement(element).perform();

	}

	public void rightClick(WebElement element) {
		scrollToElement(element);
		new Actions(driver).contextClick(element).perform();
	}

	public void enterElement(WebElement element, String text) {
		scrollToElement(element);
		element.clear();
		element.sendKeys(text);
	}

	public void enterTextUsingActions(WebElement element, String text) {
		scrollToElement(element);
		new Actions(driver).sendKeys(element, text).perform();
	}

	public void selectCheckBox(WebElement element, boolean status) {
		scrollToElement(element);
		if (element.isSelected() != status) {
			element.click();
		}
	}

	public void selectDropdownOption(WebElement dropdown, String option, String selectBy) {
		scrollToElement(dropdown);
		Select select = new Select(dropdown);
		switch (selectBy.toLowerCase()) {
		case "value":
			select.selectByValue(option);
			break;
		case "visibletext":
			select.selectByVisibleText(option);
			break;
		case "index":
			select.selectByIndex(Integer.parseInt(option));
			break;
		default:
			throw new IllegalArgumentException("Invalid selection method: " + selectBy);
		}
	}

	public void wait(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void implicitWait(int seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));

	}

	public void waitForElement(WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.WAIT_TIME));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitForElement(By locator, long seconds) {
		new WebDriverWait(driver, Duration.ofSeconds(seconds))
				.until(ExpectedConditions.numberOfElementsToBeMoreThan(locator, 0));
	}

	public void waitForAlert(long seconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.alertIsPresent());
	}

	public void uploadFile(WebElement element, String filePath) {
		scrollToElement(element);
		element.sendKeys(filePath);
	}

	public static String windowScreenshot(WebDriver driver, String fileName) throws IOException {
		String screenshotPath = System.getProperty("user.dir") + "\\Screenshots\\" + fileName + ".png";
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(screenshotPath));
		return screenshotPath;
	}

	public static String elementScreenshot(WebElement element, String fileName) throws IOException {
		String screenshotPath = System.getProperty("user.dir") + "\\Screenshots\\" + fileName + ".png";
		File screenshotFile = element.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(screenshotPath));
		return screenshotPath;
	}

	public void switchToFrame(WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}

	public void switchToFrameIdOrFrameName(String idOrFrameName) {
		driver.switchTo().frame(idOrFrameName);
	}

	public void switchToFrameById(int id) {
		driver.switchTo().frame(id);
	}

	public String uniqueId(String format) {
		return new SimpleDateFormat(format).format(Calendar.getInstance().getTime());
	}

	public boolean isElementEnabled(WebElement element) {
		return element.isEnabled();
	}

	public String getElementText(WebElement element) {
		return element.getText();
	}

	public String getAttributeValue(WebElement element, String attribute) {
		return element.getAttribute(attribute);
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public boolean isElementDisplayed(WebElement element) {
		return element.isDisplayed();
	}

	public String getCurrentWindowHandle() {
		return driver.getWindowHandle();
	}

	public Set<String> getAllWindowHandles() {
		return driver.getWindowHandles();
	}

	public void switchToNewWindow() {
		String currentWindow = driver.getWindowHandle();
		for (String handle : driver.getWindowHandles()) {
			if (!handle.equals(currentWindow)) {
				driver.switchTo().window(handle);
				break;
			}
		}
	}

	public void switchToWindowByTitle(String title) {
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
			if (driver.getTitle().equalsIgnoreCase(title)) {
				break;
			}
		}
	}

	public void switchToWindow(String windowHandle) {
		driver.switchTo().window(windowHandle);
	}

	public void closeAllOtherWindows() {
		String mainWindow = driver.getWindowHandle();
		for (String handle : driver.getWindowHandles()) {
			if (!handle.equals(mainWindow)) {
				driver.switchTo().window(handle);
				driver.close();
			}
		}
		driver.switchTo().window(mainWindow);
	}

	public void acceptAlert() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public void dismissAlert() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	public String getAlertText() {
		return driver.switchTo().alert().getText();
	}

	public void sendTextToAlert(String text) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(text);
	}

	public void navigateBack() {
		driver.navigate().back();
	}

	public void navigateForward() {
		driver.navigate().forward();
	}

	public void refreshPage() {
		driver.navigate().refresh();
	}

	public boolean isElementPresent(WebElement element) {
		try {
			return element.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public void mouseHover(WebElement element) {
		scrollToElement(element);
		new Actions(driver).moveToElement(element).perform();
	}

	public void scrollToBottom() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	}

	public void scrollToTop() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 0);");
	}
	
	/**
	 * Method to print logs in the report.
	 */
    public void log(String status, String message) {
		if(status.equalsIgnoreCase("info")) {
			Reports.logger.info("INFO: " + message);
		} else if(status.equalsIgnoreCase("pass")) {
			Reports.logger.pass("PASS: " + message);
		} else if(status.equalsIgnoreCase("fail")) {
			Reports.logger.fail("FAIL: " + message);
		} else if(status.equalsIgnoreCase("warn")) {
			Reports.logger.warning("WARNING: " + message);
		} else {
			System.out.println("UNKNOWN STATUS: " + message);
		}
	}


}

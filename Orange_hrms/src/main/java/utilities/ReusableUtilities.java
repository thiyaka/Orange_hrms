package utilities;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReusableUtilities {

	public static void sendKeys(WebElement element, String value) {
		element.click();
		element.clear();

		element.sendKeys(value);
	}

	public static WebElement waitForElementToBeClickable(WebDriver driver, WebElement element, int timeout) {

		// WebDriverWait wait = new WebDriverWait(driver,
		// Duration.ofSeconds(timeoutInSeconds));
		WebDriverWait wait = waitinitializationCustomTimer(driver, timeout);
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static WebElement waitForElementVisiblity(WebDriver driver, WebElement element, int timeout) {

		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
		WebDriverWait wait = waitinitializationCustomTimer(driver, timeout);
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static WebElement waitAndClear(WebDriver driver, WebElement element, int timeout) {

		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));

		WebDriverWait wait = waitinitializationCustomTimer(driver, timeout);
		WebElement el = wait.until(ExpectedConditions.elementToBeClickable(element));
		el.clear();
		wait.until(ExpectedConditions.attributeToBe(el, "value", ""));
		return el;
	}

	public static void clearAndType(WebDriver driver, WebElement element, String value, int timeout) {

		WebElement el = waitForElementToBeClickable(driver, element, timeout);

		el.click();
		el.sendKeys(Keys.CONTROL + "a");
		el.sendKeys(Keys.DELETE);
		el.sendKeys(value);
	}

	public static boolean waitForSuccessmsg(WebDriver driver, WebElement toast, int timeout) {

		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));

		WebDriverWait wait = waitinitializationCustomTimer(driver, timeout);
		return wait.until(ExpectedConditions.visibilityOf(toast)).isDisplayed();
	}

	public static Boolean waitForFormToLoad(WebDriver driver, WebElement formLoader) {
		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebDriverWait wait = waitinitializationDefaultTimer(driver);
		return wait.until(ExpectedConditions.invisibilityOf(formLoader));
	}

	// wait method

	public static WebDriverWait waitinitializationDefaultTimer(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait;
	}
	
	public static WebDriverWait waitinitializationCustomTimer(WebDriver driver, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait;
	}

}

package com.n3.WD.support;

import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WaitTool {


	public static final int DEFAULT_WAIT_4_ELEMENT = 7;
	public static final int DEFAULT_WAIT_4_PAGE = 12;

	private static WaitTool waitTool;
	private static WebDriver wdDriver;


	public WaitTool(WebDriver driver){
		wdDriver = driver;
	}

	public static WaitTool getInstance(WebDriver driver){
		if(waitTool == null || wdDriver.hashCode() != driver.hashCode())
			waitTool = new WaitTool(driver);
		return waitTool;
	}




	public static WebElement waitForElementVisibility(final By by,
			int timeOutInSeconds) {
		
		WebElement element;
		try {

			wdDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

			WebDriverWait wait = new WebDriverWait(wdDriver, timeOutInSeconds);
			element = wait.until(ExpectedConditions
					.visibilityOfElementLocated(by));

			wdDriver.manage().timeouts()
					.implicitlyWait(DEFAULT_WAIT_4_PAGE, TimeUnit.SECONDS);
			return element; // return the element
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static WebElement waitForElementPresent(
			final By by, int timeOutInSeconds) {
		WebElement element;
		try {
			wdDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); // nullify
																			// implicitlyWait()

			WebDriverWait wait = new WebDriverWait(wdDriver, timeOutInSeconds);
			element = wait.until(ExpectedConditions
					.presenceOfElementLocated(by));

			wdDriver.manage().timeouts()
					.implicitlyWait(DEFAULT_WAIT_4_PAGE, TimeUnit.SECONDS); // reset
																			// implicitlyWait
			return element; // return the element
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}




	public static boolean waitForJavaScriptCondition(
			final String javaScript, int timeOutInSeconds) {
		boolean jscondition = false;
		try {
			wdDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); // nullify
																			// implicitlyWait()
			new WebDriverWait(wdDriver, timeOutInSeconds) {
			}.until(new ExpectedCondition<Boolean>() {

				public Boolean apply(WebDriver driverObject) {
					return (Boolean) ((JavascriptExecutor) driverObject)
							.executeScript(javaScript);
				}
			});
			jscondition = (Boolean) ((JavascriptExecutor) wdDriver)
					.executeScript(javaScript);
			wdDriver.manage().timeouts()
					.implicitlyWait(DEFAULT_WAIT_4_PAGE, TimeUnit.SECONDS); // reset
																			// implicitlyWait
			return jscondition;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean waitForJQueryProcessing(
			int timeOutInSeconds) {
		boolean jQcondition = false;
		try {
			wdDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); // nullify
																			// implicitlyWait()
			new WebDriverWait(wdDriver, timeOutInSeconds) {
			}.until(new ExpectedCondition<Boolean>() {

				public Boolean apply(WebDriver driverObject) {
					return (Boolean) ((JavascriptExecutor) driverObject)
							.executeScript("return jQuery.active == 0");
				}
			});
			jQcondition = (Boolean) ((JavascriptExecutor) wdDriver)
					.executeScript("return jQuery.active == 0");
			wdDriver.manage().timeouts()
					.implicitlyWait(DEFAULT_WAIT_4_PAGE, TimeUnit.SECONDS); // reset
																			// implicitlyWait
			return jQcondition;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jQcondition;
	}


	public static void nullifyImplicitWait() {
		wdDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); // nullify
																		// implicitlyWait()
	}

	public static void setImplicitWait( int waitTime_InSeconds) {
		wdDriver.manage().timeouts().implicitlyWait(waitTime_InSeconds, TimeUnit.SECONDS);
	}

	public static void resetImplicitWait() {
		wdDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); // nullify
																		// implicitlyWait()
		wdDriver.manage().timeouts()
				.implicitlyWait(DEFAULT_WAIT_4_PAGE, TimeUnit.SECONDS); // reset
																		// implicitlyWait
	}


	public void resetImplicitWait(
			int newWaittime_InSeconds) {
		wdDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); // nullify
																		// implicitlyWait()
		wdDriver.manage().timeouts()
				.implicitlyWait(newWaittime_InSeconds, TimeUnit.SECONDS); // reset
																			// implicitlyWait
	}
	
	
	public  void waitForPageLoad(){
		Wait<WebDriver> wait = new WebDriverWait(wdDriver, 10);
		wait.until(new Function<WebDriver, Boolean>() {

			public Boolean apply(WebDriver driver) {
				//System.out.println("Current window state : " + String.valueOf(((JavascriptExecutor)driver).executeScript("return document.readyState")));
				return String.valueOf(((JavascriptExecutor)driver).executeScript("return document.readyState")).equals("complete");
			}
		});
	}

	


	public static boolean isTextPresent( By by, String text) {
		try {
			return wdDriver.findElement(by).getText().contains(text);
		} catch (NullPointerException e) {
			return false;
		}
	}


	public static boolean isElementPresent( By by) {
		try {
			wdDriver.findElement(by);// if it does not find the element throw
									// NoSuchElementException, which calls
									// "catch(Exception)" and returns false;
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}


	public static boolean areElementsPresent(By by) {
		try {
			wdDriver.findElements(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}


	public static boolean isElementPresentAndDisplay(By by) {
		try {
			return wdDriver.findElement(by).isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public static WebElement waitForElementToBeClickable(By locator, int timeOutInSeconds) {
		WebElement element;
		try {
			wdDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); // nullify
																			// implicitlyWait()

			WebDriverWait wait = new WebDriverWait(wdDriver, timeOutInSeconds);
			element = wait.until(ExpectedConditions.elementToBeClickable(locator));

			wdDriver.manage().timeouts()
					.implicitlyWait(DEFAULT_WAIT_4_PAGE, TimeUnit.SECONDS); // reset
																			// implicitlyWait
			return element; // return the element
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public WebDriverWait waitForFrameAndSwitch(By by, int timeOut) {
		WebDriverWait wait = new WebDriverWait(wdDriver,timeOut);
		wait.pollingEvery(260, TimeUnit.MILLISECONDS);
		wait.ignoring(java.util.NoSuchElementException.class);

		wait.until(ExpectedConditions.visibilityOfElementLocated(by));

		WebElement element = wdDriver.findElement(by);

		wdDriver.switchTo().frame(element);



		 return wait;
	}





}

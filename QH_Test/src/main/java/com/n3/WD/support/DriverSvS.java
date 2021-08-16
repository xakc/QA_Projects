package com.n3.WD.support;

import java.io.Closeable;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import com.n3.WD.browser.BrowserConfiguration;
import com.n3.WD.browser.CustomChromeDriver;
import com.n3.WD.browser.CustomFirefoxDriver;
import com.n3.WD.settings.IReader;
import com.n3.WD.settings.ReadConfigProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.ui.Wait;


public class DriverSvS implements Closeable {
	
	private WebDriver driver;
	private BrowserConfiguration browserConfiguration;
	
	public BrowserConfiguration getBrowserConfiguration() {
		return browserConfiguration;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public CustomChromeDriver getChromeDriver() {
		return chromeDriver;
	}

	public Browser getBrowser() {
		return browser;
	}

	public Button getButton() {
		return button;
	}

	public Window getWindow() {
		return window;
	}

	public Alert getAlert() {
		return alert;
	}

	private CustomChromeDriver chromeDriver;
	private Browser browser;
	private Button button;
	private Window window;
	private Alert alert;
	private TextBox textBox;
	private Dropdown dropDown;
	private WaitTool waitTool;
	private ScreenShotController screenShotController;
	public ScreenShotController getScreenShotController() {
		return screenShotController;
	}

	private IReader reader;
	
	
	
	public IReader getReader() {
		return reader;
	}
	public WaitTool getWaitTool() {
		return waitTool;
	}
	public Dropdown getDropDown() {
		return dropDown;
	}

	public TextBox getTextBox() {
		return textBox;
	}

	public void launchBrowser(){
		//chromeDriver = new CustomChromeDriver();
		reader = new ReadConfigProperties();
		reader.setBrowserType();
		//driver = chromeDriver.getChromeDriver();
		driver = getBrowserDriver();
		browser = Browser.getInstance(driver);
		button = Button.getInstance(driver);
		window = Window.getInstance(driver);
		alert = Alert.getInstance(driver);
		textBox = TextBox.getInstance(driver);
		dropDown = Dropdown.getInstance(driver);
		waitTool = WaitTool.getInstance(driver);
		screenShotController = ScreenShotController.getInstance(driver);
		driver.manage().timeouts().pageLoadTimeout(reader.getExplicitWait(), TimeUnit.SECONDS); //Page load time out
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		browser.maximize();
	}
	
	private WebDriver getBrowserDriver() {


		switch (reader.getBrowserType()) {
		
		case BrowserType.CHROME:


			browserConfiguration = new CustomChromeDriver();
			return browserConfiguration.getBrowserDriver();
		
		case BrowserType.FIREFOX:


			browserConfiguration = new CustomFirefoxDriver();
			return browserConfiguration.getBrowserDriver();
			
		default:
			throw new RuntimeException("Invalid Browser Type : " + reader.getBrowserType());
		}
	}

	public DriverSvS() {
		launchBrowser();
	}

	@Override
	public void close() throws IOException {
		
	}

}

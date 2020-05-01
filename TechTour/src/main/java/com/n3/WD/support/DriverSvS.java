package com.n3.WD.support;

import java.io.Closeable;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;

import com.n3.WD.browser.BrowserConfiguration;
import com.n3.WD.browser.CustomChromeDriver;
import com.n3.WD.browser.CustomFirefoxDriver;
import com.n3.WD.utils.IReader;
import com.n3.WD.utils.ReadConfigProperties;

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
	private GeneralSupport generalSupport;
	public GeneralSupport getGeneralSupport() {
		return generalSupport;
	}

	private IReader reader;
	
	
	
	public IReader getReader() {
		return reader;
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
		generalSupport = GeneralSupport.getInstance(driver);
		driver.manage().timeouts().pageLoadTimeout(reader.getExplicitWait(), TimeUnit.SECONDS); //Page load time out
		browser.maximize();
	}
	
	private WebDriver getBrowserDriver() {
		/*String browser = System.getProperty("browser.name");
		System.out.println(" ============== > " + browser);
		if(browser.isEmpty())
			browser = "chrome";*/
		switch (reader.getBrowserType()) {
		
		case BrowserType.CHROME:
			/*CustomChromeDriver chromeDriver = new CustomChromeDriver();
			return chromeDriver.getChromeDriver();*/
			browserConfiguration = new CustomChromeDriver();
			return browserConfiguration.getBrowserDriver();
		
		case BrowserType.FIREFOX:
			/*CustomFirefoxDriver firefoxDriver = new CustomFirefoxDriver();
			return firefoxDriver.getFirefoxDriver();*/
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

package com.n3.WD.browser.interfacewebdrive;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverInteface {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\AUTOMATION\\BROWSERS\\ChromeDriver\\versions\\81\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver","D:\\AUTOMATION\\BROWSERS\\GeckoDriver\\versions\\26\\geckodriver.exe");

		
		WebDriver driver = new ChromeDriver();
		System.out.println(driver.toString());
		driver = new FirefoxDriver();
		System.out.println(driver.toString());

	}
}

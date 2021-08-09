package com.n3qa.common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.SessionId;

public class CustomWebDriverManager {
    public enum CustomWebDriverManagerEnum {
        INSTANCE;
        private static String browser = System.getProperty("browser");
        private WebDriver driver = setupBrowser();

        private WebDriver setupBrowser() {
                WebDriverManager.chromedriver().setup();
                WebDriver chromeDriver = new ChromeDriver();
                chromeDriver.manage().window().maximize();
                return  chromeDriver;
        } ;

        public void quitDriver() {
            if (driver != null) {
                driver.quit();
            }
        }

        public WebDriver getDriver() {
        SessionId session = ((ChromeDriver)driver).getSessionId();

        if(session==null)
        {
            driver = setupBrowser();
        }
        return driver;
    }
  }
}

package com.n3qa.common;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class utils {
    public static final Logger LOG = LogManager.getRootLogger();


    public static WebDriver getWebDriver() {
        LOG.info("Initializing WebDriver");
        return CustomWebDriverManager.CustomWebDriverManagerEnum.INSTANCE.getDriver();
    }

    public static void tearDownWebDriver() {
        LOG.info("Quitting WebDriver");
        CustomWebDriverManager.CustomWebDriverManagerEnum.INSTANCE.quitDriver();
    }



}

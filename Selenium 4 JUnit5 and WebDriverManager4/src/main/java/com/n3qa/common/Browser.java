package com.n3qa.common;
import com.n3qa.common.utils;


import org.openqa.selenium.WebDriver;

public class Browser {
    final WebDriver driver;

    public Browser() {
        this.driver =  utils.getWebDriver();
    }
    public static void loadBrowser() {
        utils.getWebDriver().get("/");
    }
    public static void open(String url) {
         utils.getWebDriver().get(url);
    }




}

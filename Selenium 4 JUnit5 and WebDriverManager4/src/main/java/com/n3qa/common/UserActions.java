package com.n3qa.common;
import com.n3qa.common.utils;

import org.openqa.selenium.WebDriver;

public class UserActions {

    final WebDriver driver;

    public UserActions() {
        this.driver = utils.getWebDriver();
    }


}

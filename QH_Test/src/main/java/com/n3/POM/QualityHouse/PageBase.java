package com.n3.POM.QualityHouse;

import java.util.concurrent.TimeUnit;

import com.n3.POM.QualityHouse.factory.CustomFactory;
import com.n3.POM.QualityHouse.factory.PageName;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PageBase {
    @FindBy(how = How.CSS, using = "div.body:nth-child(3) div.header-body div.header-container.container div.header-row div.header-column:nth-child(2) div.header-row:nth-child(2) div.header-nav.clearfix div.header-nav-main.header-nav-main-effect-1.header-nav-main-sub-effect-1.collapse nav:nth-child(1) ul.nav.nav-pills li.dropdown:nth-child(6) > a.dropdown-toggle")
    public WebElement navBar_contactUs;

    public WebDriver driver;
    public WebDriverWait wait;
    public JavascriptExecutor js = (JavascriptExecutor) driver;

    public PageBase(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebDriverWait getWait() {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.pollingEvery(250, TimeUnit.MILLISECONDS);
        wait.ignoring(NoSuchElementException.class);
        return wait;
    }

    public PageBase navigateTo(PageName name, WebDriver driver, WebElement element) {
        WebDriverWait wait = getWait();
        wait.until(ExpectedConditions.visibilityOf(element));
        return CustomFactory.getInstance(name, driver);
    }

}

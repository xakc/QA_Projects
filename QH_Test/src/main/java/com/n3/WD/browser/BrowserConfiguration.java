package com.n3.WD.browser;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;

public interface BrowserConfiguration {
	
	public WebDriver getBrowserDriver();
	public boolean isGridSetup();
	public URL getHubUrl() throws MalformedURLException;

}

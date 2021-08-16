package com.n3.WD.settings;

public interface IReader {
	

	public String getApplicationUrl(); // this will return the application url from properties file
	public String getUserName();
	public String getPassword();
	public int getExplicitWait();
	public String getBrowserType();
	public void setBrowserType();

}

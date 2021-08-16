package com.n3.POM.QualityHouse.factory;


import com.n3.POM.QualityHouse.*;
import org.openqa.selenium.WebDriver;



public class CustomFactory {
	

	
	public static PageBase getInstance(PageName name, WebDriver driver) {
		
		switch (name) {
			case HomePage:
				return new HomePageClass(driver);
			case ContactUsPage:
				return new ContactUsClass(driver);


		default:
			throw new RuntimeException("Invalid Page Name");
		}
		
	}

}

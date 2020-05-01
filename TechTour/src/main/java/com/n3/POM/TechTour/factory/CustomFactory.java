package com.n3.POM.TechTour.factory;


import com.n3.POM.TechTour.*;
import org.openqa.selenium.WebDriver;



public class CustomFactory {
	

	
	public static PageBase getInstance(PageName name, WebDriver driver) {
		
		switch (name) {
			case HomePage:
				return new HomePageClass(driver);
			case LoginPage:
				return new LoginPageClass(driver);
			case RegistrationPage:
				return new RegistrationPageClass(driver);


		default:
			throw new RuntimeException("Invalid Page Name");
		}
		
	}

}

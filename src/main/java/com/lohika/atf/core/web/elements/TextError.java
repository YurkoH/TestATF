package com.lohika.atf.core.web.elements;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.lohika.atf.core.web.WebComponent;

public class TextError extends WebComponent<TextError> {

	public TextError(WebDriver driver, By findByMehtod) {
		super(driver, findByMehtod);
	}
	
	public String getAttribute(String string) {
	 return	getWebElement().getAttribute(string);
	
	}

	
}

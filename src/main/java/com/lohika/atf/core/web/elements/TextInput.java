package com.lohika.atf.core.web.elements;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.lohika.atf.core.web.WebComponent;

public class TextInput extends WebComponent<TextInput> {

	public TextInput(WebDriver driver, By findByMehtod) {
		super(driver, findByMehtod);
	}
	public TextInput inputText(String text){
		getWebElement().sendKeys(text);
		return this;
	}
	
	public TextInput  clearText(){
		getWebElement().clear();
		return this;
	}
}

package com.lohika.atf.core.web.elements;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.lohika.atf.core.web.WebComponent;

public class GroupElements extends WebComponent<GroupElements> {

	public GroupElements(WebDriver driver, By findByMehtod) {
		super(driver, findByMehtod);
	}
	public GroupElements groupElement(By findByMehtod){
		getWebElement().findElement(findByMethod);
		return this;
	}
	
}

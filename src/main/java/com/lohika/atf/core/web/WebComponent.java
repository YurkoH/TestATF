package com.lohika.atf.core.web;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class WebComponent<T extends WebComponent<T>> extends Component<T> {

	protected final By findByMethod;
	
	public WebComponent(WebDriver driver,By findByMehtod) {		
		super(driver);
		this.findByMethod =findByMehtod;
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean isAvailable(){
		try{
		return getWebElement()!=null;
	}catch (NoSuchElementException e){
	return false;	
		}
	}
	
	public void click()
	{
		getWebElement().click();
	}
	
	public String getText()
	{
		return getWebElement().getText();
		
	}
	
	protected WebElement getWebElement(){
		return driver.findElement(findByMethod);
	}

}

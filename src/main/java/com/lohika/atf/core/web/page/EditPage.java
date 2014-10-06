package com.lohika.atf.core.web.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.lohika.atf.core.web.WebPage;
import com.lohika.atf.core.web.elements.Button;
import com.lohika.atf.core.web.elements.TextInput;

public class EditPage extends WebPage<MainPage>{

public EditPage(WebDriver driver) {
		super(driver);
		load();

	}

	@Override
	public boolean isAvailable() {
		return  editProductName().isAvailable() &&
				editQuantity().isAvailable() &&
				editPrice().isAvailable() &&
				editAccept().isAvailable();
	}
	
	private TextInput editProductName(){
		return new TextInput(driver, By.xpath("//div[contains(@class,'product edit')]/input[contains(@class,'edit')]"));
	}
	private TextInput editQuantity(){
		return new TextInput(driver, By.xpath("//div[contains(@class,'quantity edit')]/input[contains(@class,'edit')]"));
	}
		
	private TextInput editPrice(){
		return new TextInput(driver, By.xpath("//div[contains(@class,'price edit')]/input[contains(@class,'edit')]"));
	}

	private Button editAccept(){
		return new Button(driver, By.xpath("//div[contains(@class,'table-row')]/div[contains(@class,'tr-cell')]/img[contains(@title,'Accept')]"));
	}
	
	private Button editCancel(){
		return new Button(driver, By.xpath("//div[contains(@class,'table-row')]//div[contains(@class,'tr-cell')]/img[contains(@title,'Cancel')]"));
	}
	
	
	public void editProduct(String product, String quantity, String price)
	{	
		editProductName().clearText();
		editProductName().inputText(product);
		
		editQuantity().clearText();
		editQuantity().inputText(quantity);
		
		editPrice().clearText();
		editPrice().inputText(price);
		
		editAccept().click();
	}
	
	
	public void editProduct(String product, Double quantity, Double price)
	{	
		editProductName().clearText();
		editProductName().inputText(product);
		
		editQuantity().clearText();
		editQuantity().inputText(Double.toString(quantity));
		
		editPrice().clearText();
		editPrice().inputText(Double.toString(price));
		
		editAccept().click();
	}
	
	public void editProduct(String product, Integer quantity, Integer price)
	{	
		editProductName().clearText();
		editProductName().inputText(product);
		
		editQuantity().clearText();
		editQuantity().inputText(Integer.toString(quantity));
		
		editPrice().clearText();
		editPrice().inputText(Integer.toString(price));
		
		editAccept().click();
	}
	public void editCancelProduct()
	{	
		editCancel().click();

	}
	
	public void editCancelProduct(String product, Integer quantity, Integer price)
	
	{	
		editProductName().clearText();
		editProductName().inputText(product);
		
		editQuantity().clearText();
		editQuantity().inputText(Integer.toString(quantity));
		
		editPrice().clearText();
		editPrice().inputText(Integer.toString(price));
		editCancel().click();

	}
		

	@Override
	public MainPage load() {
		// TODO Auto-generated method stub
		return null;
	}


}


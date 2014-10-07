package com.lohika.atf.core.web.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.lohika.atf.core.web.WebPage;
import com.lohika.atf.core.web.elements.Button;
import com.lohika.atf.core.web.elements.TextError;
import com.lohika.atf.core.web.elements.TextInput;

public class MainPage extends WebPage<MainPage> {

	private static final String Main_Page_URL ="http://10.5.254.6:8080/";
	public MainPage(WebDriver driver) {
		super(driver);
		load();
	}

	@Override
	public MainPage load() {
		driver.get(Main_Page_URL);
		return this;
	}

	@Override
	public boolean isAvailable() {
		return getProductName().isAvailable() &&
				getQuantity().isAvailable() &&
				getPrice().isAvailable() &&
				getAddProduct().isAvailable();
	}
	
	private TextInput getProductName(){
		return new TextInput(driver, By.id("product-name"));
	}
	private TextInput getQuantity(){
		return new TextInput(driver, By.id("quantity"));
	}
		
	private TextInput getPrice(){
		return new TextInput(driver, By.id("price"));
	}
		
	private Button getAddProduct(){
		return new Button(driver, By.id("add-button"));
	}
	
	
	// Elements for test verification
	public String getAddProductError()
	{
		return new TextError(driver, By.xpath("//input[contains(@id,'product')]")).getAttribute("class");
	}
	
	public String getAddQuantiryError()
	{
		return new TextError(driver, By.xpath("//input[contains(@id,'quantity')]")).getAttribute("class");
	}
	
	public String getAddPriceError()
	{
		return new TextError(driver, By.xpath("//input[contains(@id,'price')]")).getAttribute("class");
	}
	
	
	
	/*
	private GroupElements getGroupElements(){
		return new GroupElements(driver, By.xpath("//div[contains(@class,'table-row')][contains(.,'test')]"));
	}
	//Get string product by name
	//div[contains(@class,'table-row')][contains(.,'test')]
	/*private WebElement getProductNameList(String ProductName)
	{
		
	}
	*/

	
	// Should be added verification there is no such row
	
	private Button getDeleteProductByRow(int i){
		return new Button(driver, By.xpath("//div[@class='table-row']["+i+"]//div[contains(@class,'tr-cell actions')]/img[2]"));
	}
	private Button getDeleteProductByName(String str){
		return new Button(driver, By.xpath("//div[contains(@class,'table-row')][contains(.,'"+str+"')]/div[contains(@class,'tr-cell actions')]/img[2]"));
	}
	
	private Button getEditProductByRow(int i){
		return new Button(driver, By.xpath("//div[@class='table-row']["+i+"]/div[contains(@class,'tr-cell actions')]/img[1]"));
	}
	private Button getEditProductByName(String str){
		return new Button(driver, By.xpath("//div[contains(@class,'table-row')][contains(.,'"+str+"')]/div[contains(@class,'tr-cell actions')]/img[1]"));
	}

	public void addProduct(String product, String quantity, String price)
	{	
		getProductName().clearText();
		getProductName().inputText(product);
		
		getQuantity().clearText();
		getQuantity().inputText(quantity);
		
		getPrice().clearText();
		getPrice().inputText(price);
		getAddProduct().click();		
	}
	
	public void addProduct(String product, int quantity, int price)
	{	getProductName().clearText();
		getProductName().inputText(product);
		
		getQuantity().clearText();
		getQuantity().inputText(Integer.toString(quantity));
		
		getPrice().clearText();
		getPrice().inputText(Integer.toString(price));
		
		getAddProduct().click();
		
	}

	
	public void addProduct(String product, double quantity, double price)
	{	getProductName().clearText();
		getProductName().inputText(product);
		
		getQuantity().clearText();
		getQuantity().inputText(Double.toString(quantity));
		
		getPrice().clearText();
		getPrice().inputText(Double.toString(price));
		
		getAddProduct().click();

		
	}
	public void deleteProductByRow(int i)
	{
		getDeleteProductByRow(i).click();
	}
	public void deleteProductByName(String str)
	{
		getDeleteProductByName(str).click();
	}
	
	public void EditProductByRow(int row)
	{	
		getEditProductByRow(row).click();

	}
	
	public void EditProductByName(String str)
	{	
		getEditProductByName(str).click();

	}
}


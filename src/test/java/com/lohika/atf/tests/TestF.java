package com.lohika.atf.tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.lohika.atf.core.Base;
import com.lohika.atf.core.web.page.EditPage;
import com.lohika.atf.core.web.page.MainPage;


public class TestF extends Base {
	
	//Input Data
	
	///Product1 data
	String aProduct1 ="aProduc1";
	int quantProd1 =4;
	int priceProd1 =5;
	WebElement el1;
	
	String eProduct1 ="eProduc1";
	
	///Product2 data
	
	String aProduct2 ="aProduc2";
	double quantProd2 =4.5;
	double priceProd2 =5.3;
	
	// Edit Product
	String eProduct2 ="eProduc2";
	int quantProdE =44;
	int priceProdE =55;
	
	WebElement editel1;
	
	
	MainPage main;
	EditPage edit;
	WebElement el2;
	
	
	// Test: Successful 'Addition of the Product
	// Add 2 products
	// Check Product names
	
	@Test(description="Add Product")

	public void addProducts(){
		
		main = new MainPage(driver);
		edit = new EditPage(driver);
		
	//	el1.findElement(By.xpath("//div[contains(@class,'product')]"));
		//driver.get("http://10.5.254.10:8080/");
		
	/*	
		for (int i =0; i<5; i++)
		
		{
	main.addProduct("prod"+i, 1+i, 2+i);
	try{
		Thread.sleep(1000);
	}
	catch(Exception ex){}
		}
		*/
	//	main.deleteProduct(5);
		
		main.addProduct(aProduct1, quantProd1, priceProd1);
		el1 = driver.findElement(By.xpath("//div[last()]/div[contains(@class,'product')]"));
		//el1=el1.findElement(By.xpath("//div[contains(@class,'product')]"));
		Assert.assertEquals(aProduct1,el1.getText());
		
		main.addProduct(aProduct2, quantProd2, priceProd2);
		el2 = driver.findElement(By.xpath("//div[last()]/div[contains(@class,'product')]"));
		Assert.assertEquals(aProduct2,el2.getText());
		try{
			Thread.sleep(3000);
		}
		catch(Exception ex){}		
		
	}
	
	// Test: Proper 'Total price' calculation per each Product and general for all Products
		// Check price of 2 products
		// Check total price of all units
	
	@Test(description="Check Calculations of tota price")
	public void calcPrice()
	
	{
		
		WebElement elTotal1=driver.findElement(By.xpath("//div[1]/div[@class='tr-cell total']"));
		Assert.assertEquals(quantProd1*priceProd1,Integer.parseInt(elTotal1.getText()));
		
		WebElement elTotal2=driver.findElement(By.xpath("//div[2]/div[@class='tr-cell total']"));
		Assert.assertEquals(quantProd2*priceProd2,Double.parseDouble(elTotal2.getText()));
		
		
		WebElement allTotal=driver.findElement(By.id(("total-price")));
		Double allTot =(quantProd1*priceProd1)+(quantProd2*priceProd2);
		Assert.assertEquals(allTot,Double.parseDouble(allTotal.getText()));
	}
	
	// Test:Successful 'Deletion of the product from the Invoice Table'
			// Delete product by name
	
	@Test(description="Delete product by name")
	public void deleteProducts(){
		main.deleteProductByName(aProduct2);
	//	Assert.assertFalse(aProduct2.contains(el2.getText()), "aProduct2 is removed");	
	}
	
	@Test(description="Correct 'Edit mode' of a single Product row")
	public void editProductSingleRow(){
		

		
	}
	@Test(description="Successful 'Edit of the product in the Invoice Table'")
	public void editProductInvoice(){
		main.EditProductByRow(1);
		edit.editProduct(eProduct1,priceProdE,quantProdE);
		editel1 = driver.findElement(By.xpath("//div[1]/div[contains(@class,'product')]"));
		Assert.assertEquals(eProduct1, editel1.getText());
		
	}
	
	@Test(description="Successful 'Cancel Edit Changes of the product in the Invoice Table'")
	public void editCancelProduct(){
		main.EditProductByName(aProduct1);
		edit.editCancelProduct(aProduct2, 343534534, 435);
		editel1 = driver.findElement(By.xpath("//div[1]/div[contains(@class,'product')]"));
		
		Assert.assertEquals(aProduct1, editel1.getText());
		
	}
	

	@Test(description="Validation of Add Product Panel fields")
	// Product Name' > 3 characters
	// negative numbers
	// Strings
	// No values in fields
	public void validationAddProductFields(){
		main.addProduct("aP", 1, 2);
		WebElement prod=driver.findElement(By.xpath("//input[contains(@id,'product')]"));
		Assert.assertEquals("input-field error",prod.getAttribute("class"));
	}
	
	@Test(description="Validation of 'Edit mode' fields ")
	// Product Name' > 3 characters
	// negative numbers
	// Strings
	// No values in fields
	public void validationEditProductFields(){
		main.EditProductByRow(1);
		edit.editProduct("aP", 1, 2);
		WebElement prod=driver.findElement(By.xpath("//div[contains(@class,'product edit')]/input"));
		Assert.assertEquals("edit-input wide-edit error",prod.getAttribute("class"));
		try{
			Thread.sleep(3000);
		}
		catch(Exception ex){}
	}
}

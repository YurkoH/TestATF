package com.lohika.atf.core;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverMaster {
	static WebDriver driver;
	private DriverMaster () {
		
	}
	
	public static WebDriver getDriver(String driverKey) {
		BrowserTypes browser = BrowserTypes.get(driverKey);
		
		switch (browser){
			case FIREFOX:
				driver =new FirefoxDriver();
				break;
			case CHROME:
				System.setProperty("webdriver.chrome.driver", "E:\\automation\\chromedriver.exe");
				driver =new ChromeDriver();
				break;
			default:
				driver =new FirefoxDriver();
				break;
		}
		return driver;
	}
		
	}
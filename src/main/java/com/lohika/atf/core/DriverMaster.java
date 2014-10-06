package com.lohika.atf.core;

import javax.print.DocFlavor.STRING;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

public class DriverMaster {
	
	private DriverMaster () {}
	
	public static WebDriver getDriver(String driverKey) {
		BrowserTypes browser = BrowserTypes.get(driverKey);
		WebDriver driver;
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

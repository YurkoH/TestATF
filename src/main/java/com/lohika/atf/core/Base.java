package com.lohika.atf.core;
import static com.lohika.atf.core.DriverMaster.getDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public abstract class Base {
	
	protected WebDriver driver;
	
	@BeforeSuite(alwaysRun = true)
	@Parameters({"browser"})
	
	public void setup(@Optional("firefox") String browser)
	{
		driver =getDriver(browser);
/*		if(browser =="firefox")
		{
		driver =new FirefoxDriver();
		}
		else if (browser =="chrome")
		{
			driver =new ChromeDriver();
			}
		else
			driver =new FirefoxDriver();
	*/		
	}
	
	@AfterSuite(alwaysRun = true)
	public void tearDown()
	{
		driver.quit();
	}

}

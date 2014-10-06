package com.lohika.atf.core.web;

import org.openqa.selenium.WebDriver;

public abstract class WebPage<T extends WebPage<T>> extends Component<T>
{

	public WebPage(WebDriver driver){
		super(driver);
		
	}

	public abstract T load();
	
	public T loadAndWaitUntillAvailable()
	{
		load();
		return waitUntilAvailable();
				
	}
}

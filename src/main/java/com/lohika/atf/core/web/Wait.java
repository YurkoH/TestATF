package com.lohika.atf.core.web;

import org.openqa.selenium.TimeoutException;

public class Wait <T extends Component<T>> {
	// set timeout default timeout wait for component 20sec
	// Set default retry 50msec
	private static final int DEFAULT_TIMEOUT = 20000;
	private static final int DEFAULT_RETRY = 500;
	private T component;
	
	public Wait(){
	
		
	}
	public Wait<T> forComponent(T  component)
	{
		this.component =component;
		return this;
	}
	
	public T toBeAvailable()
	{
		int timePassed = 0;
		while (timePassed <DEFAULT_TIMEOUT)
		{
			if (this.component.isAvailable())
				{
					return this.component;
				}
		timePassed = timePassed +delay();
		
		}
		if(!this.component.isAvailable())
		{
			throw new TimeoutException("Timeout " +DEFAULT_TIMEOUT+"ms. waiting"+this.component.getClass().getSimpleName()+ " for a component ");
		}
		return this.component;
	}
	
	//wait with retries while component appeared
	private int delay()
	 {
		try{
		Thread.sleep(DEFAULT_RETRY);
		return DEFAULT_RETRY;
		} 
		catch (InterruptedException e) 
		{
			throw new RuntimeException(e);
		}
	}

}

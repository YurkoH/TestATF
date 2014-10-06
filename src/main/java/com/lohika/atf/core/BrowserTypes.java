package com.lohika.atf.core;

import java.util.HashMap;
import java.util.Map;

public enum BrowserTypes {
	FIREFOX("firefox"),
	CHROME("chrome");

	private String browserKey;
	private static Map<String, BrowserTypes> browserMap= new HashMap<String,BrowserTypes>();
	static
	{
		for(BrowserTypes bt: BrowserTypes.values())
		{
			browserMap.put(bt.key(), bt);	
			}
	}
	private BrowserTypes(String key)
	{
		browserKey=key;
	}
	
	private String key()
	{
		return this.browserKey;
	}
	
	public static BrowserTypes get(String key) {
		if(browserMap.containsKey(key))
		{
			return browserMap.get(key);
		}
		return FIREFOX;
		
	}
	
}

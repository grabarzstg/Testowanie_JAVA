package com.example.webguidemo.pages;

import java.util.concurrent.TimeUnit;

import org.jbehave.web.selenium.WebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;

public class Find extends WebDriverPage{
	
	public Find(WebDriverProvider driverProvider) {
		super(driverProvider);		
	}

	public void open() {
		get("https://www.youtube.com/results?search_query=Milosna+kontrabanda");
		manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

}

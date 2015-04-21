package com.example.webguidemo.pages;

import java.util.concurrent.TimeUnit;

import org.jbehave.web.selenium.WebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;

public class Video extends WebDriverPage{
	
	public Video(WebDriverProvider driverProvider) {
		super(driverProvider);		
	}

	public void open() {
		get("https://www.youtube.com/watch?v=gfk-yh79yC8");
		manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

}

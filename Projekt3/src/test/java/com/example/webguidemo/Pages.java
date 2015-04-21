package com.example.webguidemo;

import org.jbehave.web.selenium.WebDriverProvider;

import com.example.webguidemo.pages.Find;
import com.example.webguidemo.pages.Home;
import com.example.webguidemo.pages.Video;

public class Pages {

	private WebDriverProvider driverProvider;
	
	//Pages
	private Home home;
	private Find find;
	private Video video;
	// ...

	public Pages(WebDriverProvider driverProvider) {
		super();
		this.driverProvider = driverProvider;
	}

	public Home home() {
		if (home == null) {
			home = new Home(driverProvider);
		}
		return home;
	}
	
	public Find find(){
		if (find == null) {
			find = new Find(driverProvider);
		}
		return find;
	}
	
	public Video video(){
		if (video == null) {
			video = new Video(driverProvider);
		}
		return video;
	}
}

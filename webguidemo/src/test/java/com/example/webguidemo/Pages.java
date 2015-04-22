package com.example.webguidemo;

import org.jbehave.web.selenium.WebDriverProvider;

import com.example.webguidemo.pages.Sport;
import com.example.webguidemo.pages.Home;
import com.example.webguidemo.pages.Now;
import com.example.webguidemo.pages.Search;

public class Pages {

	private WebDriverProvider driverProvider;
	
	//Pages
	private Home home;
	private Sport sport;
	private Now now;
	private Search search;
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
	
	public Sport sport(){
		if (sport == null) {
			sport = new Sport(driverProvider);
		}
		return sport;
	}
	
	public Now now(){
		if (now == null) {
			now = new Now(driverProvider);
		}
		return now;
	}
	
	public Search search(){
		if (search == null) {
			search = new Search(driverProvider);
		}
		return search;
	}	
}

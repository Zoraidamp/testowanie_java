package com.example.webguidemo.pages;

import java.util.concurrent.TimeUnit;

import org.jbehave.web.selenium.WebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;

public class Search extends WebDriverPage{
	
	public Search(WebDriverProvider driverProvider) {
		super(driverProvider);		
	}

	public void open(String find) {
		get("http://www.teleman.pl/search?q="+find);
		manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

}
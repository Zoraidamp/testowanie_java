package com.example.webguidemo;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.By;

import static org.junit.Assert.*;

public class TelemanSteps {
	
	private final Pages pages;

	public TelemanSteps(Pages pages) {
		this.pages = pages;
	}
	
	@Given("user is on Home page")
    public void userIsOnHomePage(){        
        pages.home().open();        
    }
 
    @When("user opens Sport link")
    public void userClicksOnSportLink(){        
        pages.home().findElement(By.linkText("SPORT")).click();
    }
    
    @When("user opens Now link")
    public void userClicksOnNowLink(){        
        pages.home().findElement(By.linkText("TERAZ W TV")).click();
    }
 
    @Then("Sport page is shown")
    public void sportPageIsShown(){
       assertEquals("Sport w Programie TV - Program telewizyjny Teleman.pl", pages.sport().getTitle());
    }	
    
    @Then("Now page is shown")
    public void nowPageIsShown(){
       assertEquals("Teraz i za Chwilę w Programie TV - Aktualny Program TV - Program telewizyjny Teleman.pl", pages.now().getTitle());
    }
    
    @Then("Search page is shown")
    public void searchPageIsShown(){
       assertEquals("Teraz i za Chwilę w Programie TV - Aktualny Program TV - Program telewizyjny Teleman.pl", pages.now().getTitle());
    }

}

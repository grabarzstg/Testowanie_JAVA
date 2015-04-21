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
 
    @When("user type request in search")
    public void userClicksOnSportLink(){        
        pages.home().findElement(By.id("masthead-search-term")).sendKeys("Milosna kontrabanda");
        pages.home().findElement(By.id("masthead-search-term")).submit();
    }
 
    @Then("Find page is shown")
    public void sportPageIsShown(){
       assertEquals("Milosna kontrabanda - YouTube", pages.find().getTitle());
    }	

    
	@Given("user is on Find page")
    public void userIsOnFindPage(){        
        pages.find().open();        
    }
 
    @When("user opens first result")
    public void userClicksOnFirstResult() throws InterruptedException{        
        pages.find().findElement(By.partialLinkText("[OFFICIAL AUDIO]")).click();
    }
 
    @Then("Video page is shown")
    public void videoPageIsShown(){
       assertEquals("▶ STRACHY NA LACHY - Miłosna kontrabanda, a Praga tonie [OFFICIAL AUDIO] - YouTube", pages.video().getTitle());
    }	
}

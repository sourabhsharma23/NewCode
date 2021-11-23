package com.qait.tests;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qait.automation.TestSessionInitiator;

public class BookAFlightTest extends TestSessionInitiator{

	@Test(priority=0)
	public void launchApplication() throws InterruptedException {
		bookaFlight.launchApplicationUrl();
		Assert.assertEquals(bookaFlight.getPageTitle(), "MakeMyTrip - #1 Travel Website 50% OFF on Hotels, Flights & Holiday");
	}
	
	@Test(priority=1)
	public void SearchFlight() throws InterruptedException {
		bookaFlight.navigateToBasicCourse();
		Assert.assertEquals(bookaFlight.getPageTitle(), "MakeMyTrip");
	}
	
	@Test(priority=2)
	public void bookFlight() throws InterruptedException {
		bookaFlight.searchFlight();
	}
	
	
}

package com.qait.keywords;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.qait.automation.getpageobjects.GetPage;
import com.qait.automation.utils.YamlReader;

public class BookAFlightAction extends GetPage{

	public BookAFlightAction(WebDriver driver) {
		super(driver, "FlightSpecs");
		// TODO Auto-generated constructor stub
	}

	public void launchApplicationUrl() throws InterruptedException {
		driver.get(YamlReader.getData("app_url"));
		Thread.sleep(2000);
	}
	
	public void navigateToBasicCourse() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		Thread.sleep(2000);
		element("link_search").click();
		Thread.sleep(2000);
	}
	
	public void searchFlight() throws InterruptedException {
		element("from_city").click();
		element("enter_city").sendKeys(YamlReader.getData("fromCity"));
		element("select_city").click();
		element("enter_city").sendKeys(YamlReader.getData("toCity"));
		element("select_city").click();
		element("select_depart_date").click();
		element("return_date").click();
		element("select_return_date").click();
		element("search_button").click();
		Thread.sleep(5000);
		element("bookNow_button").click();

	}
	
}

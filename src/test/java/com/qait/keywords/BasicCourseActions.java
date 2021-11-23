package com.qait.keywords;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.qait.automation.TestSessionInitiator;
import com.qait.automation.getpageobjects.GetPage;
import com.qait.automation.utils.YamlReader;

public class BasicCourseActions extends GetPage{

	 public BasicCourseActions(WebDriver driver) {
	        super(driver, "BasicCourse");
	    }

	public void launchApplicationUrl() {
		driver.get(YamlReader.getData("app_url"));
	}
	
	public void navigateToBasicCourse() {
		element("link_basicCourse").click();
	}
	
	public String getGridHeader() {
		return element("label_grid").getText();
	}

	
}

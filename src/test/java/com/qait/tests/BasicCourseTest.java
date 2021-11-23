package com.qait.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import com.qait.automation.TestSessionInitiator;

import static com.qait.automation.TestSessionInitiator.test;


public class BasicCourseTest extends TestSessionInitiator{

	@Test(priority=1)
	public void launchApplication() throws Throwable {
		basicCourse.launchApplicationUrl();
		Assert.assertEquals(basicCourse.getPageTitle(), "Welcome - T.A.T.O.C");
	}
	
	@Test(priority=2)
	public void navigateToBasicCourse() throws Throwable {
		basicCourse.navigateToBasicCourse();
		Assert.assertEquals(basicCourse.getGridHeader(), "Grid Gate");
	}

	}

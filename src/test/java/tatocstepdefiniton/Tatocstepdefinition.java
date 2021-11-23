package tatocstepdefiniton;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Tatocstepdefinition {
	
	//initiate webdriver
	WebDriver driver;
	
	
	// Scenario 1
	
	
	@Given("^User is already on basic course page$")
	public void user_already_on_basiccourse_page() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vaishali\\Desktop\\chromedriver.exe\\");
		driver = new ChromeDriver();
		driver.get(" http://10.0.1.86/tatoc");	
	}
	
	@When("^Title of first page is Tatoc$")
	public void title_of_firstpageis_tatoc() {
		String title = driver.getTitle();
		Assert.assertEquals("Welcome - T.A.T.O.C",title);
	}
	
	@Then("^click on basic course$")
	public void click_on_basic_course()
	{
		driver.findElement(By.linkText("Basic Course")).click();
	}
	
	@Then("^user is on Grid Gate page$")
	public void user_is_on_grid_page()
	{
		String result = driver.findElement(By.tagName("h1")).getText();
		Assert.assertEquals("Grid Gate",result);
		 driver.quit();
	}
	
	// Scenario 2
	
	@Given("^User is already on grid gate page$")
	public void user_is_on_grid_page1()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vaishali\\Desktop\\chromedriver.exe\\");
		driver = new ChromeDriver();
		driver.get("http://10.0.1.86/tatoc/basic/grid/gate");
		
	}
	
	@When("^Title of page is Grid Gate$")
	public void title_of_page_grid_gate()
	{
		String title = driver.getTitle();
		Assert.assertEquals("Grid Gate - Basic Course - T.A.T.O.C",title);
	}
	
	@Then("^Click on green box$")
	public void click_on_green_box()
	{
		driver.findElement(By.className("greenbox")).click();
	}
	
	@Then("^user is on Frame Dungeon page$")
	public void user_is_on_frame_dungeon_page()
	{
		String result = driver.findElement(By.tagName("h1")).getText();
		Assert.assertEquals("Frame Dungeon",result);
		 driver.quit();
	}
	
	// Scenario 3
	
	@Given("^User is already on Frame Dungeon page$")
	public void user_is_on_frame_dungeon_page1()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vaishali\\Desktop\\chromedriver.exe\\");
		driver = new ChromeDriver();
		driver.get("http://10.0.1.86/tatoc/basic/frame/dungeon");
	}
	
	@When("^Title of page is Frame Dungeon$")
	public void Title_of_page_frame_dungeon1()
	{
		String title = driver.getTitle();
		Assert.assertEquals("Frame Dungeon - Basic Course - T.A.T.O.C",title);
	}
	
	@Then("^Click on repaint Repaint box 2 then proceed$")
	public void repaint_box_2 () throws InterruptedException
	{
		driver.switchTo().frame("main");
		String elementval = driver.findElement(By.id("answer")).getAttribute("class");
		driver.switchTo().frame("child");
		String elementval1 = driver.findElement(By.id("answer")).getAttribute("class");
		System.out.println(elementval);
		System.out.println(elementval1);
		while(!elementval.equals(elementval1))
		{System.out.println(elementval.equals(elementval1));
			driver.switchTo().defaultContent();
			driver.switchTo().frame("main");
			driver.findElement(By.cssSelector("a[onclick='reloadChildFrame();']")).click();
			Thread.sleep(1000);
			driver.switchTo().frame("child");
			elementval1 = driver.findElement(By.id("answer")).getAttribute("class");
			System.out.println(elementval1);
		}
		
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("main");
		driver.findElement(By.cssSelector("a[onclick='gonext();']")).click();
		driver.switchTo().defaultContent();
	}
	
	@Then("^User is on Drag Around page$")
	public void user_is_on_drag_around_page()
	{
		String result = driver.findElement(By.tagName("h1")).getText();
		Assert.assertEquals("Drag Around",result);
		 driver.quit();
	}
	
	//Scenario 4
	
	@Given("^User is already on drag and drop box$")
	public void user_is_on_draganddrop_page()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vaishali\\Desktop\\chromedriver.exe\\");
		driver = new ChromeDriver();
		driver.get("http://10.0.1.86/tatoc/basic/drag");
	}
	
	@When("^Title of the page is Drag Around$")
	public void title_of_page_is_drag_around()
	{
		String title = driver.getTitle();
		Assert.assertEquals("Drag - Basic Course - T.A.T.O.C",title);
	}
	
	@Then("^Drag the box and release in drop box$")
	public void drag_and_drop_box()
	{
		Actions action = new Actions(driver);
		action.clickAndHold(driver.findElement(By.id("dragbox")))
		.moveToElement(driver.findElement(By.id("dropbox")))
		.release()
		.build()
		.perform();
	}
	
	@Then("^Click on proceed$")
	public void click_on_proceed()
	{
		driver.findElement(By.linkText("Proceed")).click();
	}
	
	@Then("^User is on Popup Windows$")
	public void user_is_on_popup_window()
	{
		String result = driver.findElement(By.tagName("h1")).getText();
		Assert.assertEquals("Popup Windows",result);
		 driver.quit();
	}
	
	//Scenario 5
	
	@Given("^User is already on Popup window page$")
	public void user_is_already_on_popup_widow()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vaishali\\Desktop\\chromedriver.exe\\");
		driver = new ChromeDriver();
		driver.get("http://10.0.1.86/tatoc/basic/windows");
	}
	
	@When("^Title of the page is Popup Window$")
	public void title_of_page_is_popupwindow()
	{
		String title = driver.getTitle();
		Assert.assertEquals("Windows - Basic Course - T.A.T.O.C",title);
	}
	
	@Then("^Click on Launch popup Window and Enter the name and click on Submit$")
	public void click_on_launch_popup_window() throws InterruptedException
	{
		Thread.sleep(1000);        
	       String parentWindow = driver.getWindowHandle();      // Storing the handle of the parent window 
	       driver.findElement(By.cssSelector("a[onclick='launchwindow();']")).click();
            Set<String> childWindow = driver.getWindowHandles();   // Storing the handle of all the window that is open
		        
          for(String currentChild : childWindow) {
		            
		            if(!currentChild.equalsIgnoreCase(parentWindow)) {
		                //switch to child window
		                driver.switchTo().window(currentChild);
		                driver.findElement(By.cssSelector("input[id='name']")).sendKeys("vaishali");
		                Thread.sleep(1000);           
		                driver.findElement(By.cssSelector("input[id='submit']")).click();
		             
		                break;
		       }
		   }
		        
		 
		     driver.switchTo().window(parentWindow);  //Switch to parent window
		  
	}
	
	@Then("^Click on Proceed$")
	public void click_on_proceed1()
	{
		 driver.findElement(By.cssSelector("a[onclick='gonext();']")).click();
	}
	
	@Then("^User is on Cookie Handling page$")
	public void user_is_on_cookie_handling()
	{
		String result =  driver.findElement(By.tagName("h1")).getText();
		Assert.assertEquals("Cookie Handling",result);
		 driver.quit();
	}
	
	// Scenario 6
	
	@Given("^User is already on Cookie Handling page$")
	public void user_is_already_on_cookie_handling()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vaishali\\Desktop\\chromedriver.exe\\");
		driver = new ChromeDriver();
		driver.get("http://10.0.1.86/tatoc/basic/cookie");
	}
	
	@When("^Title of the page is Cookie Handling")
	public void title_of_page_is_cookie_handling()
	{
		String title = driver.getTitle();
		Assert.assertEquals("Cookie Handling - Basic Course - T.A.T.O.C",title);
	}
	
	@Then("^Click on Generate Token$")
	public void click_on_generate_token() throws InterruptedException
	{
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[contains(text(),'Generate Token')]")).click();
	      
	}
	
	@Then("^Copy token and click on proceed$")
	public void copy_token_and_proceed() throws InterruptedException
	{
		 String token1= driver.findElement(By.id("token")).getText();
         
         System.out.println(token1);
         String [] split1 = token1.split(":");
         
        driver.manage().addCookie(new Cookie("Token", split1[1].trim()));
          Thread.sleep(1000);
        driver.findElement(By.linkText("Proceed")).click();
          
	}
	
	@Then("^User is on End page$")
	public void user_is_on_end_page() throws InterruptedException
	{
		Thread.sleep(1000);
        String end= driver.findElement(By.xpath("//span[@class='finish']")).getText();
        Assert.assertEquals("Obstacle Course is Complete!",end);
       driver.quit();	
	}
		
	
}

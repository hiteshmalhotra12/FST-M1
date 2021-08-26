package Appium_project;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

//Opening a page on the browser and testing a to-do list page
public class Google_Chrome_Act4 {
	
	AppiumDriver<MobileElement> driver = null;
	WebDriverWait wait;
	String[] taskList = { 
			"Add tasks to list",
			"Get number of tasks",
			"Clear the list"
	}; 
	
	
	@BeforeClass
	public void setUp() throws MalformedURLException {
				
		DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Pixel_B11_Em");
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.android.chrome");
        caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
        caps.setCapability("noReset", true);
		
        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
        wait = new WebDriverWait(driver, 5);
	}   	
	
	@Test
	public void todoList() throws InterruptedException {
		
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		
	 driver.get("https://www.training-support.net/selenium");	
	 
	 // Scroll to find out the To Do List Card  
	 driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).flingToEnd(5)"));	 
	 driver.findElement(MobileBy.xpath("//android.view.View[contains(@text,'To-Do List')]")).click();
	 
	
     // Add the all Tasks in taskList
     for( String task : taskList) {
    	 
    	 // Enter the Task
    	 wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.EditText[@resource-id='taskInput']")));
         driver.findElementByXPath("//android.widget.EditText[@resource-id='taskInput']").sendKeys(task);
         
         // Click on Add Task Button
         wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.Button[@text='Add Task']")));
         driver.findElementByXPath("//android.widget.Button[@text='Add Task']").click();   
             
         System.out.println("Task \""+task+"\" has been added successfully" );
     }
     
       
	 // Get the list of Tasks
     wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//android.view.View[@resource-id='tasksList']/android.view.View[4]/android.view.View")));
     List<MobileElement> tasks = driver.findElementsByXPath("//android.view.View[@resource-id='tasksList']/android.view.View");
     
     //  Assert and then Click on each of the tasks added to strike them out.
     for(int i = 2;i<=tasks.size();i++) { 
    	
    	String taskElement = "//android.view.View[@resource-id='tasksList']/android.view.View["+i+"]/android.view.View" ;
    	MobileElement taskAdded = driver.findElementByXPath(taskElement);
    	taskAdded.click();
    	Assert.assertEquals(taskAdded.getText(), taskList[i-2]);
    	     	  	     	
     }
     
     // Click on ClearList Button
     driver.findElementByXPath("//android.view.View[@resource-id='tasksCard']/android.view.View[3]").click();
     
     // Assertion
     MobileElement taskList = driver.findElementByXPath("//android.view.View[@resource-id='tasksList']");
     Assert.assertFalse(taskList.isDisplayed());
     	 
    }
	
    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}


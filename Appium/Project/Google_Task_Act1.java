package Appium_project;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;


// Goal: Use the Google Tasks app to create a list of activities that need to be completed.
public class Google_Task_Act1 {
	
	AppiumDriver<MobileElement> driver = null;

	String[] taskList = {
			"Complete Activity with Google Tasks",
			"Complete Activity with Google Keep",
			"Complete the second Activity Google Keep"
	};
	
	@BeforeClass
	public void setUp() throws MalformedURLException {
				
		DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Pixel_B11_Em");
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.google.android.apps.tasks");
        caps.setCapability("appActivity", ".ui.TaskListsActivity");
        caps.setCapability("noReset", true);
		
        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
        
	}   	
	
	@Test
	public void addTasks() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
	 
		// Add all the Tasks on the taskList
		for (String task : taskList ) { 
			
			// Click on Add Task Button
			driver.findElementById("tasks_fab").click();
			
			// Add the Tasks 
			driver.findElementById("add_task_title").sendKeys(task);	 
			
			// After each task is added, the Save button should be clicked.
			driver.findElementById("add_task_done").click();
	 
		}
	 
		// Assertions
		List<MobileElement> tasks = driver.findElementsById("task_name");
		
		Assert.assertEquals(tasks.size(), 3);
		Assert.assertEquals(tasks.get(0).getText(), taskList[2]);
		Assert.assertEquals(tasks.get(1).getText(), taskList[1]);
		Assert.assertEquals(tasks.get(2).getText(), taskList[0]);
	  
	}
		
	@AfterClass
    public void tearDown() {
        driver.quit();
    }

}

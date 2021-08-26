package Appium_project;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;


//Use the Google Keep app to add a note with a reminder
 class Google_Keep_Act3 {
	
	AppiumDriver<MobileElement> driver = null;
	WebDriverWait wait;

		@BeforeClass
		public void setUp() throws MalformedURLException {
					
			DesiredCapabilities caps = new DesiredCapabilities();
	        caps.setCapability("deviceName", "Pixel_B11_Em");
	        caps.setCapability("platformName", "Android");
	        caps.setCapability("automationName", "UiAutomator2");
	        caps.setCapability("appPackage", "com.google.android.keep");
	        caps.setCapability("appActivity", ".activities.BrowseActivity");
	        caps.setCapability("noReset", true);
			
	        // Instantiate Appium Driver
	        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
	        driver = new AndroidDriver<MobileElement>(appServer, caps);
	        wait = new WebDriverWait(driver,10);	
	        
		}   	
		
		@Test
		public void addNoteWithReminder() throws InterruptedException {
			
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		 	
		 // Click on Add new Note Button
		 driver.findElementById("new_note_button").click();

		 // Add the Title 'Team Meeting' 
		 wait.until(ExpectedConditions.elementToBeClickable(driver.findElementById("editable_title"))).click();
		 driver.findElementById("editable_title").sendKeys("Mail"); 
		 
		 // Add the Note 
		 wait.until(ExpectedConditions.elementToBeClickable(driver.findElementById("edit_note_text")));
		 driver.findElementById("edit_note_text").sendKeys("Send email");
		 
		 //Click on the Reminder Tool
		 driver.findElementByAccessibilityId("Reminder").click();
		 		 // Set the reminder
		 wait.until(ExpectedConditions.elementToBeClickable(driver.findElementById("menu_text")));
		 driver.findElementById("menu_text").click();
		 
		 // Click on the Back button 
		 driver.navigate().back();
		 //driver.findElementByAccessibilityId("Navigate up").click();   
		
		 // get the Notes Description
		 String notes = driver.findElementById("index_note_text_description").getText();
		 
		 Assert.assertEquals(notes, "Send email");
		                  
		}
		
	    @AfterClass
	    public void tearDown() {
	        driver.quit();
	    }

}



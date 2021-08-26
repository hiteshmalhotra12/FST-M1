package Appium_project;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

//Opening a page on the browser and testing a pop up login page with correct and incorrect credentials
public class Google_Chrome_Act6 {
	AppiumDriver<MobileElement> driver = null;
	WebDriverWait wait;
	
	
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
        wait = new WebDriverWait(driver, 10);
	}   	
	
	@Test
	public void validLogin() throws InterruptedException {
		
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		
	 driver.get("https://www.training-support.net/selenium");	
	 
	 //driver.findElementById("infobar_close_button").click();
	 
	 // Scroll Forward to find out the Login Form option  
	 driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(new UiSelector().scrollable(true)).flingToEnd(5)"));
	 
	 // Click on the option 'Popups' 
	 driver.findElement(MobileBy.xpath("//android.view.View[contains(@text,'Popups')]")).click();
	 
	 // Wait till title of the Logn Page appears
	 //wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//android.view.View[@text='Login Form')]")));
	 driver.findElement(MobileBy.xpath("//android.view.View/android.widget.Button")).click();
     
	 // Enter the username and Password
     driver.findElementByXPath("//android.widget.EditText[@resource-id='username']").sendKeys("admin");
     driver.findElementByXPath("//android.widget.EditText[@resource-id='password']").sendKeys("password");    
      
     // Enter on Log In Button
     driver.findElement(MobileBy.AndroidUIAutomator("text(\"Log in\")")).click();
     
     // Get the Message 
     String message = driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"action-confirmation\")")).getText();
     
     //Assertion
     Assert.assertEquals(message, "Welcome Back, admin"); 
         
	}
	
	@Test
	public void invalidLogin() throws InterruptedException {
		
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
			
		 driver.get("https://www.training-support.net/selenium");	
		 
		 //driver.findElementById("infobar_close_button").click();
		 
		 // Scroll Forward to find out the Login Form option  
		 driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(new UiSelector().scrollable(true)).flingToEnd(5)"));
		 
		 // Click on the option 'Popups' 
		 driver.findElement(MobileBy.xpath("//android.view.View[contains(@text,'Popups')]")).click();
		 
		 // Wait till title of the Logn Page appears
		 //wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//android.view.View[@text='Login Form')]")));
		 driver.findElement(MobileBy.xpath("//android.view.View/android.widget.Button")).click();
	     
		 // Enter the username and Password
	     driver.findElementByXPath("//android.widget.EditText[@resource-id='username']").sendKeys("hits");
	     driver.findElementByXPath("//android.widget.EditText[@resource-id='password']").sendKeys("pwds");    
	      
	     // Enter on Log In Button
	     driver.findElement(MobileBy.AndroidUIAutomator("text(\"Log in\")")).click();
	     
	     // Get the Message 
	     String message = driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"action-confirmation\")")).getText();
	     
	     //Assertion
	     Assert.assertEquals(message, "Invalid Credentials"); 
	         
		}
	
    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}

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
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;


//Goal: Opening a page on the browser and testing a simple login page with correct and incorrect credentials
public class Google_Chrome_Act5 {
	
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
	 
	 
	 
	 
	 driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(new UiSelector().scrollable(true)).scrollForward().scrollForward()"));
	 
	 // Click on Login Form
	 driver.findElement(MobileBy.xpath("//android.view.View[contains(@text,'Login Form')]")).click();
	 
	 // Wait till title of the Logn Page appears
	 wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//android.view.View[@text='Login Form')]")));
	 
     
	 // Enter the username and Password
     driver.findElementByXPath("//android.widget.EditText[@resource-id='username']").sendKeys("admin");
     driver.findElementByXPath("//android.widget.EditText[@resource-id='password']").sendKeys("password");    
      
     // Enter on Log In Button
     driver.findElement(MobileBy.AndroidUIAutomator("text(\"Log in\")")).click();
     
     //Get the Message 
     String message = driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"action-confirmation\")")).getText();
     
     //Assertion
     Assert.assertEquals(message, "Welcome Back, admin"); 
         
	}
	
	@Test
	public void invalidLogin() throws InterruptedException {
		
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		
	 driver.get("https://www.training-support.net/selenium");	
	 
	 
	 // Scroll Forward to find out the Login Form option  
	//driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(new UiSelector().scrollable(true)).scrollForward(5).scrollIntoView(new UiSelector().textContains(\"Login Form\"))"));
	 driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(new UiSelector().scrollable(true)).scrollForward().scrollForward()"));
	  
	 // Click on Login Form
	 driver.findElement(MobileBy.xpath("//android.view.View[contains(@text,'Login Form')]")).click();
	 
	 // Wait till title of the Logn Page appears
	 wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//android.view.View[@text='Login Form')]")));
	 
     
	 // Enter the username and Password
     driver.findElementByXPath("//android.widget.EditText[@resource-id='username']").sendKeys("admin123");
     driver.findElementByXPath("//android.widget.EditText[@resource-id='password']").sendKeys("password123");    
      
     // Enter on Log In Button
     driver.findElement(MobileBy.AndroidUIAutomator("text(\"Log in\")")).click();
     
     //Get the Message 
     String message = driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"action-confirmation\")")).getText();
     
     //Assertion
     Assert.assertEquals(message, "Invalid Credentials"); 
         
	}
	
	
    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}


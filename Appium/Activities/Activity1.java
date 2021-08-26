package Appium_project;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.testng.annotations.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Activity1 {
    @Test
    public void calc() throws InterruptedException, IOException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Pixel_B11_Em");
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.android.calculator2");
        caps.setCapability("appActivity", ".Calculator");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        AppiumDriver<MobileElement> driver = null;
        try {
            // Initialize driver
            driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
            System.out.println("Calculator is open");
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }
    }
}
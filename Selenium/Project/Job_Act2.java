package Job;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Job_Act2  {
    public static void main(String[] args) {

        //Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        
        //And now use this to visit the website
        driver.get("https://alchemy.hguy.co/jobs/");
        //Check the header of the page
        String heading = driver.findElement(By.className("entry-title")).getText();
        //Print the header of the page
        System.out.println("Page Header is: " + heading);
        if (heading.equals("Welcome to Alchemy Jobs"))
        {
        //Close the browser
         driver.close();
        }
    }
}

package Job;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Job_Act1  {
    public static void main(String[] args) {

        //Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        
        //And now use this to visit the website
        driver.get("https://alchemy.hguy.co/jobs/");
        
        //Check the title of the page
        String title = driver.getTitle();
        //Print the title of the page
        System.out.println("Page title is: " + title);
        if (title.equals("Alchemy Jobs – Job Board Application"))
        {
        //Close the browser
         driver.close();
        }
    }
}

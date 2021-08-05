package Job;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Job_Act4  {
    public static void main(String[] args) {

        //Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        
        //And now use this to visit the website
        driver.get("https://alchemy.hguy.co/jobs/");
        //Check the header2 of the page
        String heading2 = driver.findElement(By.cssSelector(".entry-content > h2:nth-child(6)")).getText();
        //Print the header2 of the page
        System.out.println("Page Header 2 is: " + heading2);
        if (heading2.equals("Quia quis non"))
        {
        //Close the browser
         driver.close();
        }
    }
}

package Job;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Job_Act3  {
    public static void main(String[] args) {

        //Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        
        //And now use this to visit the website
        driver.get("https://alchemy.hguy.co/jobs/");
        //Check the url of the image
        String imgurl = driver.findElement(By.xpath("/html/body/div/div/div/div/main/article/header/div/img")).getAttribute("src");
        //Print the Url of the image
        System.out.println("Page Image URL is: " + imgurl);
        
        //Close the browser
         driver.close();
        
    }
}

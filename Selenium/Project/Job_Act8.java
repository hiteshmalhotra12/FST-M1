package Job;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Job_Act8  {
    public static void main(String[] args) {

        //Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        
        //And now use this to visit the website
        driver.get("https://alchemy.hguy.co/jobs/wp-admin");
        //click on button Jobs
        WebElement usr = driver.findElement(By.id("user_login"));
        WebElement pswd = driver.findElement(By.id("user_pass"));
        usr.sendKeys("root");
        pswd.sendKeys("pa$$w0rd");
       driver.findElement(By.id("wp-submit")).click();
        
        //Close the browser
        driver.close();
        
    }
}

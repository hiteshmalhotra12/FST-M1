package Job;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Job_Act6  {
    public static void main(String[] args) {

        //Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //And now use this to visit the website
        driver.get("https://alchemy.hguy.co/jobs/");
        driver.findElement(By.id("menu-item-24")).click();
        driver.getCurrentUrl();
        
        WebElement keyw = driver.findElement(By.id("search_keywords"));
        keyw.sendKeys("Banking");
        driver.findElement(By.xpath("/html/body/div/div/div/div/main/article/div/div/form/div[1]/div[4]/input")).click();
        try {
            Thread.sleep(5*1000);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        driver.findElement(By.xpath("/html/body/div/div/div/div/main/article/div/div/ul/li[1]/a/div[1]/h3")).click();
        
        driver.findElement(By.xpath("/html/body/div/div/div/div/main/article/div/div/div/div[3]/input")).click();
        try {
            Thread.sleep(2*1000);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
       String vemail =  driver.findElement(By.className("job_application_email")).getText();
        
        System.out.println("Email Id is: " + vemail);
        //Close the browser
         driver.close();
      
    }
}

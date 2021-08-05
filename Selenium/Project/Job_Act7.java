package Job;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Job_Act7  {
    public static void main(String[] args) {

        //Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //And now use this to visit the website
        driver.get("https://alchemy.hguy.co/jobs/");
        driver.findElement(By.id("menu-item-26")).click();
        driver.getCurrentUrl();
        WebElement account = driver.findElement(By.id("create_account_email"));
        WebElement jobtitle = driver.findElement(By.id("job_title"));
        WebElement app = driver.findElement(By.id("application"));
        WebElement desf = driver.findElement(By.id("job_description_ifr"));
        driver.switchTo().frame(desf);
        driver.findElement(By.id("tinymce")).sendKeys("This is test description");
        driver.switchTo().parentFrame();
        //String dd = driver.findElement(By.id("job_description")).get;
        
        WebElement compname = driver.findElement(By.id("company_name"));
        WebElement tagline = driver.findElement(By.id("company_tagline"));
        WebElement twit = driver.findElement(By.id("company_twitter"));
        account.sendKeys("hitesh1@gmail.com");
        jobtitle.sendKeys("Tester");
        app.sendKeys("hitesh12@gmail.com");
        compname.sendKeys("Test company");
        tagline.sendKeys("Sucessful company");
        twit.sendKeys("@testcompany");
        try {
            Thread.sleep(5*1000);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        driver.findElement(By.name("submit_job")).click();
        driver.findElement(By.id("job_preview_submit_button")).click();
       driver.navigate().to("https://alchemy.hguy.co/jobs/jobs/");
        //Close the browser
         driver.close();
      
    }
}

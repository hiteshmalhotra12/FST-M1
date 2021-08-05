package Job;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Job_Act9  {
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
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/ul/li[7]/a/div[3]")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div[4]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"post-title-0\"]")).sendKeys("Data Tester");
        driver.findElement(By.xpath("//*[@id=\"_company_name\"]")).sendKeys("Test Company");
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div[4]/div[1]/div/div/div[1]/div/div[1]/div/div[2]/button[2]")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div[4]/div[1]/div/div/div[1]/div/div[2]/div[3]/div/div/div/div[1]/div/button")).click();
        try {
            Thread.sleep(2*1000);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div[4]/div[1]/div/div/div[1]/div/div[2]/div[3]/div/div/div/div[2]/div/div[2]/div[2]/a")).click();
        
        //Close the browser
        driver.close();
        
    }
}

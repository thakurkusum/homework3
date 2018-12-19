
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MailToFriend {
    public static WebDriver driver;

    public static void main(String []args){
        System.setProperty("webdriver.chrome.driver","src\\browserdriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.manage().window().fullscreen();
        driver.get("https://demo.nopcommerce.com/");
        driver.findElement(By.xpath("//h2[@class=\"product-title\"]//a[@href=\"/apple-macbook-pro-13-inch\"]")).click();
        driver.findElement(By.xpath("//input[@value=\"Email a friend\"]")).click();
        driver.findElement(By.xpath("//input[@class=\"friend-email\"]")).sendKeys("ghost@mail.com");
        driver.findElement(By.xpath("//input[@class=\"your-email\"]")).sendKeys("kapilsharama@mail.com");
        driver.findElement(By.xpath("//textarea[@id=\"PersonalMessage\"]")).sendKeys("check out this");
        driver.findElement(By.xpath("//input[@name=\"send-email\"]")).click();

     String expected  = "Only registered customers can use email a friend feature";
     String actual =driver.findElement(By.xpath("//div[@class=\"message-error validation-summary-errors\"]//li")).getText();
        Assert.assertEquals("test case is failed",expected,actual);
        driver.quit();
    }



    }


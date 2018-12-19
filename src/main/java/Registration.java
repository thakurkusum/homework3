


import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Registration {


        public static WebDriver driver;


    //public static void main(String[] args) {
@Test
        public void page(){
    String expectedRegisterSuccessMessage ="Your registration completed";
            System.setProperty("webdriver.chrome.driver","src\\browserdriver\\chromedriver.exe");
            driver = new ChromeDriver();

            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            driver.manage().window().fullscreen();
            driver.get("https://demo.nopcommerce.com/");
            driver.findElement(By.linkText("Register")).click();
            driver.findElement(By.id("gender-female")).click();
            driver.findElement(By.id("FirstName")).sendKeys("kapil");
            driver.findElement(By.id("LastName")).sendKeys("sharama");

    Select dateofBirthDay = new Select(driver.findElement(By.name("DateOfBirthDay")));
    dateofBirthDay.selectByValue("12");

    Select dateofBirthMonth = new Select(driver.findElement(By.name("DateOfBirthMonth")));
    dateofBirthMonth.selectByIndex(2);

    Select dateofBirthYear = new Select(driver.findElement(By.name("DateOfBirthYear")));
    dateofBirthYear.selectByVisibleText("1999");



    DateFormat dateFormat = new SimpleDateFormat("MMddyyyyHHmmss");
            Date date = new Date();
            String date1 = dateFormat.format(date);
            driver.findElement(By.id("Email")).sendKeys("testfirst"+date1+"@test.com");
            driver.findElement(By.id("Password")).sendKeys("Test@1234");
            driver.findElement(By.id("ConfirmPassword")).sendKeys("Test@1234");
            driver.findElement(By.id("register-button")).click();
           String actualRegisterSuccessMessage = driver.findElement(By.xpath("//div[@class='result']")).getText();
    Assert.assertEquals("Test case: registration scenario failed",expectedRegisterSuccessMessage,actualRegisterSuccessMessage);
            driver.findElement(By.linkText("Log out")).click();
            driver.close();
         }
          @Test
           public void currency(){
           System.setProperty("webdriver.chrome.driver","src\\browserdriver\\chromedriver.exe");
           driver = new ChromeDriver();
              driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
              driver.manage().window().fullscreen();
              driver.get("https://demo.nopcommerce.com/");
              driver.findElement(By.xpath("//select[@id=\"customerCurrency\"]//option[2]")).click();
              //System.out.println("I have set the currency to Euro");
              driver.close();



         }
    }

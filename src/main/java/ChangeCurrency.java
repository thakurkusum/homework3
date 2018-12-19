import com.sun.org.apache.bcel.internal.generic.Select;
import com.sun.org.apache.bcel.internal.generic.Visitor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

public class ChangeCurrency {

    public static WebDriver driver;

    public static void main(String[]args){

        System.setProperty("webdriver.chrome.driver","src\\browserdriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.manage().window().fullscreen();
        driver.get("https://demo.nopcommerce.com");
        driver.findElement(By.className("currency-selector")).click();
        driver.findElement(By.xpath("//select[@id=\"customerCurrency\"]//option[2]")).click();
     //  driver.quit();

    }




    }



package positive;

import org.junit.After;
import org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class RegistrationTest {

    WebDriver driver;

    @Before
    public void startUp (){
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\SeleniumWebDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://shop.pragmatic.bg/");
    }



    @Test
    public void registration(){
        //In order for this to work again you need to change the email as otherwise gives
        //the following message: Warning: E-Mail Address is already registered!
        
        driver.findElement(By.cssSelector("span.caret")).click();
        driver.findElement(By.linkText("Register")).click();
        assertTrue("Wrong title", driver.getTitle().contains("Register Account"));

        driver.findElement(By.id("input-firstname")).sendKeys("Sonya");
        driver.findElement(By.id("input-lastname")).sendKeys("Tsekova");
        driver.findElement(By.id("input-email")).sendKeys("urtsbs@gmail.com");
        driver.findElement(By.id("input-telephone")).sendKeys("0888087207");
        driver.findElement(By.id("input-password")).sendKeys("parola123!");
        driver.findElement(By.id("input-confirm")).sendKeys("parola123!");

        WebElement subscribeRadioButton = driver.findElement(By.cssSelector("label.radio-inline input[value='1']"));
        if (!subscribeRadioButton.isSelected()){
            subscribeRadioButton.click();
        }
        assertTrue(subscribeRadioButton.isSelected());

        WebElement agreeToPrivacyPolicy = driver.findElement(By.cssSelector("div.pull-right input[value='1']"));

        if (!agreeToPrivacyPolicy.isSelected()){
            agreeToPrivacyPolicy.click();
        }

        assertTrue(agreeToPrivacyPolicy.isSelected());

        driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
        assertTrue("Wrong Title", driver.getTitle().contains("Your Account Has Been Created!"));
    }


    @After
    public void tearDown(){
        driver.quit();
    }
}

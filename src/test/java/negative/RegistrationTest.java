package negative;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
        driver.findElement(By.cssSelector("span.caret")).click();
        driver.findElement(By.linkText("Register")).click();
        assertTrue("Wrong title", driver.getTitle().contains("Register Account"));

        driver.findElement(By.cssSelector("input.btn.btn-primary")).click();

        String validationMessage = driver.findElement(By.cssSelector("div.alert.alert-danger.alert-dismissible")).getText();

        assertTrue("Message not found", validationMessage.contains("Warning: You must agree to the Privacy Policy!"));

    }

    @After
    public void tearDown(){
        driver.quit();
    }
}

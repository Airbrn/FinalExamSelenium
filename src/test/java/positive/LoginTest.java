package positive;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class LoginTest {

    WebDriver driver;

    @Before
    public void startUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\SeleniumWebDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://shop.pragmatic.bg/");
    }

    @Test
    public void login() {
        driver.findElement(By.cssSelector("span.caret")).click();
        driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//li//a[text()='Login']")).click();
        assertTrue("Wrong title", driver.getTitle().contains("Account Login"));

        driver.findElement(By.id("input-email")).sendKeys("urtsbs@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys("parola123!");
        driver.findElement(By.cssSelector("input[value='Login']")).click();

        assertTrue("Wrong Title", driver.getTitle().contains("My Account"));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

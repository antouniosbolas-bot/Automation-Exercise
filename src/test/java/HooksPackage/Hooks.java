package HooksPackage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Hooks {
    public static WebDriver driver;
    @Before
    public  void setup(){
        driver= new FirefoxDriver();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/");



    }
    @After
    public void tearDown(){
        driver.quit();
    }
}

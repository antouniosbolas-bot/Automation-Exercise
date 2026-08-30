package BaseTest;

import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTestClass {
    WebDriver driver;
    protected HomePage homePage;
   protected PaymentPage paymentPage;
   protected CartPage cartPage;
   protected CheckOutPage checkOutPage;
   protected ProductsPage productsPage;
   protected LoginPage loginPage;
   protected FillingDataPage filingDataPage;
   protected AccountCreatedPage accountCreatedPage;
  protected AccountDeletedPage accountDeletedPage;
  protected ContactUsPage contactUsPage;
  protected TestCasesPage testCasesPage;
  protected ProductDeteilsPage productDeteilsPage;
  protected PaymentDonePage paymentDonePage;
  protected BrandsPage brandsPage;
  protected CategoryPage categoryPage;



    @BeforeClass
    public void setup(){

        driver= new FirefoxDriver();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
       homePage = new HomePage(driver);



    }
    @BeforeMethod
    public void goToUrl(){

        driver.get("https://automationexercise.com/");

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}

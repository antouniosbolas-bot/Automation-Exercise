package Pages;

import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.cssSelector;

public class CheckOutPage {
    WebDriver driver;

    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
    }

    By ActualResultAdressText = By.xpath("//h2[text()='Address Details']");
    String ExpectedResultAdressTest = "Address Details";
    By TextereaBox = By.xpath("//textarea[@class=\"form-control\"]");
    By PlaceOrderBtn = By.cssSelector("a[href=\"/payment\"]");
    By EnterEmail = By.cssSelector("input[type=\"email\"]");
    By DelivaryAddressText = By.cssSelector("ul[class=\"address item box\"] li");
    By BillingAddressText = By.cssSelector("ul[class=\"address alternate_item box\"] li");
    By DeleteAccountBtn = cssSelector("a[href=\"/delete_account\"]");





    public String getExpectedResultTest (){
        return ExpectedResultAdressTest;
    }
    public String getActualResultText (){
        return driver.findElement(ActualResultAdressText).getText();

    }
    public void AddComment(String text){
        driver.findElement(TextereaBox).sendKeys(text);
    }
    public PaymentPage ClickOnPlaceOrderBtn(){
        driver.findElement(PlaceOrderBtn).click();
        return new PaymentPage(driver);

    }
    public void AddEmail(String text){
        driver.findElement(EnterEmail).sendKeys(text);
    }
    public String getDelivaryAddress(){
         return driver.findElement(DelivaryAddressText).getText().trim();
    }
     public String getBillingAddress(){
         return driver.findElement(BillingAddressText).getText().trim();
    }
    public AccountDeletedPage ClickOnDeleteAccountBtn(){
        driver.findElement(DeleteAccountBtn).click();
        return new AccountDeletedPage(driver);

    }
    public boolean IsOnCheckOutPage(){
        return driver.findElement(ActualResultAdressText).isDisplayed();
    }
    public boolean IsDelivaryAddressTextDisplayed(){
        return driver.findElement(DelivaryAddressText).isDisplayed();
    }
    public boolean IsBillingAddressTextDisplayed(){
        return driver.findElement(BillingAddressText).isDisplayed();
    }



}

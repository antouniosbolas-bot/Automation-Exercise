package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PaymentPage {
    WebDriver driver;
    WebDriverWait wait;

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By NameOnCardLocator = By.cssSelector("input[class=\"form-control\"]");
    By CardnumberLocator = By.cssSelector("input[name=\"card_number\"]");
    By CVCLocator = By.cssSelector("input[name=\"cvc\"]");
    By ExpirationMonth = By.cssSelector("input[class=\"form-control card-expiry-month\"]");
    By ExpirationYear = By.cssSelector("input[data-qa=\"expiry-year\"]");
    By ConfirmOrder = By.cssSelector("button[class=\"form-control btn btn-primary submit-button\"]");
    String ExpectedConfirmOrderText = "Your order has been placed successfully!";
    By ActualConfirmOrderText = By.xpath("//div[contains(text(),'Your order has been placed successfully!')]");
    By ActualTitele = By.cssSelector("h2[class=\"heading\"]");

    public String getExpectedConfirmOrderText(){
        return ExpectedConfirmOrderText;
    }
    public String getActualConfirmOrderText(){
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(ActualConfirmOrderText))).getText().trim();
    }
    public boolean isConfirmOrderTextDisplayed(){
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(ActualConfirmOrderText))).isDisplayed();
    }

    public void SendNameOnCard(String name){
        driver.findElement(NameOnCardLocator).sendKeys(name);
    }
    
    public void SendNumberOnCard(String number){
         driver.findElement(CardnumberLocator).sendKeys(number);
        
    }
    public void SendCVC(String cvc){
        driver.findElement(CVCLocator).sendKeys(cvc);
    }
    public void SendMonth(String month){
        driver.findElement(ExpirationMonth).sendKeys(month);
    }
    public void SendYear(String year){
        driver.findElement(ExpirationYear).sendKeys(year);
    }
    public PaymentDonePage ClickOnConfirmOrder(){
        driver.findElement(ConfirmOrder).click();
        return new PaymentDonePage(driver);
    }
    public boolean IsOnPaymentPage(){
        return driver.findElement(ActualTitele).isDisplayed();
    }



}

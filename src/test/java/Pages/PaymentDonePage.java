package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.cssSelector;

public class PaymentDonePage {
    WebDriver driver;

    public PaymentDonePage(WebDriver driver) {
        this.driver = driver;
    }

    By ActualOrderPlacedText = By.xpath("//b[text()='Order Placed!']");
    String ExpectedOrderPlacedText = "Order Placed!";
     By ActualVerifMSG = By.xpath("//p[@style=\"font-size: 20px; font-family: garamond;\"]");
     String ExpectedVerifMSG = "Congratulations! Your order has been confirmed!";
     By ContinueBtn = By.xpath("//a[@class=\"btn btn-primary\"]");
By DownloadBtn= By.cssSelector("a[class=\"btn btn-default check_out\"]");
    By DeleteAccountBtn = cssSelector("a[href=\"/delete_account\"]");


public String getExpectedOrderPlacedText(){
    return ExpectedOrderPlacedText;
}
public String getActualOrderPlacedText(){
    return driver.findElement(ActualOrderPlacedText).getText();
}
public String getExpectedVerifMSG(){
    return ExpectedVerifMSG;
}
public String getActualVerifMSG(){
   return driver.findElement(ActualVerifMSG).getText();
}

public HomePage ClickOnContinueBtn(){
    driver.findElement(ContinueBtn).click();
    return new HomePage(driver);

}
public void ClickOnDownloadBtn(){
    driver.findElement(DownloadBtn).click();
}
    public AccountDeletedPage ClickOnDeleteAccountBtn() {
        driver.findElement(DeleteAccountBtn).click();
        return new AccountDeletedPage(driver);
    }
    public boolean IsOrderPlaced(){
    return driver.findElement(ActualOrderPlacedText).isDisplayed();
    }



}

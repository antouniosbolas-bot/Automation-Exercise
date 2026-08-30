package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountDeletedPage {
    WebDriver driver;

    public AccountDeletedPage(WebDriver driver) {
        this.driver = driver;
    }
    By ActualTitleLocator = By.xpath("//b[contains(text(),'Account Deleted!')]");
    By ContinueBtnLocator = By.cssSelector("a[class=\"btn btn-primary\"]");
    String ExpectedTitel = "ACCOUNT DELETED!";

    public String ExpectedTitle(){
        return ExpectedTitel;
    }
    public String getActualTitle(){
        return driver.findElement(ActualTitleLocator).getText();
    }
    public boolean IsOnAccountDeletedPage(){
        return driver.findElement(ActualTitleLocator).isDisplayed();
    }
    public HomePage ClickOnContinueBtn(){
        driver.findElement(ContinueBtnLocator).click();
        return new HomePage(driver);

    }


}

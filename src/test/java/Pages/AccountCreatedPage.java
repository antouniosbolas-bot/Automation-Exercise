package Pages;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountCreatedPage {
    WebDriver driver;

    public AccountCreatedPage(WebDriver driver) {
        this.driver = driver;
    }
    By ActualTitelLocator = By.xpath("//b[text()='Account Created!']");
    By ActualSuccessMSG = By.xpath("//p[text()='Congratulations! Your new account has been successfully created!']");
    By MSG2 = By.xpath("//p[@style=\"font-size: 20px; font-family: garamond;\"][2]");
    String ExpectedTitel = "ACCOUNT CREATED!";
    String ExpectedSuccessMsg = "Congratulations! Your new account has been successfully created!";
    String ExpectedMSG2="You can now take advantage of member privileges to enhance your online shopping experience with us.";
By ContinueBtnLocator = By.cssSelector("a[class=\"btn btn-primary\"]");

public String getExpectedTitel(){
    return ExpectedTitel;
}
public String getExpectedSuccessMsg(){
    return ExpectedSuccessMsg;
}
public String getExpectedMSG2(){
    return ExpectedMSG2;
}
public String ActualTitel(){
    return driver.findElement(ActualTitelLocator).getText();
}
    public String ActualSuccessMsg(){
        return driver.findElement(ActualSuccessMSG).getText();
    }
    public String ActualMSG2(){
        return driver.findElement(MSG2).getText();
    }
    public HomePage ClickOnContinueBtn(){
    driver.findElement(ContinueBtnLocator).click();
    return new HomePage(driver);


}

}

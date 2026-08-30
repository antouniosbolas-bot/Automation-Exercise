package Pages;

import com.beust.ah.A;
import io.cucumber.java.an.E;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactUsPage {
    WebDriver driver;
    WebDriverWait wait;

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    By ActualTitle = By.cssSelector(".col-sm-12 h2");
    String ExpectedTitle = "Contact Us";
    By ActualGetInTouchText = By.xpath("//h2[text()='Get In Touch']");
    String ExpectedGetInTouchText="GET IN TOUCH";
    By NameTextBox = By.xpath("//input[@data-qa=\"name\"]");
    By EmailTextBox = By.xpath("//input[@data-qa=\"email\"]");
    By SubjectTextBox = By.xpath("//input[@data-qa=\"subject\"]");
    By MessageTextBoxLocator = By.id("message");

    By UploadFileLocator = By.cssSelector("input[name=\"upload_file\"]");
    By SubmitBtn = By.cssSelector("input[type=\"submit\"]");
    By SuccessMSG = By.cssSelector("div[class=\"status alert alert-success\"]");
    String ExpectedSuccessMSG = "Success! Your details have been submitted successfully.";
    By HomeBtn = By.cssSelector("a[class=\"btn btn-success\"]");






    public String getExpectedGetInTouchText(){
        return ExpectedGetInTouchText;
    }
    public String getActualGetInTouchText(){
        return driver.findElement(ActualGetInTouchText).getText();
    }

    public String getExpectedTitle(){
        return ExpectedTitle;
    }
    public String getActualTitle(){
       return driver.findElement(ActualTitle).getText();
    }
    public void ENterUrName(String name){
        driver.findElement(NameTextBox).sendKeys(name);
    }
    public void EnterUrEmail(String email){
        driver.findElement(EmailTextBox).sendKeys(email);
    }
    public void EnterSubject(String subject){
        driver.findElement(SubjectTextBox).sendKeys(subject);
    }
    public void EnterMSG(String MSG){
        driver.findElement(MessageTextBoxLocator).sendKeys(MSG);
    }
    public void UploadFile(){
        driver.findElement(UploadFileLocator).click();
    }
    public void ClickOnSubmitBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(SubmitBtn)).click();
     //   driver.findElement(SubmitBtn).click();
    }
    public void AcceptAlert(){
        driver.switchTo().alert().accept();

    }
    public String getExpectedSuccessMSG(){
        return ExpectedSuccessMSG;
    }
    public String getActualSuccessMSG(){
        return driver.findElement(SuccessMSG).getText();
    }
    public boolean IsSuccessMSGDisplayd(){
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(SuccessMSG))).isDisplayed();
    }
public HomePage ClickOnHomeBtn(){
        driver.findElement(HomeBtn).click();
        return new HomePage(driver);
}

public boolean IsONContactUs(){
        return driver.findElement(ActualTitle).isDisplayed();

}

}

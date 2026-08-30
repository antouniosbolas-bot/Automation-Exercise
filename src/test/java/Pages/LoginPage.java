package Pages;

import io.cucumber.java.an.E;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    By EmailFromLogin = By.cssSelector("input[data-qa=\"login-email\"]");
    By PasswordFromLogin= By.cssSelector("input[type=\"password\"]");
    By LoginBtn = By.cssSelector("button[data-qa=\"login-button\"]");
    By NameFromSignup = By.xpath("//input[@data-qa=\"signup-name\"]");
    By EmailFromSiginup = By.xpath("//input[@data-qa=\"signup-email\"]");
    By SignupBtn = By.xpath("//button[@data-qa=\"signup-button\"]");
    By ActualNewUserText = By.xpath("//h2[(text()='New User Signup!')]");
    String ExpectedNewUserText="New User Signup!";
    By LoginText = By.xpath("//h2[text()='Login to your account']");
    String ExpectedLoginText="Login to your account";
    By ActualLoginErrorText = By.cssSelector("p[style=\"color: red;\"]");
    String ExpectedLoginErrorText="Your email or password is incorrect!";
    By ActualExistingEmailErrorText = By.cssSelector("p[style=\"color: red;\"]");
    String ExpectedExistingEmailErrorText="Email Address already exist!";
    By ActualErrorMSG = By.cssSelector("p[style=\"color: red;\"]");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public String getExpectedExistingEmailErrorText(){
        return ExpectedExistingEmailErrorText;
    }
    public String getActualExistingEmailErrorText(){
        return driver.findElement(ActualExistingEmailErrorText).getText();
    }

    public String getExpectedLoginErrorText(){
        return ExpectedLoginErrorText;
    }
    public String getActualLoginErrorText(){
        return driver.findElement(ActualLoginErrorText).getText();
    }


    public String getExpectedLoginText(){
        return ExpectedLoginText;
    }
    public String getActualLoginText(){
        return driver.findElement(LoginText).getText();
    }
    public void EnterLoginEmail(String email){
        driver.findElement(EmailFromLogin).sendKeys(email);
    }
    public void EnterLoginPassword(String password){
        driver.findElement(PasswordFromLogin).sendKeys(password);
    }
    public HomePage ClickOnLginBtn(){
        driver.findElement(LoginBtn).click();
        return new HomePage(driver);
    }
    public void EnterSignupName(String name){
        driver.findElement(NameFromSignup).sendKeys(name);
    }
    public void EnterSignupEmail(String Email){
        driver.findElement(EmailFromSiginup).sendKeys(Email);
    }

    public FillingDataPage ClickOnSignup(){
        driver.findElement(SignupBtn).click();
        return new FillingDataPage(driver);
    }
    public String getExpectedNewUserText(){
        return ExpectedNewUserText;
    }
    public String getActualNewUserText(){
        return driver.findElement(ActualNewUserText).getText();
    }
    public boolean IsErrorMsgDisplay(){
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(ActualErrorMSG))).isDisplayed();
    }
    public boolean IsOnLoginPage(){
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(ActualNewUserText))).isDisplayed();
    }



}


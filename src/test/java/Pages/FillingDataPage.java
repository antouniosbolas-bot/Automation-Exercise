package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FillingDataPage {
    WebDriver driver;
    Select select;
    WebDriverWait wait;

    public FillingDataPage(WebDriver driver) {
        this.driver = driver;
       wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    By MrLocator = By.id("id_gender1");
    By MrSLocator =By.id("id_gender2");
    By NameTextBoxLocator = By.id("name");
    By EmailTextboxLocator = By.id("email");
    By PasswordTextBoxLocator = By.id("password");
    By SelectDaysLocator = By.id("days");
    By SelectMonthLocaTor = By.id("months");
    By SelectYearsLocator = By.id("years");
    By SignupNewsletterLocator = By.id("newsletter");
    By ReciveParentsLocator = By.id("optin");
// Adress Information
    By Firstname = By.id("first_name");
    By Lastname = By.id("last_name");
    By CampanyLocator = By.id("company");
    By AdressOneLocator = By.id("address1");
    By AddresTwoLocator = By.id("address2");
    By CountryLocator = By.id("country");
    By StateLocator = By.id("state");
    By CityLocator = By.id("city");
    By ZipCodeLocator = By.id("zipcode");
    By PhoneNumLocator = By.id("mobile_number");
    By CreatAccountBtn = By.cssSelector("button[data-qa=\"create-account\"]");
    By ActaulConfirmText = By.xpath("//b[text()='Enter Account Information']");
    String ExpectedConfirmText="ENTER ACCOUNT INFORMATION";

    public String getExpectedConfirmText(){
        return ExpectedConfirmText;
    }
    public String getActualConfirmText(){
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(ActaulConfirmText))).getText();
    }
    public boolean IsOnFillingDataPage(){
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(ActaulConfirmText))).isDisplayed();
    }

    public void ClickOnMr(){
        driver.findElement(MrLocator).click();
    }
    public boolean MrIsSelected(){
return driver.findElement(MrLocator).isSelected();
    }
    public void ClickOnMrs(){
        driver.findElement(MrSLocator).click();
    }
    public boolean MrsIsSelected(){
        return driver.findElement(MrSLocator).isSelected();
    }
    public void EnterName(String name){
        driver.findElement(NameTextBoxLocator).sendKeys(name);
    }
    public void EnterEmail(String email){
        driver.findElement(EmailTextboxLocator).sendKeys(email);
    }
    public void EnterPassword(String password){
        driver.findElement(PasswordTextBoxLocator).sendKeys(password);
    }
    public void SelectDays(int Days){
        select = new Select(driver.findElement(SelectDaysLocator));
        select.selectByIndex(Days);

    }
    public void SelectMonth(int Month){
      select = new Select(driver.findElement(SelectMonthLocaTor));
        select.selectByIndex(Month);
    }
    public void SelectYear(String Year){
       select = new Select(driver.findElement(SelectYearsLocator));
       select.selectByValue(Year);
    }
    public void ClickOnSign_up_for_our_newsletter(){
        driver.findElement(SignupNewsletterLocator).click();
    }
    public void ClickOnReceive_special_offers_from_our_partners(){
        driver.findElement(ReciveParentsLocator).click();
    }
    public void EnterFirstName(String firstname){
        driver.findElement(Firstname).sendKeys(firstname);
    }
    public void EnterLastName(String lastname){
        driver.findElement(Lastname).sendKeys(lastname);
    }
    public void EnterCompany(String company){
        driver.findElement(CampanyLocator).sendKeys(company);
    }
    public void EnterAdressOne(String Adress1){
        driver.findElement(AdressOneLocator).sendKeys(Adress1);
    }
    public void EnterAdressTwo(String Adress2){
        driver.findElement(AddresTwoLocator).sendKeys(Adress2);
    }
    public void SelectYourCuntry(String cuntry){
        select = new Select(driver.findElement(CountryLocator));
        select.selectByValue(cuntry);
    }
    public void EnterYourState(String state){
        driver.findElement(StateLocator).sendKeys(state);
    }
    public void EnteryourCity(String city){
        driver.findElement(CityLocator).sendKeys(city);
    }
    public void EnterYourZipCode(String ZipCode){
        driver.findElement(ZipCodeLocator).sendKeys(ZipCode);
    }
    public void EnterYourPhone(String Phone){
        driver.findElement(PhoneNumLocator).sendKeys(Phone);
    }
    public AccountCreatedPage ClickOnCreateAccount(){
        driver.findElement(CreatAccountBtn).click();
        return new AccountCreatedPage(driver);

    }




}

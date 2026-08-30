package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductDeteilsPage {
    WebDriver driver;
    WebDriverWait wait;


    public ProductDeteilsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    By NameOfProductLocator = By.cssSelector(".product-information h2");
    By CategoryOfProductLocator = By.xpath("//p[contains(text(),\"Category:\")]");
    By PriceOfProductLocator = By.cssSelector(".product-information span span");
    By QuantityOfProductLocator = By.cssSelector(".product-information label");
    By AvailabilityOfProductLocator = By.xpath("//p[b[text()=\"Availability:\"]]");
    By ConditionOfProductLocator =By.xpath("//p[b[text()=\"Condition:\"]]");
    By BrandOfProductLocator = By.xpath("//p[b[text()=\"Brand:\"]]");
    By UrNameTextBoxLocator = By.cssSelector("input[id=\"name\"]");
    By UrEmailTextBoxLocator = By.cssSelector("input[id=\"email\"]");
    By ReviewTextAreaLocator = By.cssSelector("textarea[name=\"review\"]");
    By SubmitBtnLocator = By.cssSelector("button[id=\"button-review\"]");
    By QuantityCounterLocator = By.cssSelector("input[name=\"quantity\"]");
    By AddToCartBtn = By.cssSelector("button[class=\"btn btn-default cart\"]");
    By ViewCartLink = By.linkText("View Cart");
    By WriteReviewText = By.cssSelector("a[href=\"#reviews\"]");
    By SuccessMessageLocator = By.cssSelector("span[style=\"font-size: 20px;\"]");



    public String getNameOfProduct(){
        return driver.findElement(NameOfProductLocator).getText();
    }
    public String getCategoryOfProduct(){
        return driver.findElement(CategoryOfProductLocator).getText();
    }
    public String getPriceOfProduct(){
        return driver.findElement(PriceOfProductLocator).getText();
    }
    public String getQuantityOfProduct(){
        return driver.findElement(QuantityOfProductLocator).getText();
    }
    public String getAvailabilityOfProduct(){
        return driver.findElement(AvailabilityOfProductLocator).getText();
    }
    public String getConditionOfProduct(){
        return driver.findElement(ConditionOfProductLocator).getText();
    }
    public String getBrandOfProduct(){
        return driver.findElement(BrandOfProductLocator).getText();
    }
    public boolean IsOnProductDetailsPage() {
        return driver.findElement(NameOfProductLocator).isDisplayed();

    }
    public void EnterUrName(String Name) {
        driver.findElement(UrNameTextBoxLocator).sendKeys(Name);
    }
    public void EnterUrEmail(String Email) {
        driver.findElement(UrEmailTextBoxLocator).sendKeys(Email);
    }
    public void EnterUrReview(String Review) {
        driver.findElement(ReviewTextAreaLocator).sendKeys(Review);
    }
    public void ClickOnSubmitBtn() {
        driver.findElement(SubmitBtnLocator).click();
    }
    public void EnterQuantity(String value){
      /*  Select quantitySelect = new Select(driver.findElement(QuantityCounterLocator));
        quantitySelect.selectByValue(String.valueOf(value));*/
        WebElement quantityCounter = driver.findElement(QuantityCounterLocator);
        quantityCounter.clear();
        quantityCounter.sendKeys(value);


    }
    public void ClickOnAddToCartBtn(){
        driver.findElement(AddToCartBtn).click();
    }
    public CartPage getViewCartLink(){
        wait.until(ExpectedConditions.elementToBeClickable(ViewCartLink)).click();
        return new CartPage(driver);

    }
    public boolean WriteReview(){
        return driver.findElement(WriteReviewText).isDisplayed();
    }
    public boolean SuccessMessageDisplayed(){
        return driver.findElement(SuccessMessageLocator).isDisplayed();
    }
}

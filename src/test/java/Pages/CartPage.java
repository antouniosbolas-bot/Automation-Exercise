package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class CartPage {
    WebDriver driver;


    By SubscriptionLocator = By.xpath("//h2[text()='Subscription']");
    String ExpectedSubscriptionTitle = "SUBSCRIPTION";
    By SubscriptionTextBox = By.cssSelector("input[id=\"susbscribe_email\"]");
    By SubscribtionBtn = By.cssSelector("button[id=\"subscribe\"]");
    By SubscriptionSuccessMessageLocator = By.cssSelector("div[class=\"alert-success alert\"]");
    String ExpectedSubscriptionSuccessMessage = "You have been successfully subscribed!";
    By CartRowsLocator = By.cssSelector("#cart_info_table tbody tr");
    By DeleteBtnLocator = By.className("cart_quantity_delete");
    By CheckOutBtnLocator = By.xpath("//a[@class=\"btn btn-default check_out\"]");
    By NameOfProductsLocator = By.cssSelector(".cart_description a");
    By PriceOfProductsLocator = By.cssSelector(".cart_price>p");
    By QuantityOfProductsLocator = By.cssSelector(".cart_quantity button");
    By TotalPriceLocator = By.cssSelector(".cart_total>p");
    By CartPageTitile = By.cssSelector("li[class=\"active\"]");
    By LoginLinkLocator = By.cssSelector("a[href=\"/login\"] u");








    public CartPage(WebDriver driver){
        this.driver = driver;

    }
    public List<String> getProductsNames(){
        List<String> productsNamesList = new ArrayList<>();
        List<WebElement> products = driver.findElements(NameOfProductsLocator);
        for (WebElement product : products){
            productsNamesList.add(product.getText());
        }
        return productsNamesList;
    }
    public String getTotalPrice(String name){
        for (WebElement row : driver.findElements(CartRowsLocator)){
            if (row.findElement(NameOfProductsLocator).getText().equals(name)){
                return row.findElement(TotalPriceLocator).getText();
            }

        }
        return null;
    }
    public int getQuantity(String productname){
        for (WebElement row : driver.findElements(CartRowsLocator)){
            if (row.findElement(NameOfProductsLocator).getText().equals(productname)){
                // return Integer.parseInt(row.findElement(QuantityOfProductsLocator).getAttribute("value").trim());
                String QuantityText = row.findElement(QuantityOfProductsLocator).getText().trim();
                return Integer.parseInt(QuantityText);
            }
        }
        return 0;
    }
    public String getPrice(String productname){
        for (WebElement row : driver.findElements(CartRowsLocator)){
            if (row.findElement(NameOfProductsLocator).getText().equals(productname)){
                return row.findElement(PriceOfProductsLocator).getText();
            }
        }
        return null;
    }








public int getCartItemsNum(){
    return driver.findElements(CartRowsLocator).size();
}

public void ClickOnDeleteBtn(String nameOfProduct){
 List<WebElement> Rows = driver.findElements(CartRowsLocator);
 for (WebElement row : Rows){
     if(row.getText().contains(nameOfProduct)){
         row.findElement(DeleteBtnLocator).click();
         break;
     }
 }

}
public boolean IsProductDeleted(String name){
    return driver.findElements(By.xpath("//a[(text()='"+name+"')]")).isEmpty();
}



public CheckOutPage ClickOnCheckOutBtn(){
    driver.findElement(CheckOutBtnLocator).click();
    return new CheckOutPage(driver);


}
    public void EnterSubscriptionEmail(String email){
        driver.findElement(SubscriptionTextBox).sendKeys(email);
    }
    public void ClickOnSubscriptionBtn(){
        driver.findElement(SubscribtionBtn).click();
    }
    public String getExpectedSubscriptionSuccessMessage(){
        return ExpectedSubscriptionSuccessMessage;
    }
    public String getActualSubscriptionSuccessMessage(){
        return driver.findElement(SubscriptionSuccessMessageLocator).getText();
    }
    public String getExpectedSubscriptionTitle(){
        return ExpectedSubscriptionTitle;
    }
    public String getActualSubscriptionTitle(){
        return driver.findElement(SubscriptionLocator).getText();
    }
    public boolean CartPageIsntEmpty(){
        return driver.findElements(CartRowsLocator).isEmpty();
    }
    public boolean isCartPageTitleDisplayed(){
        return driver.findElement(CartPageTitile).isDisplayed();
    }
    public LoginPage ClickOnLoginLink(){
        driver.findElement(LoginLinkLocator).click();
        return new LoginPage(driver);
    }




}


















/*
    public List<WebElement> ClickonDelete(String nameOfProduct) {
        WebElement deleteBtn = null;

        List<WebElement> Products = driver.findElements(By.id("cart_info_table"));

        for (WebElement product : Products) {
            if (product.getText().contains(nameOfProduct)) {
                deleteBtn = product.findElement(DeletBtnLocator);
                break;

            }
        }

        if (deleteBtn != null) {
            deleteBtn.click();
        }
        return Products;
        }

*/


package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BrandsPage {
    WebDriver driver;
    WebDriverWait wait;



    public BrandsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    By ActualTitleLocator = By.cssSelector("h2[class=\"title text-center\"]");
    String ExpectedTitle = "Brand - Polo Products";
    By AddToCartBtnS = By.className("add-to-cart");
    By ViewProductBtnS = By.xpath("//a[contains(text(), 'View Product')]");
    By ContinueShoppingBtns = By.xpath("//button[text()='Continue Shopping']");
    By ViewCartLink = By.linkText("View Cart");
    By NameOfProductsLocator = By.cssSelector("div[class='productinfo text-center'] p");
    By ProductItemes= By.cssSelector("div[class=\"product-image-wrapper\"]");
    By ActualBrandTitleLocator = By.cssSelector("h2[class=\"title text-center\"]");
    String ExpectedBrandTitle = "BRAND - ALLEN SOLLY JUNIOR PRODUCTS";

    public CartPage getViewCartLink(){
        wait.until(ExpectedConditions.elementToBeClickable(ViewCartLink)).click();
        return new CartPage(driver);

    }
    public String getExpectedTitle(){
        return ExpectedTitle;
    }
    public String getActualTitle(){
        return driver.findElement(ActualTitleLocator).getText();
    }
    public boolean isTitleDisplayed() {
        return driver.findElement(ActualTitleLocator).isDisplayed();
    }
    public ProductDeteilsPage ClickOnViewProductsByName(String productName){
        for (WebElement product : getAllProducts()){
            if (product.findElement(NameOfProductsLocator).getText().equals(productName)){
                product.findElement(ViewProductBtnS).click();

                return new ProductDeteilsPage(driver);

            }
        }
        return null;

    }
    public void getContinueShoppingBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(ContinueShoppingBtns)).click();
    }


    public List<WebElement> getAllProducts(){
        return driver.findElements(ProductItemes);
    }
    public void ClickOnAddToCartByName(String productName){
        for (WebElement product : getAllProducts()){
            if (product.findElement(NameOfProductsLocator).getText().equals(productName)){
                product.findElement(AddToCartBtnS).click();
                break;
            }
        }
    }
    public List<String> getAllProductsNames(){
        List<WebElement> Products = driver.findElements(NameOfProductsLocator);
        List<String> productsNames = new ArrayList<>();
        for (WebElement product :Products ){
            productsNames.add(product.getText().trim());
        }
        return productsNames;
    }
    public String getActualBrandTitle(){
        return driver.findElement(ActualBrandTitleLocator).getText();
    }
    public String getExpectedBrandTitle(){
        return ExpectedBrandTitle;
    }
    public boolean isBrandTitleDisplayed(){
        return driver.findElement(ActualBrandTitleLocator).isDisplayed();
    }







}




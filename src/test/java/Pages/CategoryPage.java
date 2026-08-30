package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class CategoryPage {
    WebDriver driver;
    WebDriverWait wait;

    public CategoryPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    By TiteleLocator = By.xpath("//h2[contains(text(),\"Women - Dress Products\")]");
    By Titele2Loc = By.cssSelector("h2[class=\"title text-center\"]");
    String ExpectedTitle2 = "MEN - TSHIRTS PRODUCTS";
    String ExpectedTitle = "WOMEN - DRESS PRODUCTS";
    By AddToCartBtnS = By.className("add-to-cart");
    By ViewProductBtnS = By.xpath("//a[contains(text(), 'View Product')]");
    By ContinueShoppingBtns = By.xpath("//button[text()='Continue Shopping']");
    By ViewCartLink = By.linkText("View Cart");
    By NameOfProductsLocator = By.cssSelector("div[class='productinfo text-center'] p");
    By ProductItemes= By.cssSelector("div[class=\"product-image-wrapper\"]");
    By WomenProductsLocator = By.cssSelector("#Women .panel-body li a");
    By MenProductsLocator = By.cssSelector("#Men .panel-body li a");
    By KidsProductsLocator = By.cssSelector("#Kids .panel-body li a");
    By BrandsListLocator = By.cssSelector(".nav-stacked a");

    public CartPage getViewCartLink(){
        wait.until(ExpectedConditions.elementToBeClickable(ViewCartLink)).click();
        return new CartPage(driver);

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


    public String getExpectedTitle(){
        return ExpectedTitle;
    }
    public String getActualTitle(){
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(TiteleLocator))).getText();
    }
    public boolean isTitleDisplayed() {
//        WebElement Titele = driver.findElement(TiteleLocator).isDisplayed();
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(TiteleLocator))).isDisplayed();
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

  public void clickCategory(String name){
      wait.until(ExpectedConditions.elementToBeClickable(
              By.xpath("//a[@href='#" + name + "']"))).click();

  }
    public CategoryPage clickSubCategory( String sub){
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(" //a[contains(text(),'" + sub + "')]"))).click();

        return new CategoryPage(driver);
    }

    public String getTitle2(){
        return driver.findElement(Titele2Loc).getText();
    }
    public String getExpectedTitle2(){
        return ExpectedTitle2;
    }
    public List<String> getAllProductsNames() {
        List<WebElement> Products = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(NameOfProductsLocator));
        List<String> productsNames = new ArrayList<>();
        for (WebElement product : Products) {
            productsNames.add(product.getText().trim());
        }
        return productsNames;
    }

}








































/*
public List<String> getAllProductsNames(){
    List<WebElement> Products = driver.findElements(NameOfProductsLocator);
    List<String> productsNames = new ArrayList<>();
    for (WebElement product :Products ){
        productsNames.add(product.getText().trim());
    }
    return productsNames;
}
*/
  /*  public void ClickOnCategory(String nameOfCategory){

        switch (nameOfCategory.toLowerCase()){
            case "women":
                driver.findElement(WomenProductsLocator).click();
                break;
            case "men":
                driver.findElement(MenProductsLocator).click();
                break;
            case "kids":
                driver.findElement(KidsProductsLocator).click();
                break;
            default:
                throw new IllegalArgumentException("Invalid category name: " + nameOfCategory);
        }

    }

    public CategoryPage ClickOnSubCategory(String categoryName,String subcategoryName) {
        List<WebElement> elemnts;
        switch (categoryName.toLowerCase()) {
            case "women":
                elemnts = driver.findElements(WomenProductsLocator);
                break;
            case "men":
                elemnts = driver.findElements(MenProductsLocator);
                break;
            case "kids":
                elemnts = driver.findElements(KidsProductsLocator);
                break;
            default:
                throw new IllegalArgumentException("Invalid category name: " + categoryName);
        }
        for (WebElement element : elemnts) {
            if (element.getText().trim().equals(subcategoryName)) {
                element.click();
                break;
            }
        }
        return new CategoryPage(driver);


    }*/
/*public List<String> getAllBrands(){
    List<WebElement> brands = driver.findElements(BrandsListLocator);
    List<String> brandsNames = new ArrayList<>();
    for (WebElement brand : brands){
        brandsNames.add(brand.getText().trim());
    }
    return brandsNames;
}
public void ClickOnBrand(String brandName){
    List<WebElement> brands = driver.findElements(BrandsListLocator);
    for (WebElement brand : brands){
        if (brand.getText().trim().equals(brandName)){
            brand.click();
            break;
        }
    }
}*/




package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static org.openqa.selenium.By.*;

public class ProductsPage {
    WebDriver driver;
    WebDriverWait wait;


    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    // By ActualTitleLocator = By.cssSelector("h2[class=\"title text-center\"]");
    String ExpectedTitle = "ALL PRODUCTS";
    By AllProductsTitleLocator = By.xpath("//h2[text()='All Products']");
    By ProductItemes = By.cssSelector("div[class=\"product-image-wrapper\"]");
    By PriceOfProductsLocator = By.xpath("//h2[contains(text(),'Rs.')]");
    By NameOfProductsLocator = By.cssSelector("div[class='productinfo text-center'] p");
    By AddToCartBtnS = By.className("add-to-cart");
    By ViewProductBtnS = By.xpath("//a[contains(text(), 'View Product')]");
    By ContinueShoppingBtns = By.xpath("//button[text()='Continue Shopping']");
    By ViewCartLink = By.linkText("View Cart");
    /* By CategorySideWomenLocator = By.cssSelector("a[href='#Women']");
     By CategorySideMenLocator = By.xpath("//a[@href='#Men']");
     By CategorySideKidsLocator = By.xpath("//a[@href='#Kids']");*/
    By WomenProductsLocator = By.cssSelector("#Women .panel-body li a");
    By MenProductsLocator = By.cssSelector("#Men .panel-body li a");
    By KidsProductsLocator = By.cssSelector("#Kids .panel-body li a");
    By BrandsListLocator = By.cssSelector(".nav-stacked a");
    By SearchLocator = By.cssSelector("input[id=\"search_product\"]");
    By SearchBtnLocator = By.cssSelector("button[id=\"submit_search\"]");
    By ActualSearchResultLocator = By.xpath("//h2[@class=\"title text-center\"]");
    String ExpectedSearchResult = "SEARCHED PRODUCTS";
    By BrandsSideLocator = By.cssSelector("div[class=\"brands_products\"]");
    By SubscriptionTextBox = By.cssSelector("input[id=\"susbscribe_email\"]");
    By SubscribtionBtn = By.cssSelector("button[id=\"subscribe\"]");




    public String getExpectedTitle() {
        return ExpectedTitle;
    }

    public String getActualTitle() {
        return driver.findElement(AllProductsTitleLocator).getText();
    }


    public boolean isAllProductsTitleDisplayed() {
        return driver.findElement(AllProductsTitleLocator).isDisplayed();
    }

    public List<WebElement> getAllProducts() {
        return driver.findElements(ProductItemes);
    }

    public int getAllProductsCount() {
        return driver.findElements(ProductItemes).size();
    }


    public List<String> getAllProductsNames() {
        List<WebElement> Products = driver.findElements(NameOfProductsLocator);
        List<String> productsNames = new ArrayList<>();
        for (WebElement product : Products) {
            productsNames.add(product.getText().trim());
        }
        return productsNames;
    }


    public List<String> getAllProductsPrices() {
        List<WebElement> productsPrices = driver.findElements(PriceOfProductsLocator);
        List<String> productsPricesList = new ArrayList<>();
        for (WebElement product : productsPrices) {
            productsPricesList.add(product.getText().trim());
        }
        return productsPricesList;
    }

    public void getContinueShoppingBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(ContinueShoppingBtns)).click();
    }

    public CartPage getViewCartLink() {
        wait.until(ExpectedConditions.elementToBeClickable(ViewCartLink)).click();
        return new CartPage(driver);

    }

    public ProductDeteilsPage ClickOnViewProductsByName(String productName) {
        for (WebElement product : getAllProducts()) {
            if (product.findElement(NameOfProductsLocator).getText().equals(productName)) {
                product.findElement(ViewProductBtnS).click();

                return new ProductDeteilsPage(driver);

            }
        }
        return null;

    }

    public void ClickOnAddToCartByName(String productName) {
        for (WebElement product : getAllProducts()) {
            if (product.findElement(NameOfProductsLocator).getText().equals(productName)) {
               wait.until(ExpectedConditions.presenceOfElementLocated((AddToCartBtnS))).click();
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



   public BrandsPage clickBrand(String brandName) {
       wait.until(ExpectedConditions.elementToBeClickable(
               By.xpath("//div[@class='brands_products']//a[contains(.,'" + brandName + "')]"))).click();

       return new BrandsPage(driver);
   }

    public String getActualSearchResult() {
        return driver.findElement(ActualSearchResultLocator).getText();
    }

    public String getExpectedSearchResult() {
        return ExpectedSearchResult;
    }

    public void ClickOnSearchClickBtn() {
        driver.findElement(SearchBtnLocator).click();

    }

    public void ClickOnSearch(String product) {
        driver.findElement(SearchLocator).sendKeys(product);
    }

    public boolean isBrandsSideDisplayed() {
        return driver.findElement(BrandsSideLocator).isDisplayed();


    }
    public void EnterSubscriptionEmail(String email){
        driver.findElement(SubscriptionTextBox).sendKeys(email);
    }
    public void ClickOnSubscriptionBtn(){
        wait.until(ExpectedConditions.presenceOfElementLocated(SubscribtionBtn)).click();
    }
}
















































/*

    By AllProductsLocator = By.cssSelector("div[class='single-products']");
    By AllProductsNamesLocator = By.cssSelector("div[class='single-products'] h2");
    By AllProductsPricesLocator = By.cssSelector("div[class='single-products'] p");

    By ProductOneLocator = By.xpath("//div[@class='single-products'][1]");
    By NameOfProductLocator =By.xpath("//h2[contains(text(), 'Blue Top')]");
    By CategoryOfProductLocator = By.xpath("//p[contains(text(),'Category')]");
    By PriceOfProductLocator =By.xpath("//span[text()='Rs. 500']");
   // By AvailabilityOfProductLocator = By.xpath("//p[contains(text(),'Availability')]");
    By ConditionOfProductLocator = By.xpath("//p[b[text()='Condition:']]");
    By BrandOfProductLocator = By.xpath("//p[b[text()='Brand:']]");
    By NameOfProduct1locator = By.xpath("//p[text()='Blue Top']");








    // CategorySide
    By CategorySideWomenLocator = By.cssSelector("a[href='#Women']");
    By CategorySideMenLocator = xpath("//a[@href='#Men']");
    By CategorySideKidsLocator = xpath("//a[@href='#Kids']");




    // BrandsSide
    By Brandslist = By.cssSelector("div[class='brands_products'] li>a");
By BrandsSidePOLOLocator = xpath("//a[@href=\"/brand_products/Polo\"]");
By BrandsSideHMlocator = xpath("//a[@href=\"/brand_products/H&M\"]");
By BrandsSideMADAMElocator= xpath("//a[@href=\"/brand_products/Madame\"]");
By BrandsSideMASTlocator = xpath("//a[@href=\"/brand_products/Mast & Harbour\"]");
By BrandsSideBabyhuglocator = xpath("//a[@href=\"/brand_products/Babyhug\"]");
By AllenSollyJuniorLocator = xpath("//a[@href=\"/brand_products/Allen Solly Junior\"]");
By KookieKidsLocator = xpath("//a[@href=\"/brand_products/Kookie Kids\"]");
By BIBALocator = By.cssSelector("a[href=\"/brand_products/Biba\"]");

By AddToCartBtn = By.cssSelector("a[data-product-id=\"1\"]");
By ViewProductBtn =By.xpath("//a[@href='/product_details/1']");
By ContinueShoppingBtn = By.cssSelector("button[class=\"btn btn-success close-modal btn-block\"]");
By ViewCart = By.linkText("View Cart");



public void ClickOnProductOne(){
    driver.findElement(ProductOneLocator).click();
}




    public boolean isActualTitleDisplayed() {
        return driver.findElement(ActualTitleLocator).isDisplayed();
    }

public void ClickOnAddToCartBtn(){
  driver.findElement(AddToCartBtn).click();
}
public void ClickOnViewProduct(){
    driver.findElement(ViewProductBtn).click();

}
public void ClickOnContinueShoppingBtn(){
    driver.findElement(ContinueShoppingBtn).click();
}
public CartPage ClickOnViewCartLink(){
   wait.until(ExpectedConditions.elementToBeClickable(ViewCart)).click();
    return new CartPage(driver);
}

public void ClickOnWomenSide(){
    driver.findElement(CategorySideWomenLocator).click();
}
    public void ClickOnMenSide(){
        driver.findElement(CategorySideMenLocator).click();
    }
    public void ClickOnKidsSide(){
        driver.findElement(CategorySideKidsLocator).click();
    }

    public void clickCategory(String categoryName) {
        driver.findElement(xpath("//a[@href='#" + categoryName + "']")).click();
    }




*/
/*    public List<String> getAllBrands(){
        List<WebElement> all_products = driver.findElements(By.xpath("//div[@class=\"single-products\"]"));
    Brands = driver.findElements(Brandslist);
    List<String> BrandsNames = new ArrayList<>();
    for (WebElement brand : Brands){
        BrandsNames.add(brand.getText().trim());

    }
    return BrandsNames;

 //   Brands.get(4).click();

}*//*



public void ClickOnPOLOside(){
    driver.findElement(BrandsSidePOLOLocator).click();
}
    public void ClickOnHMside(){
        driver.findElement(BrandsSideHMlocator).click();

    }
    public void ClickOnMADAMEside(){
        driver.findElement(BrandsSideMADAMElocator).click();

    }
    public void ClickOnMASTside(){
        driver.findElement(BrandsSideMASTlocator).click();

    }
    public void ClickOnBabyhugside(){
        driver.findElement(BrandsSideBabyhuglocator).click();
    }
    public void ClickOnAllenSollyJuniorside(){
        driver.findElement(AllenSollyJuniorLocator).click();
    }
    public void ClickOnKookieKidsside(){
        driver.findElement(KookieKidsLocator).click();
    }
    public void ClickOnBIBAside(){
        driver.findElement(BIBALocator).click();
    }


    public void clickBrandByName(String brandName) {
        driver.findElement(By.linkText(brandName)).click();
    }

    public String getNameOfProduct(){
        return driver.findElement(NameOfProductLocator).getText();


    }
    public String getCategoryOfProduct(){
        return driver.findElement(CategoryOfProductLocator).getText();
    }
    public String getPriceOfProduct(){
        return driver.findElement(PriceOfProductLocator).getText();
    }
    public String getConditionOfProduct(){
        return driver.findElement(ConditionOfProductLocator).getText();
    }
    public String getBrandOfProduct(){
        return driver.findElement(BrandOfProductLocator).getText();
    }
    /*        List<String> categoryNames = new ArrayList<>();
        for (WebElement element : elemnts){
            categoryNames.add(element.getText().trim());

        }
        return categoryNames;*/



 /*public void ClickOnCategory(String nameOfCategory) {

        switch (nameOfCategory.toLowerCase()) {
            case "women":
                driver.findElement(WomenProductsLocator).click();

            case "men":
                driver.findElement(MenProductsLocator).click();

            case "kids":
                driver.findElement(KidsProductsLocator).click();

            default:
                throw new IllegalArgumentException("Invalid category name: " + nameOfCategory);
        }

    }

    public CategoryPage ClickOnSubCategory(String categoryName, String subcategoryName) {

        ClickOnCategory(categoryName);
        List<WebElement> elemnts = driver.findElements(WomenProductsLocator);

        for (WebElement element : elemnts) {
            if (element.getText().trim().equals(subcategoryName)) {
                element.click();

            }
        }
        return new CategoryPage(driver);


    }*/

   /* public List<String> getAllBrands() {
        List<WebElement> brands = driver.findElements(BrandsListLocator);
        List<String> brandsNames = new ArrayList<>();
        for (WebElement brand : brands) {
            brandsNames.add(brand.getText().trim());
        }
        return brandsNames;
    }

    public BrandsPage ClickOnBrand(String brandName) {
        List<WebElement> brands = driver.findElements(BrandsListLocator);
        for (WebElement brand : brands) {
            if (brand.getText().trim().equals(brandName)) {
                brand.click();

            }
        }
        return new BrandsPage(driver);
    }*/
 /*By WomenSubCategories = By.cssSelector("#Women .panel-body li a");
    By MenSubCategories = By.cssSelector("#Men .panel-body li a");
    By KidsSubCategories = By.cssSelector("#Kids .panel-body li a");*/











package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.By.cssSelector;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    By ProductItemes= By.cssSelector("div[class=\"product-image-wrapper\"]");
    By ProductsPageLinkLocator = By.xpath("//a[@href=\"/products\"]");
    By CartPageLinkLocator =By.xpath("//a[@href=\"/view_cart\"]");
    By LoginPageLinkLocator = cssSelector("a[href=\"/login\"]");
    By DeleteAccountBtn = cssSelector("a[href=\"/delete_account\"]");
    By LogoutBtn = cssSelector("a[href=\"/logout\"]");
    //b[contains(text(),'antounios')]
    By ContactUsLocator = cssSelector("a[href=\"/contact_us\"]");
    By UserNameText = By.xpath("//a[contains(text(), 'Logged in as')]");
    String ExpectedUserName="Logged in as Team2 ";
    By TestCasesLocator = cssSelector("a[href=\"/test_cases\"]");
    By SubscriptionLocator = By.xpath("//h2[text()='Subscription']");
    String ExpectedSubscriptionTitle = "SUBSCRIPTION";
    By SubscriptionTextBox = By.cssSelector("input[id=\"susbscribe_email\"]");
    By SubscribtionBtn = By.cssSelector("button[id=\"subscribe\"]");
    By SubscriptionSuccessMessageLocator = By.cssSelector("div[class=\"alert-success alert\"]");
    String ExpectedSubscriptionSuccessMessage = "You have been successfully subscribed!";
    By ViewProductBtn =By.xpath("//a[@href='/product_details/1']");
    By MainTitelLocator = By.xpath("//h2[contains(text(), \"Features\")]");
    By NameOfProductsLocator = By.cssSelector("div[class='productinfo text-center'] p");
    By ViewProductBtnS = By.xpath("//a[contains(text(), 'View Product')]");
    By AddToCartBtnS = By.cssSelector("a[class=\"btn btn-default add-to-cart\"]");
    By ContinueShoppingBtns = By.xpath("//button[text()='Continue Shopping']");
    By CategorySideLocator = By.cssSelector("div[class=\"panel-group category-products\"]");
   /* By WomenProductsLocator = By.cssSelector("#Women .panel-body li a");
    By MenProductsLocator = By.cssSelector("#Men .panel-body li a");
    By KidsProductsLocator = By.cssSelector("#Kids .panel-body li a");
    By WomenCategoryLocator = By.xpath("//a[@href='#Women']");
    By MenCategoryLocator = By.xpath("//a[@href='#Men']");
    By KidsCategoryLocator = By.xpath("//a[@href='#Kids']");*/
    By BrandsListLocator = By.cssSelector(".nav-stacked a");
    By BrandsSideLocator = By.cssSelector("div[class=\"brands_products\"]");
    By RecommendedItemsLocator = By.xpath("//h2[text()='recommended items']");
    By ViewCartLink = By.linkText("View Cart");
    By ScrollUpArrowLocator = By.cssSelector("a[id=\"scrollUp\"]");
    By TiteleHomePage = By.xpath("//h2[text()='Full-Fledged practice website for Automation Engineers']");
    By HomeLocator = By.cssSelector("a[href=\"/\"]");
    By PriceOfProductsLocator = By.xpath("//h2[contains(text(),'Rs.')]");











    public boolean isCategorySideDisplayed(){
        return driver.findElement(CategorySideLocator).isDisplayed();
    }

    public boolean isMainTitleDisplayed(){
        return driver.findElement(MainTitelLocator).isDisplayed();
    }
    public List<WebElement> getAllProducts(){
        return driver.findElements(ProductItemes);
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
    public void ClickOnAddToCartByName(String productName){
        for (WebElement product : getAllProducts()){
            if (product.findElement(NameOfProductsLocator).getText().equals(productName)){
                product.findElement(AddToCartBtnS).click();
                break;
            }
        }
    }

    public String getExpectedUserName(){
        return ExpectedUserName.trim();
    }
    public String getActualUserName(){
        return driver.findElement(UserNameText).getText().trim();
    }
    public boolean isUserNameDisplayed(){
        return driver.findElement(UserNameText).isDisplayed();
    }



    public ProductsPage ClickOnProductsPageLink(){
        driver.findElement(ProductsPageLinkLocator).click();
        return new ProductsPage(driver);


    }
    public CartPage ClickOnCartPageLink(){
        driver.findElement(CartPageLinkLocator).click();
        return new CartPage(driver);

    }
    public LoginPage ClickOnLoginPageLink(){
        driver.findElement(LoginPageLinkLocator).click();
        return new LoginPage(driver);
    }
    public AccountDeletedPage ClickOnDeleteAccountBtn(){
        driver.findElement(DeleteAccountBtn).click();
        return new AccountDeletedPage(driver);
    }
    public LoginPage ClickOnLogout(){
        driver.findElement(LogoutBtn).click();
        return new LoginPage(driver);
    }
    public ContactUsPage ClickOnContactUs(){
        driver.findElement(ContactUsLocator).click();
        return new ContactUsPage(driver);
    }
    public TestCasesPage ClickOnTestCases(){
        driver.findElement(TestCasesLocator).click();
        return new TestCasesPage(driver);
    }
    public String getExpectedSubscriptionTitle(){
        return ExpectedSubscriptionTitle;
    }
    public String getActualSubscriptionTitle(){
        return driver.findElement(SubscriptionLocator).getText();
    }
    public boolean isSubscriptionTitleDisplayed(){
        return driver.findElement(SubscriptionLocator).isDisplayed();
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
    public void ClickOnViewProduct() {
        driver.findElement(ViewProductBtn).click();
    }
    public void getContinueShoppingBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(ContinueShoppingBtns)).click();
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




    public boolean isBrandsSideDisplayed(){
        return driver.findElement(BrandsSideLocator).isDisplayed();
    }
    public boolean isRecommendedItemsDisplayed(){
        return driver.findElement(RecommendedItemsLocator).isDisplayed();
    }
    public CartPage getViewCartLink() {
        wait.until(ExpectedConditions.elementToBeClickable(ViewCartLink)).click();
        return new CartPage(driver);

    }
    public void ClickOnScrollUpArrow(){
        wait.until(ExpectedConditions.elementToBeClickable(ScrollUpArrowLocator)).click();
    }

    public boolean isTitleHomePageDisplayed(){
        return driver.findElement(TiteleHomePage).isDisplayed();
    }
    public HomePage ClickOnHome(){
        driver.findElement(HomeLocator).click();
        return new HomePage(driver);
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
    public boolean IsLogidInDisplayd(){
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(UserNameText))).isDisplayed();
    }

}

















































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



/*public void ClickOnCategory(String nameOfCategory){

        switch (nameOfCategory.toLowerCase()){
            case "women":
                wait.until(ExpectedConditions.elementToBeClickable(WomenCategoryLocator)).click();
                break;
            case "men":
                wait.until(ExpectedConditions.elementToBeClickable(MenCategoryLocator)).click();
                break;
            case "kids":
                wait.until(ExpectedConditions.elementToBeClickable(KidsCategoryLocator)).click();
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
              wait.until(ExpectedConditions.elementToBeClickable(element)).click();
                break;
            }
        }
        return new CategoryPage(driver);


    }*/

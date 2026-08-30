
package StepDifinitions;

import HooksPackage.Hooks;
import Pages.CartPage;
import Pages.HomePage;
import Pages.ProductsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.List;

public class Cart_StepDif {
    HomePage homePage;
    ProductsPage productsPage;
    CartPage cartPage;


    @Given("I have added a product to cart")
    public void I_have_added_a_product_to_cart(){
        homePage=new HomePage (Hooks.driver);
        productsPage=homePage.ClickOnProductsPageLink();
        productsPage.EnterSubscriptionEmail("sdfghhhj");
        productsPage.ClickOnSubscriptionBtn();
        productsPage.ClickOnAddToCartByName("Blue Top");
        cartPage=productsPage.getViewCartLink();

    }
    @When("I go to Cart page")
    public void iGoToCartPage() {

        Assert.assertTrue(cartPage.isCartPageTitleDisplayed());

    }

    @Then("I should see the product listed with description, price, quantity and total")
    public void iShouldSeeTheProductListedWithDescriptionPriceQuantityAndTotal() {
        List<String> actualNames = cartPage.getProductsNames();
        int actualQuantity = cartPage.getQuantity("Blue Top");
        String actualPrice = cartPage.getPrice("Blue Top");
        String actualTotalPrice = cartPage.getTotalPrice("Blue Top");

        Assert.assertTrue(actualNames.contains("Blue Top"));
        Assert.assertTrue(actualQuantity==1);
        Assert.assertTrue(actualPrice.contains("500"));
        Assert.assertTrue(actualTotalPrice.contains("500"));

    }


    @When("I remove a product")
    public void iRemoveAProduct() {
        cartPage.ClickOnDeleteBtn("Blue Top");
    }

    @Then("the product should no longer appear in the cart")
    public void theProductShouldNoLongerAppearInTheCart() {
        Assert.assertFalse(cartPage.IsProductDeleted("Blue Top"));
    }
}

package StepDifinitions;

import HooksPackage.Hooks;
import Pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class Checkout_payment_StepDif {
    HomePage homePage;
    CartPage cartPage;
    ProductsPage productsPage;
    LoginPage loginPage;
    CheckOutPage checkOutPage;
    PaymentPage paymentPage;
    FillingDataPage filingDataPage;
    AccountCreatedPage accountCreatedPage;
    PaymentDonePage paymentDonePage;


@Given("I am logged in and have items In cart")
    public void I_am_logged_in_and_have_items_In_cart(){
    homePage = new HomePage(Hooks.driver);
    loginPage=homePage.ClickOnLoginPageLink();
    loginPage.EnterLoginEmail("team2@gmail.com");
    loginPage.EnterLoginPassword("Team2@123");
    homePage=loginPage.ClickOnLginBtn();
    Assert.assertTrue(homePage.IsLogidInDisplayd());
    homePage.ClickOnAddToCartByName("Blue Top");
    homePage.getContinueShoppingBtn();
    cartPage=homePage.ClickOnCartPageLink();
  }

    @When("I proceed to Checkout")
    public void iProceedToCheckout() {
   checkOutPage =cartPage.ClickOnCheckOutBtn();
    }

    @Then("I should see address details and order review")
    public void iShouldSeeAddressDetailsAndOrderReview() {
    Assert.assertTrue(checkOutPage.IsOnCheckOutPage());
    Assert.assertTrue(checkOutPage.IsDelivaryAddressTextDisplayed());
        Assert.assertTrue(checkOutPage.IsBillingAddressTextDisplayed());

    }

    @And("I should be able to Add comment and place Order and redirect to payment page")
    public void iShouldBeAbleToAddCommentAndPlaceOrderAndRedirectToPaymentPage() {
    checkOutPage.AddComment("OK");
    paymentPage=checkOutPage.ClickOnPlaceOrderBtn();
    Assert.assertTrue(paymentPage.IsOnPaymentPage());

    }

    @Given("I am a new user with items in cart")
    public void iAmANewUserWithItemsInCart() {
        homePage.ClickOnAddToCartByName("Blue Top");
        homePage.getContinueShoppingBtn();
        cartPage=homePage.ClickOnCartPageLink();
}

    @When("I register at Checkout and fill payment details")
    public void iRegisterAtCheckoutAndFillPaymentDetails() {
    cartPage.ClickOnCheckOutBtn();
        loginPage=cartPage.ClickOnLoginLink();
        loginPage.EnterSignupName("Team2");
        loginPage.EnterSignupName("Team2");
        loginPage.EnterSignupEmail("team2@gmail.coomoomommooooomo");
        filingDataPage=loginPage.ClickOnSignup();
        filingDataPage.ClickOnMr();
        filingDataPage.EnterPassword("Team2@123");
        filingDataPage.SelectDays(21);
        filingDataPage.SelectMonth(7);
        filingDataPage.SelectYear("2006");
        filingDataPage.ClickOnSign_up_for_our_newsletter();
        filingDataPage.ClickOnReceive_special_offers_from_our_partners();
        filingDataPage.EnterFirstName("Team2");
        filingDataPage.EnterLastName("Team2");
        filingDataPage.EnterCompany("Amit");
        filingDataPage.EnterAdressOne("Cairo");
        filingDataPage.EnterAdressTwo("Ramses");
        filingDataPage.SelectYourCuntry("India");
        filingDataPage.EnterYourState("KafrElShiekh");
        filingDataPage.EnteryourCity("Sila El Gharbia");
        filingDataPage.EnterYourZipCode("10001");
        filingDataPage.EnterYourPhone("01284453186");
        accountCreatedPage=filingDataPage.ClickOnCreateAccount();
        homePage=accountCreatedPage.ClickOnContinueBtn();
        Assert.assertTrue(homePage.isUserNameDisplayed());
        cartPage=homePage.ClickOnCartPageLink();
        checkOutPage=cartPage.ClickOnCheckOutBtn();
        Assert.assertEquals(checkOutPage.getExpectedResultTest(),checkOutPage.getActualResultText());
        checkOutPage.AddComment("product is sooooo good ");
        paymentPage=checkOutPage.ClickOnPlaceOrderBtn();
        paymentPage.SendNameOnCard("We are Team2");
        paymentPage.SendNumberOnCard("012844531861234");
        paymentPage.SendCVC("123");
        paymentPage.SendMonth("12");
        paymentPage.SendYear("2039");
        paymentDonePage=paymentPage.ClickOnConfirmOrder();


    }

    @Then("the order should be placed successfully and Download Invoice")
    public void theOrderShouldBePlacedSuccessfully(){
    Assert.assertTrue(paymentDonePage.IsOrderPlaced());
    paymentDonePage.ClickOnDownloadBtn();
    homePage=paymentDonePage.ClickOnContinueBtn();
    }

    @Given("I have registered and logged in")
    public void iHaveRegisteredAndLoggedIn() {
    loginPage=homePage.ClickOnLoginPageLink();
        loginPage.EnterSignupName("Team2");
        loginPage.EnterSignupName("Team2");
        loginPage.EnterSignupEmail("team2@gmail.coommnnoooooomo");
        filingDataPage=loginPage.ClickOnSignup();
        filingDataPage.ClickOnMr();
        filingDataPage.EnterPassword("Team2@123");
        filingDataPage.SelectDays(21);
        filingDataPage.SelectMonth(7);
        filingDataPage.SelectYear("2006");
        filingDataPage.ClickOnSign_up_for_our_newsletter();
        filingDataPage.ClickOnReceive_special_offers_from_our_partners();
        filingDataPage.EnterFirstName("Team2");
        filingDataPage.EnterLastName("Team2");
        filingDataPage.EnterCompany("Amit");
        filingDataPage.EnterAdressOne("Cairo");
        filingDataPage.EnterAdressTwo("Ramses");
        filingDataPage.SelectYourCuntry("India");
        filingDataPage.EnterYourState("KafrElShiekh");
        filingDataPage.EnteryourCity("Sila El Gharbia");
        filingDataPage.EnterYourZipCode("10001");
        filingDataPage.EnterYourPhone("01284453186");
        accountCreatedPage=filingDataPage.ClickOnCreateAccount();
        homePage=accountCreatedPage.ClickOnContinueBtn();
        Assert.assertTrue(homePage.isUserNameDisplayed());

    }

    @When("I proceed to Checkout and enter payment details")
    public void iProceedToCheckoutAndEnterPaymentDetails() {
    homePage.ClickOnAddToCartByName("Blue Top");
    homePage.getContinueShoppingBtn();
        cartPage=homePage.ClickOnCartPageLink();
        checkOutPage=cartPage.ClickOnCheckOutBtn();
        checkOutPage.AddComment("OK");
        paymentPage=checkOutPage.ClickOnPlaceOrderBtn();
        paymentPage.SendNameOnCard("We are Team2");
        paymentPage.SendNumberOnCard("012844531861234");
        paymentPage.SendCVC("123");
        paymentPage.SendMonth("12");
        paymentPage.SendYear("2039");
        paymentDonePage=paymentPage.ClickOnConfirmOrder();

    }

}

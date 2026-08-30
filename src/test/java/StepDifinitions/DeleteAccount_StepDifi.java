package StepDifinitions;

import HooksPackage.Hooks;
import Pages.AccountDeletedPage;
import Pages.HomePage;
import Pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class DeleteAccount_StepDifi {
    HomePage homePage;
    LoginPage loginPage;
    AccountDeletedPage accountDeletedPage;
    @Given("I Open Home Page and looged in")
    public void I_Open_Home_Page_and_looged_in(){
        homePage = new HomePage(Hooks.driver);
        loginPage=homePage.ClickOnLoginPageLink();
        loginPage.EnterLoginEmail("team2@gmail.coomoomoooooomo");
        loginPage.EnterLoginPassword("Team2@123");
        homePage=loginPage.ClickOnLginBtn();
        Assert.assertTrue(homePage.isUserNameDisplayed());

    }

    @When("I click Delete Account Button")
    public void iClickDeleteAccountButton() {
       accountDeletedPage= homePage.ClickOnDeleteAccountBtn();

    }

    @Then("Account Deleted and Redirect To Account Deleted Page")
    public void accountDeletedAndRedirectToAccountDeletedPage() {
        Assert.assertTrue(accountDeletedPage.IsOnAccountDeletedPage());
    }
    
}

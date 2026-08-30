package StepDifinitions;

import HooksPackage.Hooks;
import Pages.ContactUsPage;
import Pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class ContactUs_StepDif {
    HomePage homePage;
    ContactUsPage contactUsPage;
    @Given("I open Contact Us page")
    public void I_open_Contact_Us_page(){
        homePage = new HomePage(Hooks.driver);
        contactUsPage=homePage.ClickOnContactUs();
        Assert.assertTrue(contactUsPage.IsONContactUs());
    }


    @When("I fill Name, Email, Subject, Message and submit")
    public void iFillNameEmailSubjectMessageAndSubmit() {
        contactUsPage.ENterUrName("Team2");
        contactUsPage.EnterUrEmail("team2@gmail.com");
        contactUsPage.EnterSubject("Team2,islam,Antounios,Mohamed,Ahmed,Maged");
        contactUsPage.EnterMSG("We are Team2");
        contactUsPage.ClickOnSubmitBtn();
        contactUsPage.AcceptAlert();

    }

    @Then("the form should be accepted or confirmation message shown")
    public void theFormShouldBeAcceptedOrConfirmationMessageShown() {
        Assert.assertTrue(contactUsPage.IsSuccessMSGDisplayd());

    }

    @Then("User should be redirected to Home Page After Click Home Button")
    public void userShouldBeRedirectedToHomePageAfterClickHomeButton() {
        homePage=contactUsPage.ClickOnHomeBtn();
        Assert.assertTrue(homePage.isTitleHomePageDisplayed());
    }
}


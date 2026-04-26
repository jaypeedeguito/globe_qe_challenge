package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountOverviewPage;

public class AccountOverviewSteps {
    /*
     ** PAGE INSTANCE **
     */

    AccountOverviewPage accountOverviewPage = new AccountOverviewPage();

    @Then("the user is navigated to the Account Overview page")
    public void the_user_is_on_the_account_overview_page() {
        accountOverviewPage.verifyPageTitle();
    }

    @When("the user sign out from the page")
    public void the_user_sign_out() {
        accountOverviewPage.clickSignOut();
    }

}
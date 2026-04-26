package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CreateAccountPage;

public class CreateAccountSteps {
    /*
     ** PAGE INSTANCE **
     */

    CreateAccountPage createAccountPage = new CreateAccountPage();

    @Then("the user is navigated to the Create Account page")
    public void the_user_is_navigated_create_account_page() {
        createAccountPage.verifyPageTitle();
    }

    @When("the user create a new account:")
    public void the_user_create_new_account(DataTable dt) {
        createAccountPage.inputCreateAccountDetails(dt);
    }

}
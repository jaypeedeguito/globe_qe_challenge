package steps;

import com.core.utility.TestDataModel;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountLoginPage;

public class AccountLoginSteps {
    /*
     ** PAGE INSTANCE **
     */

    AccountLoginPage accountLoginPage = new AccountLoginPage();

    @Given("the user is on the Account Login page")
    public void the_user_is_on_the_account_login_page() {
        accountLoginPage.navigateToSpreeEcommerceURL();
        accountLoginPage.verifyPageTitle();
    }

    @Then("the user is navigated to the Account Login page")
    public void the_user_is_navigated_login_page() {
        accountLoginPage.verifyPageTitle();
    }

    @When("the user clicks the Sign Up link")
    public void the_user_click_sign_up() {
        accountLoginPage.clickAccountIcon();
    }

    @When("the user sign in back using the new account created")
    public void the_user_sign_in() {
        accountLoginPage.signIn(TestDataModel.getEmail()
                , TestDataModel.getPassword());
    }

    @When("the user sign in with {string} {string}")
    public void the_user_sign_in_with(String email, String password) {
        accountLoginPage.signIn(email, password);
    }

}
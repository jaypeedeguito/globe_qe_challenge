package steps;

import io.cucumber.java.en.Given;
import pages.AccountLoginPage;
import pages.HomePage;

public class HomePageSteps {
    /*
     ** PAGE INSTANCE **
     */

    HomePage homePage = new HomePage();

    @Given("the user is on the Spree Store home page")
    public void the_user_is_on_the_home_page() {
        homePage.navigateToSpreeEcommerceURL();
        homePage.verifyPageTitle();
    }

//    @When("the user click sign up")
//    public void the_user_is_on_the_account_login_page() {
//        accountLoginPage.navigateToSpreeEcommerceURL();
//        accountLoginPage.verifyHomeTitle();
//    }

}
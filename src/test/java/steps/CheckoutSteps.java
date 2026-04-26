package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CheckoutPage;
import pages.ShoppingCartPage;

public class CheckoutSteps {
    /*
     ** PAGE INSTANCE **
     */

    CheckoutPage checkoutPage = new CheckoutPage();

    @Then("the user is navigated to the Checkout page")
    public void the_user_nav_checkout_account() {
        checkoutPage.verifyCheckoutPage();
    }

    @When("the user fill the shipping address details:")
    public void the_user_fill_shipping(DataTable dt) {
        checkoutPage.fillShippingAddress(dt);
    }

    @When("the user click Pay Now")
    public void the_user_click_pay_now() {
        checkoutPage.clickPayNow();
    }

    @When("the user select the Payment Method as Credit Card")
    public void the_user_click_credit_card() {
        checkoutPage.clickCreditCard();
    }

    @When("the user select the Shipping Method as Premium")
    public void the_user_click_shipping_method() {
        checkoutPage.clickPremium();
    }

    @When("the user fill the Credit Card details:")
    public void the_user_fill_credit_card(DataTable dt) {
        checkoutPage.fillCreditCardDetails(dt);
    }

}
package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ProductDetailsPage;
import pages.ShoppingCartPage;

public class ShoppingCartSteps {
    /*
     ** PAGE INSTANCE **
     */

    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();

    @Then("the user is navigated to the Shopping Cart page")
    public void the_user_nav_sho_cart_see_product_account() {
        shoppingCartPage.verifyPageTitle();
    }

    @Then("the user validates the shopping cart details:")
    public void the_user_validate_shopping_cart(DataTable dt) {
        shoppingCartPage.validateShoppingCarttDetails(dt);
    }

    @When("the user click Proceed To Checkout")
    public void the_user_click_add_to_cart() {
        shoppingCartPage.clickProceedToCheckout();
    }

}
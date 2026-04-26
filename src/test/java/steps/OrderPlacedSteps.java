package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.OrderPlacedPage;
import pages.ShoppingCartPage;

public class OrderPlacedSteps {
    /*
     ** PAGE INSTANCE **
     */

    OrderPlacedPage orderPlacedPage = new OrderPlacedPage();

    @Then("the user is able to see Order Confirmation and Order Number")
    public void the_user_nav_sho_cart_see_order_confirmation() {
        orderPlacedPage.verifySuccessMessage();
        orderPlacedPage.verifyOrderNumber();
    }

    @Then("the user validates the Order Items details:")
    public void the_user_validate_order_items_details(DataTable dt) {
        orderPlacedPage.validateOrderItemsDetails(dt);
    }

}
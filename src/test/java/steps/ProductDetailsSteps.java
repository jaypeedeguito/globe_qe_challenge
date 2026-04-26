package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AllProductsPage;
import pages.CreateAccountPage;
import pages.ProductDetailsPage;

public class ProductDetailsSteps {
    /*
     ** PAGE INSTANCE **
     */

    ProductDetailsPage productDetailsPage = new ProductDetailsPage();

    @Then("the user is able to see the product details:")
    public void the_user_able_to_see_product_account(DataTable dt) {
        productDetailsPage.validateProductDetails(dt);
    }

    @When("the user click Add To Cart button")
    public void the_user_click_add_to_cart() {
        productDetailsPage.addToCart();
    }

    @When("the user click View Cart")
    public void the_user_click_view_cart_cart() {
        productDetailsPage.clickViewCart();
    }

}
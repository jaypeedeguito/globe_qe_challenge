package steps;

import com.core.utility.TestDataModel;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountLoginPage;
import pages.AllProductsPage;

public class AllProductsSteps {
    /*
     ** PAGE INSTANCE **
     */

    AllProductsPage allProductsPage = new AllProductsPage();

    @Then("the user is navigated to the All Products page")
    public void the_user_is_navigated_all_products_page() {
        allProductsPage.verifyPageTitle();
    }

    @When("the user clicks the Product {string}")
    public void the_user_click_product(String productName) {
        allProductsPage.clickProductName(productName);
    }

}
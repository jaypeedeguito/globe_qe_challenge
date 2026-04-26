package steps;

import io.cucumber.java.en.When;
import pages.SideMenuPage;

public class SideMenuSteps {
    /*
     ** PAGE INSTANCE **
     */

    SideMenuPage sideMenuPage = new SideMenuPage();

    @When("the user clicks the All Products menu in the side menu bar")
    public void the_user_click_all_productst_icon() {
        sideMenuPage.clickAllProducts();
    }
}
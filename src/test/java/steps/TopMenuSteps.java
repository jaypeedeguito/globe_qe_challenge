package steps;

import io.cucumber.java.en.When;
import pages.TopMenuPage;

public class TopMenuSteps {
    /*
     ** PAGE INSTANCE **
     */

    TopMenuPage topMenuPage = new TopMenuPage();

    @When("the user clicks the Account icon in the top menu bar")
    public void the_user_click_account_icon() {
        topMenuPage.clickAccountIcon();
    }

    @When("the user clicks the Hamburger top menu icon in the top menu bar")
    public void the_user_click_hamburger_icon() {
        topMenuPage.clickHamburgerMenuIcon();
    }
}
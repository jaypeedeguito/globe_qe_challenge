package pages;

import com.core.utility.BasePage;
import com.microsoft.playwright.assertions.LocatorAssertions;
import locators.HomePageLocators;


import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class HomePage extends BasePage {

    public void navigateToSpreeEcommerceURL() {
        openURLInBrowser();
    }

    public void verifyPageTitle() {
        assertThat(page.get().locator(HomePageLocators.HOME_TITLE_XPATH)).containsText("Spree Storefront"
                , new LocatorAssertions.ContainsTextOptions().setTimeout(15000));
    }
}
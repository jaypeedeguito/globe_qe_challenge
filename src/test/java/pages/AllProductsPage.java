package pages;

import com.core.utility.BasePage;
import com.core.utility.TestDataModel;
import com.microsoft.playwright.assertions.LocatorAssertions;
import locators.AccountLoginLocators;
import locators.AllProductsLocators;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class AllProductsPage extends BasePage {

    public void navigateToSpreeEcommerceURL() {
        openURLInBrowser();
    }

    public void verifyPageTitle() {
//        Assert.assertTrue(page.get().isVisible(HOME_TITLE_XPATH));
        assertThat(page.get().locator(AllProductsLocators.PAGE_TITLE_XPATH)).containsText("All Products"
                , new LocatorAssertions.ContainsTextOptions().setTimeout(15000));
    }

    public void clickProductName(String product) {
        int ctr = 1;
        while (ctr <= 3) {
            ctr++;
            try {
                setClickElement(AllProductsLocators.getProductLocator(product));
                break;
            } catch (Exception e) {
            }
        }
    }
}
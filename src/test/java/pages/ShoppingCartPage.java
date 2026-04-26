package pages;

import com.core.utility.BasePage;
import com.microsoft.playwright.assertions.LocatorAssertions;
import io.cucumber.datatable.DataTable;
import locators.ShoppingCartLocators;

import java.util.List;
import java.util.Map;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ShoppingCartPage extends BasePage {

    public void verifyPageTitle() {
        assertThat(page.get().locator(ShoppingCartLocators.PAGE_TITLE_XPATH)).containsText("Shopping Cart"
                , new LocatorAssertions.ContainsTextOptions().setTimeout(15000));
    }

    public void validateShoppingCarttDetails(DataTable dt) {
        List<Map<String, String>> rows = dt.asMaps(String.class, String.class);
        String field, value;
        for (Map <String, String> columns : rows) {
            field = columns.get("field");
            value = columns.get("value");
            validateShoppingCarttDetails(field, value);
        }
    }

    public void validateShoppingCarttDetails(String field, String value) {
        switch (field.toLowerCase()) {
            case "product name":
                assertThat(page.get().locator(ShoppingCartLocators.PRODUCT_NAME_XPATH)).containsText(value
                        , new LocatorAssertions.ContainsTextOptions().setTimeout(15000));
                break;
            case "price":
                assertThat(page.get().locator(ShoppingCartLocators.PRICE_XPATH)).containsText(value
                        , new LocatorAssertions.ContainsTextOptions().setTimeout(15000));
                break;
            case "quantity":
                assertThat(page.get().locator(ShoppingCartLocators.QUANTITY_XPATH)).containsText(value
                        , new LocatorAssertions.ContainsTextOptions().setTimeout(15000));
                break;
            default:

        }
    }

    public void clickProceedToCheckout() {
        setClickElement(ShoppingCartLocators.PROCEED_TO_CHECKOUT_XPATH);
    }
}
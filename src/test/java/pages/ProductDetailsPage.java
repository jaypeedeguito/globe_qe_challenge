package pages;

import com.core.utility.BasePage;
import com.microsoft.playwright.assertions.LocatorAssertions;
import io.cucumber.datatable.DataTable;
import locators.ProductDetailsLocators;

import java.util.List;
import java.util.Map;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ProductDetailsPage extends BasePage {

    public void verifyPageTitle(String productName) {
        assertThat(page.get().locator(ProductDetailsLocators.PAGE_TITLE_XPATH)).containsText(productName
                , new LocatorAssertions.ContainsTextOptions().setTimeout(15000));
    }

    public void validateProductDetails(DataTable dt) {
        List<Map<String, String>> rows = dt.asMaps(String.class, String.class);
        String field, value;
        for (Map <String, String> columns : rows) {
            field = columns.get("field");
            value = columns.get("value");
            validateProductDetails(field, value);
        }
    }

    public void validateProductDetails(String field, String value) {

        switch (field.toLowerCase()) {
            case "product name":
                assertThat(page.get().locator(ProductDetailsLocators.PAGE_TITLE_XPATH)).containsText(value
                        , new LocatorAssertions.ContainsTextOptions().setTimeout(15000));
                break;
            case "price":
                assertThat(page.get().locator(ProductDetailsLocators.PRICE_XPATH)).containsText(value
                        , new LocatorAssertions.ContainsTextOptions().setTimeout(15000));
                break;
            case "description":
                assertThat(page.get().locator(ProductDetailsLocators.DESCRIPTION_XPATH)).containsText(value
                        , new LocatorAssertions.ContainsTextOptions().setTimeout(15000));
                break;
            default:

        }
    }

    public void addToCart() {
        setClickElement(ProductDetailsLocators.ADD_TO_CART_BUTTON_XPATH);
    }

    public void clickViewCart() {
        setClickElement(ProductDetailsLocators.VIEW_CART_LINK_XPATH);
    }
}
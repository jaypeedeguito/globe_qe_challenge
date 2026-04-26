package pages;

import com.core.utility.BasePage;
import com.core.utility.TestDataModel;
import com.microsoft.playwright.assertions.LocatorAssertions;
import io.cucumber.datatable.DataTable;
import locators.OrderPlacedLocators;
import locators.OrderPlacedLocators;

import java.util.List;
import java.util.Map;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class OrderPlacedPage extends BasePage {

    public void verifySuccessMessage() {
        assertThat(page.get().locator(OrderPlacedLocators.SUCCESS_ORDER_MESSAGE_XPATH)).containsText("Thanks for your order"
                , new LocatorAssertions.ContainsTextOptions().setTimeout(15000));
        TestDataModel.getScenario().log("Success Message: " + page.get().locator(OrderPlacedLocators.SUCCESS_ORDER_MESSAGE_XPATH).textContent());
    }

    public void verifyOrderNumber() {
        assertThat(page.get().locator(OrderPlacedLocators.ORDER_NUMBER_XPATH)).containsText("Order #"
                , new LocatorAssertions.ContainsTextOptions().setTimeout(15000));

        TestDataModel.getScenario().log("Order Number: " + page.get().locator(OrderPlacedLocators.ORDER_NUMBER_XPATH).textContent());
    }

    public void validateOrderItemsDetails(DataTable dt) {
        List<Map<String, String>> rows = dt.asMaps(String.class, String.class);
        String field, value;
        for (Map <String, String> columns : rows) {
            field = columns.get("field");
            value = columns.get("value");
            validateOrderItemsDetails(field, value);
        }
    }

    public void validateOrderItemsDetails(String field, String value) {
        switch (field.toLowerCase()) {
            case "product name":
                assertThat(page.get().locator(OrderPlacedLocators.PRODUCT_NAME_XPATH)).containsText(value
                        , new LocatorAssertions.ContainsTextOptions().setTimeout(15000));
                break;
            case "quantity":
                assertThat(page.get().locator(OrderPlacedLocators.QUANTITY_XPATH)).containsText(value
                        , new LocatorAssertions.ContainsTextOptions().setTimeout(15000));
                break;
            case "subtotal":
                assertThat(page.get().locator(OrderPlacedLocators.SUBTOTAL_XPATH)).containsText(value
                        , new LocatorAssertions.ContainsTextOptions().setTimeout(15000));
                break;
            case "shipping":
                assertThat(page.get().locator(OrderPlacedLocators.SHIPPING_XPATH)).containsText(value
                        , new LocatorAssertions.ContainsTextOptions().setTimeout(15000));
                break;
            case "tax":
                assertThat(page.get().locator(OrderPlacedLocators.TAX_XPATH)).containsText(value
                        , new LocatorAssertions.ContainsTextOptions().setTimeout(15000));
                break;
            case "total":
                assertThat(page.get().locator(OrderPlacedLocators.TOTAL_XPATH)).containsText(value
                        , new LocatorAssertions.ContainsTextOptions().setTimeout(15000));
                break;
            default:

        }
    }
}
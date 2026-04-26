package pages;

import com.core.utility.BasePage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.assertions.LocatorAssertions;
import com.microsoft.playwright.options.SelectOption;
import com.microsoft.playwright.options.WaitForSelectorState;
import io.cucumber.datatable.DataTable;
import locators.CheckoutLocators;

import java.util.List;
import java.util.Map;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CheckoutPage extends BasePage {

    public void verifyCheckoutPage() {
        assertThat(page.get().locator(CheckoutLocators.CHECKOUT_SECTION_XPATH)).isVisible(new LocatorAssertions.IsVisibleOptions().setTimeout(15000));
    }

    public void fillShippingAddress(DataTable dt) {
        List<Map<String, String>> rows = dt.asMaps(String.class, String.class);
        String field, value;
        for (Map <String, String> columns : rows) {
            field = columns.get("field");
            value = columns.get("value");
            fillShippingAddress(field, value);
        }
    }

    public void fillShippingAddress(String field, String value) {
        switch (field.toLowerCase()) {
            case "country":
                BasePage.selectOptionFromLabel(CheckoutLocators.COUNTRY_DROPDOWN_XPATH, value);
                break;
            case "address":
                BasePage.clearInput(CheckoutLocators.ADDRESS_TEXTBOX_XPATH);
                BasePage.setTextToInputWithoutClear(CheckoutLocators.ADDRESS_TEXTBOX_XPATH, value);
                break;
            case "city":
                BasePage.clearInput(CheckoutLocators.CITY_TEXTBOX_XPATH);
                BasePage.setTextToInputWithoutClear(CheckoutLocators.CITY_TEXTBOX_XPATH, value);
                break;
            case "state/province":
                BasePage.selectOptionFromLabel(CheckoutLocators.STATE_TEXTBOX_XPATH, value);
                break;
            case "zip/postal code":
                BasePage.clearInput(CheckoutLocators.ZIP_TEXTBOX_XPATH);
                BasePage.setTextToInputWithoutClear(CheckoutLocators.ZIP_TEXTBOX_XPATH, value);
                break;
            case "phone":
                BasePage.clearInput(CheckoutLocators.PHONE_TEXTBOX_XPATH);
                BasePage.setTextToInputWithoutClear(CheckoutLocators.PHONE_TEXTBOX_XPATH, value);
                page.get().keyboard().press("Tab");
                break;
            default:

        }
    }

    public void fillCreditCardDetails(DataTable dt) {
        List<Map<String, String>> rows = dt.asMaps(String.class, String.class);
        String field, value;
        for (Map <String, String> columns : rows) {
            field = columns.get("field");
            value = columns.get("value");
            fillCreditCardDetails(field, value);
        }
    }

    public void fillCreditCardDetails(String field, String value) {
        switch (field.toLowerCase()) {
            case "country":
                getFrameLocator(CheckoutLocators.IFRAME_XPATH)
                        .locator(CheckoutLocators.COUNTRY_PAYMENT_DROPDOWN_XPATH).selectOption(new SelectOption().setLabel(value));
//                BasePage.selectOptionFromLabel(CheckoutLocators.COUNTRY_PAYMENT_DROPDOWN_XPATH, value);
                break;
            case "card number":
                getFrameLocator(CheckoutLocators.IFRAME_XPATH)
                        .locator(CheckoutLocators.CARD_NUMBER_TEXTBOX_XPATH).fill(value);
                break;
            case "expiration date":
                getFrameLocator(CheckoutLocators.IFRAME_XPATH)
                        .locator(CheckoutLocators.EXPIRATION_DATE_TEXTBOX_XPATH).fill(value);
                break;
            case "security code":
                getFrameLocator(CheckoutLocators.IFRAME_XPATH)
                        .locator(CheckoutLocators.SECURITY_CODE_TEXTBOX_XPATH).fill(value);
                break;
            default:
        }
    }

    public void clickPayNow() {
        setClickElement(CheckoutLocators.PAY_NOW_XPATH);
    }

    public void clickCreditCard() {
        int ctr = 1;
        while (ctr <= 3) {
            ctr++;
            try {
                getFrameLocator(CheckoutLocators.IFRAME_XPATH).locator(CheckoutLocators.CARD_RADIO_BUTTON_XPATH)
                        .waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(15000));
                getFrameLocator(CheckoutLocators.IFRAME_XPATH).locator(CheckoutLocators.CARD_RADIO_BUTTON_XPATH).click();
//                setClickElement(CheckoutLocators.CARD_RADIO_BUTTON_XPATH);
                break;
            } catch (Exception e) {
            }
        }

    }

    public void clickPremium() {
        setClickElement(CheckoutLocators.PREMIUM_BUTTON_XPATH);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
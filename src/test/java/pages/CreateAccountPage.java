package pages;

import com.core.utility.BasePage;
import com.core.utility.TestDataModel;
import com.microsoft.playwright.assertions.LocatorAssertions;
import io.cucumber.datatable.DataTable;
import locators.CreateAccountLocators;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CreateAccountPage extends BasePage {

    public void navigateToSpreeEcommerceURL() {
        openURLInBrowser();
    }

    public void verifyPageTitle() {
//        Assert.assertTrue(page.get().isVisible(HOME_TITLE_XPATH));
        assertThat(page.get().locator(CreateAccountLocators.CARD_TITLE_XPATH)).containsText("Create Account"
                , new LocatorAssertions.ContainsTextOptions().setTimeout(15000));
    }

    public void inputCreateAccountDetails(DataTable dt) {
        List<Map<String, String>> rows = dt.asMaps(String.class, String.class);
        String field, value;
        for (Map <String, String> columns : rows) {
            field = columns.get("field");
            value = columns.get("value");
            inputCreateAccountDetails(field, value);
        }
        setClickElement(CreateAccountLocators.POLICY_CONSENT_CHECKBOX_XPATH);
        setClickElement(CreateAccountLocators.CREATE_ACCOUNT_BUTTON_XPATH);
    }

    public void inputCreateAccountDetails(String field, String value) {

        switch (field.toLowerCase()) {
            case "first name":
                BasePage.clearInput(CreateAccountLocators.FIRST_NAME_TEXTBOX_XPATH);
                BasePage.setTextToInputWithoutClear(CreateAccountLocators.FIRST_NAME_TEXTBOX_XPATH, value);
                break;
            case "last name":
                BasePage.clearInput(CreateAccountLocators.LAST_NAMEL_TEXTBOX_XPATH);
                BasePage.setTextToInputWithoutClear(CreateAccountLocators.LAST_NAMEL_TEXTBOX_XPATH, value);
                break;
            case "email":
                String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("ddMMyyyyHHmmss"));
                String email = "pix_" + timestamp + "@dusty.com";
                BasePage.clearInput(CreateAccountLocators.EMAIL_TEXTBOX_XPATH);
                BasePage.setTextToInputWithoutClear(CreateAccountLocators.EMAIL_TEXTBOX_XPATH, email);
                TestDataModel.setEmail(email);
                TestDataModel.getScenario().log("Email: " + email);
                break;
            case "password":
                BasePage.clearInput(CreateAccountLocators.PASSWORD_TEXTBOX_XPATH);
                BasePage.setTextToInputWithoutClear(CreateAccountLocators.PASSWORD_TEXTBOX_XPATH, value);
                TestDataModel.setPassword(value);
                break;
            case "confirm password":
                BasePage.clearInput(CreateAccountLocators.CONFIRM_PASSWORD_TEXTBOX_XPATH);
                BasePage.setTextToInputWithoutClear(CreateAccountLocators.CONFIRM_PASSWORD_TEXTBOX_XPATH, value);
                break;
            default:

        }
    }
}
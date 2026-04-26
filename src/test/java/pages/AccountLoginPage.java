package pages;

import com.core.utility.BasePage;
import com.core.utility.TestDataModel;
import com.microsoft.playwright.assertions.LocatorAssertions;
import locators.AccountLoginLocators;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class AccountLoginPage extends BasePage {

    public void navigateToSpreeEcommerceURL() {
        openURLInBrowser();
    }

    public void verifyPageTitle() {
//        Assert.assertTrue(page.get().isVisible(HOME_TITLE_XPATH));
        assertThat(page.get().locator(AccountLoginLocators.CARD_TITLE_XPATH)).containsText("My Account"
                , new LocatorAssertions.ContainsTextOptions().setTimeout(15000));
    }

    public void clickAccountIcon() {
        setClickElement(AccountLoginLocators.SIGN_UP_LINK_XPATH);
    }

    public void signIn(String email, String password) {
        BasePage.clearInput(AccountLoginLocators.EMAIL_TEXTBOX_XPATH);
        BasePage.setTextToInputWithoutClear(AccountLoginLocators.EMAIL_TEXTBOX_XPATH, email);

        BasePage.clearInput(AccountLoginLocators.PASSWORD_TEXTBOX_XPATH);
        BasePage.setTextToInputWithoutClear(AccountLoginLocators.PASSWORD_TEXTBOX_XPATH, password);

        setClickElement(AccountLoginLocators.SIGN_IN_BUTTON_XPATH);
        TestDataModel.getScenario().log("Email: " + email);
        TestDataModel.getScenario().log("Password: " + password);
    }
}
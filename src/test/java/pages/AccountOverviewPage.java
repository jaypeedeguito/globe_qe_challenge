package pages;

import com.core.utility.BasePage;
import com.microsoft.playwright.assertions.LocatorAssertions;
import locators.AccountOverviewLocators;
import locators.TopMenuLocators;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class AccountOverviewPage extends BasePage {

    public void navigateToSpreeEcommerceURL() {
        openURLInBrowser();
    }

    public void verifyPageTitle() {
        assertThat(page.get().locator(AccountOverviewLocators.TITLE_XPATH)).containsText("Account Overview"
                , new LocatorAssertions.ContainsTextOptions().setTimeout(15000));
    }

    public void clickSignOut() {
        setClickElement(AccountOverviewLocators.SIGN_OUT_BUTTON_XPATH);
    }
}
package pages;

import com.core.utility.BasePage;
import locators.TopMenuLocators;
import org.testng.Assert;

public class TopMenuPage extends BasePage {

    public void clickAccountIcon() {
        setClickElement(TopMenuLocators.ACCOUNT_XPATH);
    }

    public void clickHamburgerMenuIcon() {
        setClickElement(TopMenuLocators.HAMBURGER_MENU_ICON_XPATH);
    }
}
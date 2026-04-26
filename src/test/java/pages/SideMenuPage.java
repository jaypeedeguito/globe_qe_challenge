package pages;

import com.core.utility.BasePage;
import locators.SideMenuLocators;

public class SideMenuPage extends BasePage {

    public void clickAllProducts() {
        setClickElement(SideMenuLocators.ALL_PRODUCTS_XPATH);
    }
}
package locators;

public class ShoppingCartLocators {
    public static final String PAGE_TITLE_XPATH = "(//h1)[1]";
    public static final String PROCEED_TO_CHECKOUT_XPATH = "//a[.='Proceed to Checkout']";

    public static final String PRODUCT_NAME_XPATH = "(//h3)[1]";
    public static final String PRICE_XPATH = "(//h3)[1]//following-sibling::p[2]";
    public static final String QUANTITY_XPATH = "((//h1)[1]/following-sibling::div//span)[1]";
}
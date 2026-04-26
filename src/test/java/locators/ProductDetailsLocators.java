package locators;

public class ProductDetailsLocators {
    public static final String PAGE_TITLE_XPATH = "(//h1)[1]";
    public static final String PRICE_XPATH = "(//h1)[1]/following-sibling::div[1]//span";
    public static final String ADD_TO_CART_BUTTON_XPATH = "//button[.='Add to Cart']";
    public static final String VIEW_CART_LINK_XPATH = "//a[.='View Cart']";
    public static final String DESCRIPTION_XPATH = "//h2[.='Description']/following-sibling::div";
}
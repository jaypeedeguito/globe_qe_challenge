package locators;

public class OrderPlacedLocators {
    public static final String SUCCESS_ORDER_MESSAGE_XPATH = "(//h1)[1]";
    public static final String ORDER_NUMBER_XPATH = "(//h1)[1]/following-sibling::p[1]";

    public static final String PRODUCT_NAME_XPATH = "(//h3)[1]";
    public static final String QUANTITY_XPATH = "(//h3)[1]/following-sibling::p[2]";
    public static final String SUBTOTAL_XPATH = "//span[.='Subtotal']/following-sibling::span";
    public static final String SHIPPING_XPATH = "//span[.='Shipping']/following-sibling::span";
    public static final String TAX_XPATH = "//span[.='Tax']/following-sibling::span";
    public static final String TOTAL_XPATH = "//span[.='Total']/following-sibling::span";
}
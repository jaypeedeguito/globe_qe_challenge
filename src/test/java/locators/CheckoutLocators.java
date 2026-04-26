package locators;

public class CheckoutLocators {
    public static final String CHECKOUT_SECTION_XPATH = "//div[@id='checkout-section-address']";
    public static final String COUNTRY_DROPDOWN_XPATH = "//select[@id='ship-country']";

    public static final String ADDRESS_TEXTBOX_XPATH = "//input[@id='ship-address1']";
    public static final String CITY_TEXTBOX_XPATH = "//input[@id='ship-city']";
    public static final String STATE_TEXTBOX_XPATH = "//select[@id='ship-state']";
    public static final String ZIP_TEXTBOX_XPATH = "//input[@id='ship-postal_code']";
    public static final String PHONE_TEXTBOX_XPATH = "//input[@id='ship-phone']";
    public static final String PREMIUM_BUTTON_XPATH = "//span[.='Premium']";

    public static final String PAY_NOW_XPATH = "//button[.='Pay Now']";

    public static final String CARD_RADIO_BUTTON_XPATH = "//button[@id='card-tab']//span";
    public static final String CARD_NUMBER_TEXTBOX_XPATH = "//input[@id='payment-numberInput']";
    public static final String EXPIRATION_DATE_TEXTBOX_XPATH = "//input[@id='payment-expiryInput']";
    public static final String SECURITY_CODE_TEXTBOX_XPATH = "//input[@id='payment-cvcInput']";
    public static final String COUNTRY_PAYMENT_DROPDOWN_XPATH = "//select[@id='payment-countryInput']";
    public static final String IFRAME_XPATH = "//iframe[@*='Secure payment input frame']";
}
package locators;

public class CreateAccountLocators {
    public static final String CARD_TITLE_XPATH = "(//div[@data-slot='card-title'])[1]";
    public static final String FIRST_NAME_TEXTBOX_XPATH = "//label[text()='First name']/following-sibling::input";
    public static final String LAST_NAMEL_TEXTBOX_XPATH = "//label[text()='Last name']/following-sibling::input";
    public static final String EMAIL_TEXTBOX_XPATH = "//input[@id='email' and not (@name)]";
    public static final String PASSWORD_TEXTBOX_XPATH = "//input[@id='password'][not (@name)]";
    public static final String CONFIRM_PASSWORD_TEXTBOX_XPATH = "//label[text()='Confirm Password']/following-sibling::div//input";
    public static final String POLICY_CONSENT_CHECKBOX_XPATH = "//button[@id='policy-consent']";
    public static final String CREATE_ACCOUNT_BUTTON_XPATH = "//button[text()='Create Account']";
}
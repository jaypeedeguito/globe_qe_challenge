package locators;

public class AllProductsLocators {
    public static final String PAGE_TITLE_XPATH = "(//h1)[1]";

    public static String getProductLocator(String productName) {
        return "(//h3[text()='" + productName + "'])[1]/ancestor::a//img";
    }

}
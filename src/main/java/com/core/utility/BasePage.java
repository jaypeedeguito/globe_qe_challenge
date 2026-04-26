package com.core.utility;

import com.core.hooks.Hooks;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.MouseButton;
import com.microsoft.playwright.options.SelectOption;
import com.microsoft.playwright.options.WaitForSelectorState;
import org.assertj.core.api.SoftAssertions;
import org.testng.Assert;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;

public abstract class BasePage extends Hooks {

    static SoftAssertions softAssertions = new SoftAssertions();
    public static void openURLInBrowser(){
        try {
            //page.get().navigate(System.getProperty("applicationUrl"));
            page.get().navigate(new ConfigProperties().initializeConfigProperties().getProperty("BASE_URL"));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void openNewURLInBrowser(String url){
        try {
            page.get().navigate(url);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getCurrentUrl(){
        return page.get().url();
    }

    public static String getPageTitle(){
        return page.get().title();
    }

    public static void setClickElement(String locator){
        page.get().click(locator);
    }

    public static void setDoubleClickElement(String locator){
        page.get().dblclick(locator);
    }

    public static void setClickElementAndHold(String locator){
        page.get().locator(locator).click((new Locator.ClickOptions()
                .setButton(MouseButton.RIGHT)
                .setDelay(5000)));
    }

    public static void setTextToInput(String locator, String value){
        page.get().locator(locator).clear();
        page.get().fill(locator, value);
    }

    public static void setTextToInputWithoutClear(String locator, String value){
        page.get().fill(locator, value);
    }

    public static void clearInput(String locator){
        page.get().locator(locator).clear();
    }

    public static String getElementText(String locator){
        return page.get().locator(locator).textContent();
    }

    public static String getInputValue(String locator){
        return page.get().locator(locator).inputValue();
    }

    public static void selectCheckbox(String locator){
        page.get().locator(locator).isVisible();
        if (!page.get().locator(locator).isChecked()){
            page.get().locator(locator).check();
        }
    }

    public static void deselectCheckbox(String locator){
        page.get().locator(locator).isVisible();
        if (page.get().locator(locator).isChecked()){
            page.get().locator(locator).uncheck();
        }
    }

    public static boolean isElementVisible(String locator){
        return page.get().locator(locator).isVisible();
    }

    public static boolean isInputEmpty(String locator){
        return page.get().locator(locator).getAttribute("value").isEmpty();
    }

    public static void waitForElementPresent(String locator){
        page.get().locator(locator).waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.ATTACHED));
    }

    public static void waitForElementVisibility(String locator){
        page.get().locator(locator).waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
    }

    public static void waitForElementInvisibility(String locator){
        page.get().locator(locator).waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.HIDDEN));
    }

    public static void setTextToClipboard(String value){
        StringSelection stringSelection = new StringSelection(value);
        Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
        clpbrd.setContents(stringSelection, (ClipboardOwner)null);
    }

    public static boolean isElementEnabled(String locator){
        return page.get().locator(locator).isEnabled();
    }

    public static boolean isElementEditable(String locator){
        return page.get().locator(locator).isEditable();
    }

    public static String getAttribute(String locator, String attribute){
        return page.get().locator(locator).getAttribute(attribute);
    }

    public static void HoverElement(String locator){
        page.get().locator(locator).hover();
    }

    public static void ScrollToElement(String locator){
        page.get().locator(locator).scrollIntoViewIfNeeded();
    }

    public static void scrollToElementJS(int x, int y) {
        page.get().evaluate("window.scrollBy(" + x + ", " + y + ");");
    }

    public static void switchToIframe(String iFrame){
        page.get().frameLocator(iFrame);
    }

    public static FrameLocator getFrameLocator(String iFrame){
        return page.get().frameLocator(iFrame);
    }

    public static void goBack(){
        page.get().goBack();
    }

    public static void sendKeys(String locator, String key){
        page.get().locator(locator).press(key);
    }

    public static void selectOptionFromLabel(String locator,String value){
        ElementHandle select = page.get().querySelector(locator);
        select.selectOption(new SelectOption().setLabel(value));
    }

    public static void selectOptionFromIndex(String locator,int value){
        ElementHandle select = page.get().querySelector(locator);
        select.selectOption(new SelectOption().setIndex(value));
    }




}
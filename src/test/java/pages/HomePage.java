package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ElementHelper;

public class HomePage {
    String appName = "API Demos";

    By btn_popup_okay = MobileBy.id("android:id/button1");


    By btn_tabs = MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"android:id/text1\")");

    AppiumDriver driver;
    WebDriverWait wait;
    ElementHelper elementHelper;
    Actions action;

    public HomePage(AppiumDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.elementHelper = new ElementHelper(driver);
        this.action = new Actions(driver);
    }

    public void clickPopupOkButton() {
        elementHelper.checkElementPresence(btn_popup_okay);
        elementHelper.click(btn_popup_okay);
    }


    public void clickTab(String title) {
        elementHelper.clickElementWithText(btn_tabs,title);
    }

}

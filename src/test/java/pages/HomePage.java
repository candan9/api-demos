package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ElementHelper;

public class HomePage {

    By section_full_name = MobileBy.id("com.lcwaikiki.android:id/txtWelcomeHeader");
    By btn_skip = MobileBy.id("com.lcwaikiki.android:id/tvNext");
    By btn_tabs = MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"com.lcwaikiki.android:id/textItemTab\")");
    By btn_cart = MobileBy.className("android.widget.TextView");
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

    public void clickSkipButton() {
        elementHelper.checkElementPresence(btn_skip);
        elementHelper.click(btn_skip);
    }

    public String checkUserLoggedIn() {
        elementHelper.checkElementPresence(section_full_name);
       return elementHelper.getText(section_full_name);
    }

    public void assertTitle(String title) {
        elementHelper.checkElementWithText(btn_tabs,title);
    }

    public void clickTab(String title) {
        elementHelper.clickElementWithText(btn_tabs,title);
    }

    public void checkHomePage() {
        elementHelper.checkElementPresence(btn_skip);
    }

    public void goToCart() {
        elementHelper.checkElementVisible(btn_cart);
        elementHelper.clickElementContainext(btn_cart,"Sepete Git");
    }
}

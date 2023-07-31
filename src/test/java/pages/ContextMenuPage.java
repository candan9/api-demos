package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ElementHelper;

public class ContextMenuPage {
    By btn_long_press = MobileBy.id("com.hmh.api:id/long_press");
    By menus = MobileBy.id("android:id/title");
    AppiumDriver driver;
    WebDriverWait wait;
    ElementHelper elementHelper;
    Actions action;

    public ContextMenuPage(AppiumDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.elementHelper = new ElementHelper(driver);
        this.action = new Actions(driver);
    }
    public void longPressToButton() {
        elementHelper.checkElementPresence(btn_long_press);
        elementHelper.longPress(btn_long_press);
    }
    public void checkMenus(String textA, String textB) {
        elementHelper.checkElementWithText(menus,textA);
        elementHelper.checkElementWithText(menus,textB);
    }
}

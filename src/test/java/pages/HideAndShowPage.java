package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ElementHelper;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class HideAndShowPage {
    By btn_hide = MobileBy.id("com.hmh.api:id/frag1hide");
    By btn_hide_second = MobileBy.id("com.hmh.api:id/frag2hide");
    By frgmnt =  MobileBy.id("com.hmh.api:id/fragment1");
    By frgmnt_second =  MobileBy.id("com.hmh.api:id/fragment2");
    AppiumDriver driver;
    WebDriverWait wait;
    ElementHelper elementHelper;
    Actions action;

    public HideAndShowPage(AppiumDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.elementHelper = new ElementHelper(driver);
        this.action = new Actions(driver);
    }
    public void checkElementsOpened() {
        elementHelper.checkElementPresence(btn_hide);
        elementHelper.checkElementPresence(btn_hide_second);
        elementHelper.checkElementPresence(frgmnt);
        elementHelper.checkElementPresence(frgmnt_second);
    }
    public void clickHideButton(String text) {
        elementHelper.click(btn_hide);
        assertTrue(elementHelper.checkElementDisplayed(frgmnt));
        elementHelper.checkElementText(btn_hide,text);
    }
    public void clickShowButton(String text) {
        elementHelper.click(btn_hide);
        elementHelper.checkElementPresence(frgmnt_second);
        elementHelper.checkElementText(btn_hide,text);
    }
}

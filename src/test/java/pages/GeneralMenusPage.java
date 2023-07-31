package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.aspectj.bridge.AbortException;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import util.ElementHelper;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class GeneralMenusPage   {
    By chckbx_enable_admin = MobileBy.id("android:id/checkbox");
    String btn_activate_text = "Activate this device admin app";
    By ttle_general_menu = MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"android:id/title\")");
    By btn_activate = MobileBy.id("com.android.settings:id/action_button");
    AppiumDriver driver;
    WebDriverWait wait;
    ElementHelper elementHelper;
    Actions action;

    public GeneralMenusPage(AppiumDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.elementHelper = new ElementHelper(driver);
        this.action = new Actions(driver);
    }
    public void clickTitle(String title) {
        elementHelper.clickElementWithText(ttle_general_menu,title);

    }
    public void clickEnableAdminCheckbox() {
        elementHelper.checkElementPresence(chckbx_enable_admin);
        elementHelper.findFirstElement(chckbx_enable_admin).click();
    }
    public void scrollToActivateButton() {
        elementHelper.scrollToElement(0,btn_activate_text);
    }
    public void ClickActivateButton() {
        elementHelper.checkElementPresence(btn_activate);
        elementHelper.click(btn_activate);
    }
    public void CheckEnableAdminChecked() {
        String check = elementHelper.findFirstElement(chckbx_enable_admin).getAttribute("checked");
        assertTrue(Boolean.parseBoolean(check));
    }
}

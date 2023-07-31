package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import util.ElementHelper;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class ActionBarTabsPage {
    By btn_add_tab = MobileBy.id("com.hmh.api:id/btn_add_tab");
    By btn_toggle_tab_mode = MobileBy.id("com.hmh.api:id/btn_toggle_tabs");
    By tab_items = MobileBy.xpath("//android.app.ActionBar.Tab/android.widget.TextView");
    By btn_remove_last_tab = MobileBy.id("com.hmh.api:id/btn_remove_tab");
    By btn_remove_all_tabs = MobileBy.id("com.hmh.api:id/btn_remove_all_tabs");
    AppiumDriver driver;
    WebDriverWait wait;
    ElementHelper elementHelper;
    Actions action;
    String lastAddedTab;
    public ActionBarTabsPage(AppiumDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.elementHelper = new ElementHelper(driver);
        this.action = new Actions(driver);
        this.lastAddedTab ="";
    }
    public void clickAddTabButton() {
        elementHelper.checkElementPresence(btn_add_tab);
        elementHelper.click(btn_add_tab);

    }
    public void checkItemCount(int count) {

        elementHelper.checkElementsCount(tab_items,count);
        lastAddedTab = elementHelper.findLastElement(tab_items).getText();
    }
    public void checkLastElementDeleted() {
           assertFalse(elementHelper.checkElementWithText(tab_items,lastAddedTab));
    }
    public void clickToggleTabModeButton() {
        elementHelper.checkElementPresence(btn_toggle_tab_mode);
        elementHelper.click(btn_toggle_tab_mode);
    }

    public void clickRemoveLastTabButton() {
        elementHelper.checkElementPresence(btn_remove_last_tab);
        elementHelper.click(btn_remove_last_tab);
    }

    public void clickRemoveAllTabsButton() {
        elementHelper.checkElementPresence(btn_remove_all_tabs);
        elementHelper.click(btn_remove_all_tabs);
    }

    public void checkAllTabsDeleted() {
        assertFalse(elementHelper.checkElementPresence(tab_items));
    }
}

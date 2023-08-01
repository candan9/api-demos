package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ElementHelper;

public class ScrollablePage {
    String btn_tabs_string = "Tabs";
    By section_tabs = MobileBy.id("android:id/content");
    By content_tab = MobileBy.id("android:id/tabcontent");

    AppiumDriver driver;
    WebDriverWait wait;
    ElementHelper elementHelper;
    Actions action;


    public ScrollablePage(AppiumDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.elementHelper = new ElementHelper(driver);
        this.action = new Actions(driver);
    }

    public void scrollToTabsButton() {
        elementHelper.scrollToBottom();
    }
    public void tabTo(int count){
        for (int i =0 ;i<count;i++){
            action.sendKeys(Keys.TAB).perform();
        }
        action.sendKeys(Keys.ENTER).perform();
    }
    public void checkContent(String text){
        elementHelper.checkElementWithText(content_tab,text);
    }
}

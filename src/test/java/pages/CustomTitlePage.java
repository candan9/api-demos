package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ElementHelper;

public class CustomTitlePage {

    By lbl_left = MobileBy.id("com.hmh.api:id/left_text");
    By lbl_right = MobileBy.id("com.hmh.api:id/right_text");
    By txt_left = MobileBy.id("com.hmh.api:id/left_text_edit");
    By txt_right = MobileBy.id("com.hmh.api:id/right_text_edit");
    By btn_left = MobileBy.id("com.hmh.api:id/left_text_button");
    By btn_right = MobileBy.id("com.hmh.api:id/right_text_button");
    AppiumDriver driver;
    WebDriverWait wait;
    ElementHelper elementHelper;
    Actions action;
    public CustomTitlePage(AppiumDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.elementHelper = new ElementHelper(driver);
        this.action = new Actions(driver);
    }
    public void clickLeftEditButton() {
        elementHelper.checkElementPresence(btn_left);
        elementHelper.click(btn_left);
    }
    public void clickRightEditButton() {
        elementHelper.checkElementPresence(btn_right);
        elementHelper.click(btn_right);

    }
    public void typeOnLeftTextBox(String text) {
        elementHelper.checkElementPresence(txt_left);
        elementHelper.sendKey(txt_left,text);

    }
    public void typeOnRightTextBox(String text) {
        elementHelper.checkElementPresence(txt_right);
        elementHelper.sendKey(txt_right,text);
    }
    public void checkLeftLabelText(String text) {
        elementHelper.checkElementPresence(lbl_left);
        elementHelper.checkElementText(lbl_left,text);

    }
    public void checkRightLabelText(String text) {
        elementHelper.checkElementPresence(lbl_right);
        elementHelper.checkElementText(lbl_right,text);
    }
}

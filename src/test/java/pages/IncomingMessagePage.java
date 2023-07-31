package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ElementHelper;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class IncomingMessagePage {

    By btn_show_notification = MobileBy.id("com.hmh.api:id/notify");
    By lbl_notification_message =  MobileBy.id("com.hmh.api:id/text");
    By lbl_detail_notification = MobileBy.id("com.hmh.api:id/message");

    AppiumDriver driver;
    WebDriverWait wait;
    ElementHelper elementHelper;
    Actions action;

    public IncomingMessagePage(AppiumDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.elementHelper = new ElementHelper(driver);
        this.action = new Actions(driver);
    }

    public void clickShowNotificationButton() {
        elementHelper.checkElementPresence(btn_show_notification);
        elementHelper.click(btn_show_notification);
    }
    public void checkNotificationMessage(){

        elementHelper.checkElementWithText(lbl_detail_notification,"");
    }
}

package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ElementHelper;

import java.util.Random;

public class AlertDialogsPage {

    By btn_list_dialog = MobileBy.id("com.hmh.api:id/select_button");
    By element_command = MobileBy.id("android:id/text1");

    By alert_message = MobileBy.id("android:id/message");
    AppiumDriver driver;
    WebDriverWait wait;
    ElementHelper elementHelper;
    Actions action;
    String selectedCommand;
    int indexCommand;

    public AlertDialogsPage(AppiumDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.elementHelper = new ElementHelper(driver);
        this.action = new Actions(driver);
        this.selectedCommand = "";
        this.indexCommand = 0;
    }

    public void clickListDialogButton(String buttonName) {
        elementHelper.checkElementPresence(btn_list_dialog);
        elementHelper.clickElementWithText(btn_list_dialog,buttonName);
    }
    public void clickRandomElementButton() {
        int elementCount = elementHelper.getElementsCount(element_command);
        Random rand = new Random();
        int index = rand.nextInt(elementCount-1);
        selectedCommand = elementHelper.getTextWithIndex(element_command,index);
        indexCommand=index;
        elementHelper.clickWithIndex(element_command,index);
    }
    public void checkAlertMessage() {
        elementHelper.checkElementWithText(alert_message, String.valueOf(indexCommand));
        elementHelper.checkElementWithText(alert_message,selectedCommand);
    }

}
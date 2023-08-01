package util;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;

public class ElementHelper {
    AppiumDriver driver;
    TouchAction touchAction;
    WebDriverWait wait;
    Actions action;

    public ElementHelper(AppiumDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.action = new Actions(driver);
        this.touchAction = new TouchAction(driver);
    }

    /**
     * @param key
     * @return
     */
    public WebElement findElement(By key) {
        WebElement element = presenceElement(key);
        //scrollToElement(element);

        return element;
    }


    public WebElement findFirstElement(By key) {
        List<WebElement> elements = presenceElements(key);
        WebElement element = elements.get(0);
        return element;
    }
    public WebElement findLastElement(By key) {
        List<WebElement> elements = presenceElements(key);
        WebElement element = elements.get(elements.size()-1);
        return element;
    }

    /**
     * @param key
     * @return
     */
    public List<WebElement> findElements(By key) {
        List<WebElement> elements = presenceElements(key);
        //scrollToElement(elements.get(0));

        return elements;
    }
    public int getElementsCount(By key) {
        List<WebElement> elements = presenceElements(key);
        //scrollToElement(elements.get(0));

        return elements.size();
    }
    public List<WebElement> checkElementsCount(By key, int count) {
        return wait.until(ExpectedConditions.numberOfElementsToBe(key, count));
    }
    /**
     * @param key
     */
    public void click(By key) {
        findElement(key).click();
    }
    public void clickWithIndex(By key, int index) {
        List<WebElement> elements = presenceElements(key);
        elements.get(index).click();
    }
    public String getTextWithIndex(By key, int index) {
        List<WebElement> elements = presenceElements(key);
        return elements.get(index).getText();
    }
    /**
     * @param key
     * @param text
     */
    public void sendKey(By key, String text) {
        findElement(key).sendKeys(text);
    }

    /**
     * @param key
     * @return
     */
    public String getText(By key) {
        return findElement(key).getText();
    }
    public void longPress(By key){
       touchAction.longPress(LongPressOptions.longPressOptions()
                       .withElement (ElementOption.element (presenceElement(key))))
               .perform ();

    }
    public void scrollToBottom(){
        Dimension size = driver.manage().window().getSize();
        int startX = size.getWidth()/5 ;
        int endX = size.getWidth() /3;
        int startY = size.getHeight() ;
        int endY = (int) (size.getHeight() * 0.25);

        performScrollUsingSequence(startX, startY, endX, endY);
    }
    private void performScrollUsingSequence(int startX, int startY, int endX, int endY) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "first-finger");
        Sequence sequence = new Sequence(finger, 0)
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger.createPointerMove(Duration.ofMillis(300), PointerInput.Origin.viewport(), endX, endY))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));


        driver.perform(Collections.singletonList(sequence));
    }
    /**
     * @param key
     * @param text
     * @return
     */
    public boolean checkElementText(By key, String text) {
        return wait.until(ExpectedConditions.textMatches(key, Pattern.compile(text)));
    }

    /**
     * @param key
     */
    public boolean checkElementVisible(By key) {
        try {
            presenceElements(key);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }

    }

    /**
     *
     * @param key
     */
    public boolean checkElementPresence(By key) {
        try {
            return !driver.findElements(key).isEmpty();
        } catch (NotFoundException e) {
            return false;
        }
    }
    public boolean checkElementDisplayed(By key) {
        try {
            return wait.until(ExpectedConditions.invisibilityOf(findElement(key)));
        } catch (NotFoundException e) {
            return false;
        }
    }
    /**
     * @param text
     * @return
     */
    public boolean checkTitle(String text) {
        return wait.until(ExpectedConditions.titleIs(text));
    }

    /**
     * @param key
     * @param attr
     * @return
     */
    public String getAttribute(By key, String attr) {
        return findElement(key).getAttribute(attr);
    }

    /**
     * @param key
     * @param attr
     * @param text
     */
    public void checkAttribute(By key, String attr, String text) {
        Assert.assertEquals(getAttribute(key, attr), text);
    }

    /**
     * @param key
     * @param text
     */
    public void clickElementWithText(By key, String text) {
        boolean find = false;
        List<WebElement> elements = findElements(key);
        for (WebElement element : elements) {
            if (element.getText().contains(text)) {
                element.click();
                find = true;
                break;
            }
        }
        Assert.assertTrue(find);
    }
    public void clickElementContainext(By key, String text) {
        boolean find = false;
        List<WebElement> elements = findElements(key);
        for (WebElement element : elements) {
            if (element.getText().contains(text)) {
                element.click();
                find = true;
                break;
            }
        }
        Assert.assertTrue(find);
    }
    /**
     * @param key
     * @param text
     */
    public boolean checkElementWithText(By key, String text) {

        List<WebElement> elements = findElements(key);
        for (WebElement element : elements) {
            if (element.getText().contains(text)) return true;
        }
        return false;
    }


    /**
     * @param key
     * @param text
     * @param text2
     */
    public void sendKeyElementWithText(By key, String text, String text2) {
        boolean find = false;
        List<WebElement> elements = findElements(key);
        for (WebElement element : elements) {
            if (element.getText().equals(text)) {
                element.sendKeys(text2);
                find = true;
                break;
            }
        }
        Assert.assertTrue(find);
    }

    /**
     * @param key
     * @return
     */
    public WebElement presenceElement(By key) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(key));
    }

    /**
     * @param key
     * @return
     */
    public List<WebElement> presenceElements(By key) {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(key));
    }

    /**
     * @param
     */
    public void scrollToElement(int index,String text) {
            By command = MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance("+index+")).scrollIntoView(new UiSelector().textContains(\"" + text + "\").instance(0))");
            driver.findElement(command).click();
    }
}

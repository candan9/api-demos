package util;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.List;
import java.util.regex.Pattern;

public class ElementHelper {
    AppiumDriver driver;
    WebDriverWait wait;
    Actions action;

    public ElementHelper(AppiumDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.action = new Actions(driver);
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

    /**
     * @param key
     * @return
     */
    public List<WebElement> findElements(By key) {
        List<WebElement> elements = presenceElements(key);
        //scrollToElement(elements.get(0));
        return elements;
    }

    /**
     * @param key
     */
    public void click(By key) {
        findElement(key).click();
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
    public void checkElementVisible(By key) {
        wait.until(ExpectedConditions.visibilityOf(findElement(key)));
    }

    /**
     *
     * @param key
     */
    public void checkElementPresence(By key) {
        wait.until(ExpectedConditions.presenceOfElementLocated(key));
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
    public void checkElementWithText(By key, String text) {
        boolean find = false;
        List<WebElement> elements = findElements(key);
        for (WebElement element : elements) {
            if (element.getText().contains(text)) {
                find = true;
                break;
            }
        }
        Assert.assertTrue(find);
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
        Assert.assertEquals(true, find);
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

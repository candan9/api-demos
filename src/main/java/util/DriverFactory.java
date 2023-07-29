package util;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class DriverFactory {
    static AppiumDriver driver;
    static Properties properties;
    static DesiredCapabilities capabilities;

    public static AppiumDriver initialize_Driver(String browser) {
        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "src/test/resources/apk/");
        File app = new File(appDir, "APIDemos.apk");
        properties = ConfigReader.getProperties();
        capabilities = new DesiredCapabilities();
        if(browser==null){
            browser="Android";
        }
        if (browser.equals("Android")) {
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("udid", "emulator-5554");
            capabilities.setCapability("automationName","UiAutomator2");
            capabilities.setCapability("app", app.getAbsolutePath());
            capabilities.setCapability("avd","Pixel_7_API_31");
        } else if (browser.equals("iOS")) {
            capabilities.setCapability("platformName", "iOS");
            capabilities.setCapability("udid", "emrec");
            capabilities.setCapability("appPackage", "com.lcwaikiki.android");
            capabilities.setCapability("appActivity", "com.lcwaikiki.android.ui.HomeActivity");
        }
        try {
            driver = new AppiumDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }


        int impWait = Integer.parseInt(properties.getProperty("implicityWait"));
        driver.manage().timeouts().implicitlyWait(impWait, TimeUnit.SECONDS);
        return getDriver();
    }

    public static AppiumDriver getDriver() {
        return driver;
    }


}

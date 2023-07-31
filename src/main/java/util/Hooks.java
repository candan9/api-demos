package util;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.*;
import org.testng.Reporter;

import java.util.Properties;

public class Hooks {

    AppiumDriver driver;
    Properties properties;
    @Before
    public void before() {
        String browser = "Android";
        properties = ConfigReader.initialize_Properties();
        driver = DriverFactory.initialize_Driver(browser);
    }

    @BeforeStep
    public void beforeStep() {
    }

    @AfterStep
    public void afterStep() {
    }

    @After
    public void after() {
        driver.quit();
    }
}

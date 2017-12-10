import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by daddy on 12/2/17.
 */
public class Myfirsttest {
    IOSDriver driver;
    @Before
    public void setup() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "iPhone 7");
        capabilities.setCapability("udid","9DDCBBAC-39BF-439F-9665-1A95FE5E4B29");
        capabilities.setCapability("app","/Users/daddy/Library/Developer/Xcode/DerivedData/Snapp-fluvmiuojwaanodeacejnkybssvk/Build/Products/Debug-iphonesimulator/Snapp.app");
        capabilities.setCapability("automationName","XCUITest");
        driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }
    @After
    public void teardown(){
        driver.quit();

    }
    @Test
    public void clcik(){
        driver.findElementById("login").click();
        driver.findElementById("email textfield").sendKeys("invalid");
        driver.findElementById("password text field").sendKeys("abcd1234");
        driver.findElementById("login").click();
        MobileElement errordialog = (MobileElement) (new WebDriverWait(driver,15)).until(ExpectedConditions.presenceOfElementLocated(By.id("فرمت ایمیل اشتباه است")));
        String a = errordialog.getText();
        System.out.println(a);
        Assert.assertEquals(errordialog.getText(),"فرمت ایمیل اشتباه است");


    }


}

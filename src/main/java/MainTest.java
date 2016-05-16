import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class MainTest {

    AndroidDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", "D:\\autotest\\yandexkey-android.apk");
        capabilities.setCapability("deviceName", "android");
       //capabilities.setCapability("browserName", "Android");
       //capabilities.setCapability("platformVersion", "5.1.1");
       //capabilities.setCapability("platformName", "Android");
       //capabilities.setCapability("appPackage", "io.appium.android.apis");
        //capabilities.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        //driver.startActivity("ru.yandex.key", "ru.yandex.key.ui.activities.main.MainActivity"); // appPackage appActivity
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }


  @Test
    public void checkTitleElementPresent() {
        driver.startActivity("ru.yandex.key", "ru.yandex.key.ui.activities.main.MainActivity"); // appPackage appActivity
        Boolean iselementpresent = driver.findElementsByName("Самое время добавить первый аккаунт").size() != 0;
        Assert.assertTrue(iselementpresent, "Title is not present on screen");
        System.out.println("Title is present on screen.");
    }


    @Test
    public void checkBtnElementPresent() {
        driver.startActivity("ru.yandex.key", "ru.yandex.key.ui.activities.main.MainActivity"); // appPackage appActivity
        Boolean iselementpresent = driver.findElementsById("ru.yandex.key:id/btn_add_account").size() != 0;
        Assert.assertTrue(iselementpresent,"Btn is not present");
        System.out.println("Targeted element Loader is present on screen.");
    }

    @Test
    public void checkAddAccount(){
        driver.startActivity("ru.yandex.key", "ru.yandex.key.ui.activities.main.MainActivity");
        driver.findElement(By.id("ru.yandex.key:id/btn_add_account")).click();
        driver.findElement(By.id("ru.yandex.key:id/tv_add_account_manually")).click();
        driver.findElement(By.name("Логин")).sendKeys("astanova1");
        WebElement enter = driver.findElement(By.name("Секретный ключ"));
        enter.sendKeys("QQQQEEEERRRRTTTTYYYYUUUU");
        driver.pressKeyCode(66);
        Boolean message = driver.findElementsById("android:id/message").size()!=0;
        Assert.assertTrue(message, "Message is not present on screen");
        System.out.println("Message is present on screen.");

    }


    @Test
    public void checkSetting(){
        driver.startActivity("ru.yandex.key", "ru.yandex.key.ui.activities.main.MainActivity");
        driver.findElement(By.id("ru.yandex.key:id/btn_add_account")).click();
        driver.findElement(By.id("ru.yandex.key:id/tv_add_account_manually")).click();
        driver.findElement(By.name("Логин")).sendKeys("astanova1");
        WebElement enter = driver.findElement(By.name("Секретный ключ"));
        enter.sendKeys("QQQQEEEERRRRTTTTYYYYUUUU");
        driver.pressKeyCode(66);
        driver.findElement(By.id("android:id/button3")).click();
        driver.findElement(By.id("ru.yandex.key:id/settings")).click();
        Boolean title = driver.findElementsByName("Настройки").size()!=0;
        Assert.assertTrue (title, "Title is not present");
        System.out.println("Title is present");

    }

    @AfterTest
    public void End() throws IOException {
        driver.quit();
    }
}

//driver.closeApp()
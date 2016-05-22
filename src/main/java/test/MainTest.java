package test;

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


public class MainTest {

    AndroidDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", "D:\\autotest\\yandexkey-android.apk");
        capabilities.setCapability("deviceName", "BH90M6VD1L");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        //driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

/*
    @Test
    public void titleElementPresent() {
        driver.startActivity("ru.yandex.key", "ru.yandex.key.ui.activities.main.MainActivity"); // appPackage appActivity
        Boolean iselementpresent = driver.findElementsByName("Самое время добавить первый аккаунт").size() != 0;
        Assert.assertTrue(iselementpresent, "Title is not present on screen");
        System.out.println("Title is present on screen.");
    }


    @Test
    public void btnElementPresent() {
        driver.startActivity("ru.yandex.key", "ru.yandex.key.ui.activities.main.MainActivity"); // appPackage appActivity
        Boolean iselementpresent = driver.findElementsById("ru.yandex.key:id/btn_add_account").size() != 0;
        Assert.assertTrue(iselementpresent,"Btn is not present");
        System.out.println("Targeted element Loader is present on screen.");
    }
*/
    @Test
    public void addAccount(){
        driver.startActivity("ru.yandex.key", "ru.yandex.key.ui.activities.main.MainActivity");
        //driver.findElement(By.id("ru.yandex.key:id/btn_add_account")).click();
        driver.click
        driver.findElement(By.id("ru.yandex.key:id/tv_add_account_manually")).click();
        driver.findElement(By.name("Логин")).sendKeys("astanova1");
        WebElement enter = driver.findElement(By.name("Секретный ключ"));
        enter.sendKeys("QQQQEEEERRRRTTTTYYYYUUUU");
        driver.pressKeyCode(66);
        Boolean message = driver.findElementsById("android:id/message").size()!=0;
        Assert.assertTrue(message, "Message is not present on screen");
        System.out.println("Message is present on screen.");

    }

/*
    @Test
    public void nameOfSettingTitle(){
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
*/
    @AfterTest
    public void end() throws IOException {
        driver.quit();
    }
}

//driver.closeApp()
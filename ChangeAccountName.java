package com.yandex.key.screens;


import com.yandex.key.utils.PropertiesReader;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ChangeAccountName {

    AndroidDriver driver;

    public boolean check() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        try {
            capabilities.setCapability("app", PropertiesReader.getInstance().getUrl());
        } catch (Exception e) {
            e.printStackTrace();
        }
        capabilities.setCapability("deviceName", "android");
        try {
            driver = new AndroidDriver(new URL(PropertiesReader.getInstance().getHub()), capabilities);
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.startActivity("ru.yandex.key", "ru.yandex.key.ui.activities.main.MainActivity");
        driver.findElement(By.id("ru.yandex.key:id/btn_add_account")).click();
        driver.findElement(By.id("ru.yandex.key:id/tv_add_account_manually")).click();
        driver.findElement(By.name("Логин")).sendKeys("astanova1");
        WebElement enter = driver.findElement(By.name("Секретный ключ"));
        enter.sendKeys("QQQQEEEERRRRTTTTYYYYUUUU");
        driver.pressKeyCode(66);
        driver.findElement(By.id("android:id/button3")).click();
        driver.findElement(By.id("ru.yandex.key:id/settings")).click();
        driver.findElement(By.id("ru.yandex.key:id/account_settings_title")).click();
        driver.findElement(By.id("ru.yandex.key:id/account_name")).click();
        driver.pressKeyCode(46); //r
        driver.pressKeyCode(33); //e
        driver.pressKeyCode(42); //n
        driver.pressKeyCode(29); //a
        driver.pressKeyCode(41); //m
        driver.pressKeyCode(33); //e
        driver.pressKeyCode(84); //ok
        driver.pressKeyCode(AndroidKeyCode.BACK);
        Boolean btn = driver.findElementsByName("astanova1rename").size() != 0;
        driver.quit();
        return btn;
    }
}

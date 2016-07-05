package com.yandex.key.screens;


import com.yandex.key.utils.PropertiesReader;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class FirstLaunchTitle {

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
        driver.startActivity("ru.yandex.key", "ru.yandex.key.ui.activities.main.MainActivity"); // appPackage appActivity
        Boolean iselementpresent = driver.findElementsByName("Самое время добавить первый аккаунт").size() != 0;
        driver.quit();
        return iselementpresent;
    }
}

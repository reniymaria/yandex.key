package utils;


import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AndroidDriverWrapper extends AndroidDriver {

    public AndroidDriverWrapper(){

    }

    public void clickById(String id, int timeout) {
        waitForElementPresentAndVisible(id, timeout);
        waitForElementClickable(id, timeout);
        findElement(By.id(id)).click();
    }

    private void waitForElementPresentAndVisible(String locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(this, timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    private void waitForElementClickable(String locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(this, timeout);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
    }
    public void clickByName(String name, int timeout) {
        waitForElementPresentAndVisible(name, timeout);
        waitForElementClickable(name, timeout);
        findElement(By.name(name)).click();
    }
    public void enterTextByName(String name, int timeout, String text){
        waitForElementPresentAndVisible(name,timeout);
        waitForElementClickable(name, timeout);
        findElement(By.name(name)).sendKeys(text);
    }

}

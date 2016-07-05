package com.yandex.key.suits;


import com.yandex.key.screens.*;
import org.testng.Assert;
import org.testng.annotations.Test;


public class MainTest {

    @Test(groups = {"init"}, description = "Проверка надписи Самое время добавить первый аккаунт")
    public void titleElementPresent() {
        FirstLaunchTitle title = new FirstLaunchTitle();
        Assert.assertTrue(title.check(), "Title is not present on screen");
        System.out.println("Title is present on screen.");
    }


    @Test(groups = {"init"}, description = "Проверка кнопки Добавить аккаунт в приложение")
    public void btnElementPresent() {
        AddAccBtnDisplayed btn = new AddAccBtnDisplayed();
        Assert.assertTrue(btn.displayBtn(), "Btn is not present");
        System.out.println("Targeted element Loader is present on screen.");
    }

    @Test(groups = {"login"}, dependsOnGroups = {"init"}, description = "Проверка добавления аккаунта вручную")
    public void addAccount() {
        AddAccount login = new AddAccount();
        Assert.assertTrue(login.check(), "Message is not present on screen");
        System.out.println("Message is present on screen.");

    }

    @Test(dependsOnGroups = {"login"}, description = "Проверка заголовка страницы Настроек")
    public void settingTitle() {

        SettingTitle title = new SettingTitle();
        Assert.assertTrue(title.check(), "Title is not present");
        System.out.println("Title is present");
    }

    @Test(dependsOnGroups = {"login"}, description = "Проверка заголовка страницы Помощи")
    public void helpTitle() {
        HelpPageTitle title = new HelpPageTitle();
        Assert.assertTrue(title.check(), "Title is not present");
        System.out.println("Title is present");
    }


    @Test(dependsOnGroups = {"login"}, description = "Проверка заголовка страницы Проверить время")
    public void timeCheck() {
        TimeCheck title = new TimeCheck();
        Assert.assertTrue(title.check(), "Title is not present");
        System.out.println("Title is present");
    }

    @Test(dependsOnGroups = {"login"}, description = "Проверка, что аккаунт не пропадает при сворачивании приложения")
    public void hideApp() {
        HideAppAccount show = new HideAppAccount();
        Assert.assertTrue(show.check(), "Account isn't displayed");
        System.out.println("Account displayed");
    }

    @Test(dependsOnGroups = {"login"}, description = "Проверка удаления аккаунта с главной страницы")
    public void deleteAccount() {
        DeleteAccountMainPage accountDelete = new DeleteAccountMainPage();
        Assert.assertTrue(accountDelete.check(), "Account isn't deleted");
        System.out.println("Account is deleted");
    }

    @Test(dependsOnGroups = {"login"}, description = "Проверка удаления аккаунта с настроек")
    public void deleteAccountSetting() {
        DeleteAccountFromSetting accountDelete = new DeleteAccountFromSetting();
        Assert.assertTrue(accountDelete.check(), "Account isn't deleted");
        System.out.println("Account is deleted");
    }

    @Test(dependsOnGroups = {"login"}, description = "Проверка добавления второго аккаунта")
    public void addSecondAccount() {
        AddSecondAccount addAccount = new AddSecondAccount();
        Assert.assertTrue(addAccount.check(), "Account isn't added");
        System.out.println("Account is added");

    }

    @Test(groups = {"pin"}, dependsOnGroups = {"login"}, description = "Проверка, что появляется кнопка \"Войти по QR-коду\" после ввода пин-кода")
    public void qrButton() {
        EnterPinCodeQrBtn qrbutton = new EnterPinCodeQrBtn();
        Assert.assertTrue(qrbutton.check(), "Button isn't displayed");
        System.out.println("Button is displayed");
    }

    @Test(dependsOnGroups = {"pin"}, description = "Проверка, что временный пароль сбрасывается при переходе в настройки")
    public void resetPassword() {
        PasswordReset reset = new PasswordReset();
        Assert.assertTrue(reset.check(), "Password displayed");
        System.out.println("Button isn't displayed");
    }

    @Test(dependsOnGroups = {"pin"}, description = "Проверка, что можно нажать на все кнопки на клавиатуре при вводе пин-кода")
    public void clickAllBtn() {
        ClickAllPinBtn btn = new ClickAllPinBtn();
        Assert.assertTrue(btn.check(), "All buttons not clicked");
        System.out.println("All buttons clicked");
    }

    @Test(dependsOnGroups = {"login"}, description = "Проверка изменения названия аккаунта")
    public void changeAccName() {
        ChangeAccountName changeName = new ChangeAccountName();
        Assert.assertTrue(changeName.check(), "Name is not changed");
        System.out.println("Name changed");
    }

    @Test(groups = {"master-password"}, dependsOnGroups = {"login"}, description = "Проверка включения мастер-пароля")
    public void switchOnPassword() {
        SwitchOnMasterPassword passSwitchOn = new SwitchOnMasterPassword();
        Assert.assertTrue(passSwitchOn.check(), "Password is not switched On");
        System.out.println("Password switched On");
    }

    @Test(dependsOnGroups = {"master-password"}, description = "Проверка выключения мастер-пароля")
    public void switchOffPassword() {
        SwitchOffMasterPassword passSwitchOff = new SwitchOffMasterPassword();
        Assert.assertTrue(passSwitchOff.check(), "Password is not switched Off");
        System.out.println("Password switched Off");
    }


    @Test(dependsOnGroups = {"master-password"}, description = "Проверка ввода мастер-пароля при входе в приложение")
    public void openAppWithMP() {
        OpenAppWithMasterPassword open = new OpenAppWithMasterPassword();
        Assert.assertTrue(open.check(), "App is not opened");
        System.out.println("App is opened");
    }

    @Test(dependsOnGroups = {"master-password"}, description = "Проверка сохранения пароля аккаунта в МП")
    public void savePassword() {
        SavePasswordWithMP save = new SavePasswordWithMP();
        Assert.assertTrue(save.check(), "Password is not saved");
        System.out.println("Password is saved");
    }

    @Test(dependsOnGroups = {"login"}, description = "Проверка заголовка страницы О приложении")
    public void aboutTitle() {
        AboutAppTitle title = new AboutAppTitle();
        Assert.assertTrue(title.check(), "Title is not displayed");
        System.out.println("Title is displayed");
    }

    @Test(dependsOnGroups = {"login"}, description = "Отмена удаления аккаунта на главном экране")
    public void cancelDelete() {
        CancelDeleteAccount accountDelete = new CancelDeleteAccount();
        Assert.assertTrue(accountDelete.check(), "Account is deleted");
        System.out.println("Account is not deleted");
    }

}

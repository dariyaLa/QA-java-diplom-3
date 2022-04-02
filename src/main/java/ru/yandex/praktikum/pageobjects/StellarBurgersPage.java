package ru.yandex.praktikum.pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class StellarBurgersPage {

    public static final String URL = "https://stellarburgers.nomoreparties.site/";

    @FindBy(how = How.XPATH, using = ".//p[text()='Личный Кабинет']")
    private SelenideElement lk;

    @FindBy(how = How.XPATH, using = ".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg'][text()='Войти в аккаунт']")
    private SelenideElement inAccountButton;

    @FindBy(how = How.XPATH, using = ".//button[text()='Оформить заказ']")
    private SelenideElement createOrderButton;

    @FindBy(how = How.XPATH, using = ".//span[@class='text text_type_main-default'][text()='Соусы']")
    private SelenideElement sauces;

    @FindBy(how = How.XPATH, using = ".//h2[@class='text text_type_main-medium mb-6 mt-10'][text()='Соусы']")
    private SelenideElement saucesInList;

    @FindBy(how = How.XPATH, using = ".//span[@class='text text_type_main-default'][text()='Начинки']")
    private SelenideElement fillings;

    @FindBy(how = How.XPATH, using = ".//h2[@class='text text_type_main-medium mb-6 mt-10'][text()='Начинки']")
    private SelenideElement fillingsInList;

    @FindBy(how = How.XPATH, using = ".//span[@class='text text_type_main-default'][text()='Булки']")
    private SelenideElement rolls;

    @FindBy(how = How.XPATH, using = ".//h2[@class='text text_type_main-medium mb-6 mt-10'][text()='Булки']")
    private SelenideElement rollsInList;

    @Step("Нажатие на Личный кабинет")
    public LoginPage inLK() {
        this.lk.click();
        return page(LoginPage.class);

    }

    @Step("Нажатие на кнопку Войти в аккаунт")
    public LoginPage loginWithButton() {
        this.inAccountButton.click();
        return page(LoginPage.class);

    }

    public boolean isCreateOrderButton() {
        return createOrderButton.isEnabled();
    }

    public boolean isInAccountButton() {
        return inAccountButton.isEnabled();
    }

    @Step("Нажатие на список соусов")
    public boolean isSaucesSection() {
        this.sauces.click();
        return saucesInList.isEnabled();

    }

    @Step("Нажатие на список начинок")
    public StellarBurgersPage fillingsSection() {
        this.fillings.click();
        return page(StellarBurgersPage.class);

    }

    public boolean isFillingsSection() {
        this.fillings.click();
        return fillingsInList.isEnabled();

    }

    @Step("Нажатие на список булок")
    public boolean isRollsSection() {
        this.rolls.click();
        return rollsInList.isEnabled();

    }

}

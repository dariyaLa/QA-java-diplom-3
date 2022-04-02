package ru.yandex.praktikum.pageobjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class RegisterPage {

    @FindBy(how = How.XPATH, using = ".//label[text()='Имя']/following-sibling::input")
    private SelenideElement name;

    @FindBy(how = How.XPATH, using = ".//label[text()='Email']/following-sibling::input")
    private SelenideElement email;

    @FindBy(how = How.XPATH, using = ".//label[text()='Пароль']/following-sibling::input")
    private SelenideElement password;

    @FindBy(how = How.XPATH, using = ".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']")
    private SelenideElement registerButton;

    @FindBy(how = How.XPATH, using = ".//p[@class='input__error text_type_main-default']")
    private SelenideElement incorrectPassword;

    @FindBy(how = How.XPATH, using = ".//a[@class='Auth_link__1fOlj']")
    private SelenideElement loginLink;

    @Step("Ввод данных для регистрации")
    public RegisterPage registerSetInfo(int countPassword) {
        this.name.setValue(RandomStringUtils.randomAlphabetic(10));
        this.email.setValue(RandomStringUtils.randomAlphabetic(10) + "@yandex.ru");
        this.password.setValue(RandomStringUtils.randomAlphabetic(countPassword));
        return page(RegisterPage.class);

    }

    @Step("Нажатие на кнопку Войти")
    public LoginPage click() {
        this.registerButton.click();
        return page(LoginPage.class);
    }

    @Step("Нажатие на кнопку Войти")
    public RegisterPage clickFail() {
        this.registerButton.click();
        return page(RegisterPage.class);
    }

    public boolean isIncorrectPassword() {
        return incorrectPassword.isDisplayed();
    }

    @Step("Нажатие на линк Войти")
    public LoginPage loginLinkClick() {
        this.loginLink.click();
        return page(LoginPage.class);
    }

}


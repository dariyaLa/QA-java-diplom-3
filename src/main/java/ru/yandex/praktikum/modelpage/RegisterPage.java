package ru.yandex.praktikum.modelpage;

import com.codeborne.selenide.SelenideElement;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class RegisterPage {

    //name
    @FindBy(how = How.XPATH, using = ".//label[text()='Имя']/following-sibling::input")
    private SelenideElement name;

    //email
    @FindBy(how = How.XPATH, using = ".//label[text()='Email']/following-sibling::input")
    private SelenideElement email;

    //password
    @FindBy(how = How.XPATH, using = ".//label[text()='Пароль']/following-sibling::input")
    private SelenideElement password;

    //registerButton
    @FindBy(how = How.XPATH, using = ".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']")
    private SelenideElement registerButton;

    //error password
    @FindBy(how = How.XPATH, using = ".//p[@class='input__error text_type_main-default']")
    private SelenideElement incorrectPassword;

    @FindBy(how = How.XPATH, using = ".//a[@class='Auth_link__1fOlj']")
    private SelenideElement loginLink;


    public RegisterPage registerSetInfo(int countPassword) {
        this.name.setValue(RandomStringUtils.randomAlphabetic(10));
        this.email.setValue(RandomStringUtils.randomAlphabetic(10) + "@yandex.ru");
        this.password.setValue(RandomStringUtils.randomAlphabetic(countPassword));
        return page(RegisterPage.class);

    }

    public LoginPage click() {
        this.registerButton.click();
        return page(LoginPage.class);
    }

    public RegisterPage clickFail() {
        this.registerButton.click();
        return page(RegisterPage.class);
    }

    public boolean isIncorrectPassword() {
        return incorrectPassword.isDisplayed();
    }

    public LoginPage loginLinkClick() {
        this.loginLink.click();
        return page(LoginPage.class);
    }

}


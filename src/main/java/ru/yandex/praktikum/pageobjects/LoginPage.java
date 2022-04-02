package ru.yandex.praktikum.pageobjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.page;

public class LoginPage {

    @FindBy(how = How.XPATH, using = ".//label[text()='Email']/following-sibling::input")
    private SelenideElement email;

    @FindBy(how = How.XPATH, using = ".//label[text()='Пароль']/following-sibling::input")
    private SelenideElement password;

    @FindBy(how = How.XPATH, using = ".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']")
    private SelenideElement loginButton;

    @FindBy(how = How.XPATH, using = ".//a[@class='Auth_link__1fOlj']")
    private SelenideElement registerLink;

    @FindBy(how = How.XPATH, using = ".//a[@class='Auth_link__1fOlj'][text()='Восстановить пароль']")
    private SelenideElement recoveryPasswordLink;

    @FindBy(how = How.XPATH, using = ".//p[@class='AppHeader_header__linkText__3q_va ml-2'][text()='Конструктор']")
    private SelenideElement constructorButton;

    @FindBy(how = How.XPATH, using = ".//div[@class='AppHeader_header__logo__2D0X2']")
    private SelenideElement logo;

    @FindBy(how = How.XPATH, using = ".//button[@class='Account_button__14Yp3 text text_type_main-medium text_color_inactive']")
    private SelenideElement logoutButton;

    @Step("Авторизация")
    public StellarBurgersPage login(String email, String password) {
        this.email.shouldBe(enabled).setValue(email);
        this.password.setValue(password);
        this.loginButton.click();
        return page(StellarBurgersPage.class);

    }

    @Step("Переход к регистрации")
    public RegisterPage goRegistr() {
        this.registerLink.click();
        return page(RegisterPage.class);

    }

    public boolean isLoginButton() {
        return loginButton.isDisplayed();
    }

    @Step("Нажатие на линк Восстановление пароля")
    public RecoveryPasswordPage goRecoveryPassword() {
        this.recoveryPasswordLink.click();
        return page(RecoveryPasswordPage.class);

    }

    @Step("Нажатие на кнопку Конструктор")
    public StellarBurgersPage constructorButtonClick() {
        this.constructorButton.click();
        return page(StellarBurgersPage.class);

    }

    @Step("Нажатие на лого")
    public StellarBurgersPage logoClick() {
        this.logo.click();
        return page(StellarBurgersPage.class);

    }

    @Step("Выход из акканунта")
    public LoginPage logoutClick() {
        this.logoutButton.click();
        return page(LoginPage.class);

    }

}

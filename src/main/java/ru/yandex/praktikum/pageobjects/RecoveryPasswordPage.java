package ru.yandex.praktikum.pageobjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import ru.yandex.praktikum.pageobjects.LoginPage;

import static com.codeborne.selenide.Selenide.page;

public class RecoveryPasswordPage {

    @FindBy(how = How.XPATH, using = ".//label[text()='Email']/following-sibling::input")
    private SelenideElement email;

    @FindBy(how = How.XPATH, using = ".//button[text()='Восстановить']")
    private SelenideElement recoveryPasswordButton;

    @FindBy(how = How.XPATH, using = ".//a[@class='Auth_link__1fOlj']")
    private SelenideElement loginLink;

    @Step("Нажатие на линк Войти")
    public LoginPage loginLinkClick() {
        this.loginLink.click();
        return page(LoginPage.class);
    }

}

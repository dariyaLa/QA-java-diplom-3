package ru.yandex.praktikum.modelpage;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class RecoveryPasswordPage {

    //email
    @FindBy(how = How.XPATH, using = ".//label[text()='Email']/following-sibling::input")
    private SelenideElement email;

    @FindBy(how = How.XPATH, using = ".//button[text()='Восстановить']")
    private SelenideElement recoveryPasswordButton;

    @FindBy(how = How.XPATH, using = ".//a[@class='Auth_link__1fOlj']")
    private SelenideElement loginLink;

    public LoginPage loginLinkClick() {
        this.loginLink.click();
        return page(LoginPage.class);
    }

}

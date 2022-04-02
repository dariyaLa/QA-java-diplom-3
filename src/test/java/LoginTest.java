import com.UserOperations;
import org.junit.After;
import org.junit.Test;
import io.qameta.allure.junit4.DisplayName;
import ru.yandex.praktikum.pageobjects.StellarBurgersPage;

import java.util.Map;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

public class LoginTest {

    UserOperations userOperations = new UserOperations();
    Map<String, String> userInfo = userOperations.register();
    String email = userInfo.get("email");
    String password = userInfo.get("password");


    @After
    public void quitDriver() {
        open(StellarBurgersPage.URL, StellarBurgersPage.class)
                .inLK()
                .logoutClick();
    }

    @Test
    @DisplayName("Вход по кнопке Войти в аккаунт")
    public void loginWithButton() {

        boolean isLogin = open(StellarBurgersPage.URL, StellarBurgersPage.class)
                .loginWithButton()
                .login(email, password)
                .isCreateOrderButton();
        assertTrue("Ошибка аутентификации", isLogin);
    }

    @Test
    @DisplayName("Вход по кнопке Личный кабинет")
    public void loginInLK() {

        boolean isLogin = open(StellarBurgersPage.URL, StellarBurgersPage.class)
                .inLK()
                .login(email, password)
                .isCreateOrderButton();
        assertTrue("Ошибка аутентификации", isLogin);
    }

    @Test
    @DisplayName("Вход по кнопке В форме регистрации")
    public void loginInRegisterForm() {

        boolean isLogin = open(StellarBurgersPage.URL, StellarBurgersPage.class)
                .inLK()
                .goRegistr()
                .loginLinkClick()
                .login(email, password)
                .isCreateOrderButton();
        assertTrue("Ошибка аутентификации", isLogin);
    }

    @Test
    @DisplayName("Вход по кнопке на форме восстановелния пароля")
    public void loginInRecoveryPasswordForm() {

        boolean isLogin = open(StellarBurgersPage.URL, StellarBurgersPage.class)
                .inLK()
                .goRecoveryPassword()
                .loginLinkClick()
                .login(email, password)
                .isCreateOrderButton();
        assertTrue("Ошибка аутентификации", isLogin);
    }

}

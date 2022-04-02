import org.junit.Test;
import io.qameta.allure.junit4.DisplayName;
import ru.yandex.praktikum.pageobjects.StellarBurgersPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

public class RegisterTest {

    int correctCountPassword = 6;
    int incorrectcountPassword = 5;

    @Test
    @DisplayName("Пользователь может зарегистрироваться")
    public void register() {

        boolean isRegisteredUser = open(StellarBurgersPage.URL, StellarBurgersPage.class)
                .inLK()
                .goRegistr()
                .registerSetInfo(correctCountPassword)
                .click()
                .isLoginButton();

        assertTrue("Ошибка регистрации или элемент не отображается - кнопка Войти", isRegisteredUser);
    }

    @Test
    @DisplayName("Пользователь не может зарегистрировать с паролем меньше 6 символов")
    public void registerWithIncorrectPassword() {

        boolean isRegisteredUser = open(StellarBurgersPage.URL, StellarBurgersPage.class) //boolean isRegister =
                .inLK()
                .goRegistr()
                .registerSetInfo(incorrectcountPassword)
                .clickFail()
                .isIncorrectPassword();

        assertTrue("Ошибка некорректного пароля не отображается", isRegisteredUser);
    }
}
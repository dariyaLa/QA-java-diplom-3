import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.yandex.praktikum.pageobjects.StellarBurgersPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

public class InConstructorTest {

    @Test
    @DisplayName("Переход из ЛК в конструтор по кнопке Конструктор")
    public void inConstructorButton () {

        boolean inConstructor = open(StellarBurgersPage.URL, StellarBurgersPage.class)
                .inLK()
                .constructorButtonClick()
                .isInAccountButton();

        assertTrue("Ошибка перехода или отсутсвует элемент - кнопка Войти в аккаунт", inConstructor);
    }

    @Test
    @DisplayName("Переход из ЛК в конструтор по лого")
    public void inConstructorLogo () {

        boolean inConstructor = open(StellarBurgersPage.URL, StellarBurgersPage.class)
                .inLK()
                .logoClick()
                .isInAccountButton();

        assertTrue("Ошибка перехода или отсутсвует элемент - кнопка Войти в аккаунт", inConstructor);
    }
}

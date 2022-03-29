import com.UserOperations;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.yandex.praktikum.modelpage.StellarBurgersPage;

import java.util.Map;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

public class LogoutTest {

    UserOperations userOperations = new UserOperations();
    Map<String, String> userInfo = userOperations.register();
    String email = userInfo.get("email");
    String password = userInfo.get("password");

    @Test
    @DisplayName("Выход из аккаунта")
    public void logout() {

        boolean isLogin = open(StellarBurgersPage.URL, StellarBurgersPage.class)
                .inLK()
                .login(email, password)
                .inLK()
                .logoutClick()
                .isLoginButton();

        assertTrue("Ошибка выхода из аккаунта или элемент не отображается - кнопка Войти", isLogin);
    }
}

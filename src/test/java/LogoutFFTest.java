import com.UserOperations;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.yandex.praktikum.pageobjects.StellarBurgersPage;

import java.util.Map;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;
import static org.junit.Assert.assertTrue;

public class LogoutFFTest {

    UserOperations userOperations = new UserOperations();
    Map<String, String> userInfo = userOperations.register();
    String email = userInfo.get("email");
    String password = userInfo.get("password");
    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver","/Users/daralavrenteva/Desktop/gecko/geckodriver");
        driver = new FirefoxDriver();
        setWebDriver(driver);
    }

    @After
    public void quitDriver() {
        driver.quit();
    }

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


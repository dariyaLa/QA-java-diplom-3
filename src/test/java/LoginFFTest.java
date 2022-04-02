import com.UserOperations;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import io.qameta.allure.junit4.DisplayName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.yandex.praktikum.pageobjects.StellarBurgersPage;

import java.util.Map;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;
import static org.junit.Assert.assertTrue;

public class LoginFFTest {

    UserOperations userOperations = new UserOperations();
    Map<String, String> userInfo = userOperations.register();
    String email = userInfo.get("email");
    String password = userInfo.get("password");
    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "/Users/daralavrenteva/Desktop/gecko/geckodriver");
        driver = new FirefoxDriver();
        setWebDriver(driver);
    }

    @After
    public void quitDriver() {
        driver.quit();
    }


    @Test
    @DisplayName("Вход по кнопке Войти в аккаунт (FF)")
    public void loginWithButton() {

        boolean isLogin = open(StellarBurgersPage.URL, StellarBurgersPage.class)
                .loginWithButton()
                .login(email, password)
                .isCreateOrderButton();
        assertTrue("Ошибка аутентификации", isLogin);
    }

    @Test
    @DisplayName("Вход по кнопке Личный кабинет (FF)")
    public void loginInLK() {

        boolean isLogin = open(StellarBurgersPage.URL, StellarBurgersPage.class)
                .inLK()
                .login(email, password)
                .isCreateOrderButton();
        assertTrue("Ошибка аутентификации", isLogin);
    }

    @Test
    @DisplayName("Вход по кнопке В форме регистрации (FF)")
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
    @DisplayName("Вход по кнопке на форме восстановелния пароля (FF)")
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

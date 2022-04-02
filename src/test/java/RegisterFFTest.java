import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import io.qameta.allure.junit4.DisplayName;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import ru.yandex.praktikum.pageobjects.StellarBurgersPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;
import static org.junit.Assert.assertTrue;

public class RegisterFFTest {

    int correctCountPassword = 6;
    int incorrectcountPassword = 5;
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
    @DisplayName("Пользователь может зарегистрироваться (FF)")
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
    @DisplayName("Пользователь не может зарегистрировать с паролем меньше 6 символов (FF)")
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

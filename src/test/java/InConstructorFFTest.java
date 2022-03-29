import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.yandex.praktikum.modelpage.StellarBurgersPage;


import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;
import static org.junit.Assert.assertTrue;

public class InConstructorFFTest {

    WebDriver driver;

    @Before
    public void setUp() {
        //WebDriverManager.firefoxdriver().setup();
        //FirefoxOptions options = new FirefoxOptions();
        //driver = new FirefoxDriver(options);
        //setWebDriver(driver);
        System.setProperty("webdriver.gecko.driver", "/Users/daralavrenteva/Desktop/gecko/geckodriver");
        driver = new FirefoxDriver();
        setWebDriver(driver);

    }

    @After
    public void quitDriver() {
        driver.quit();
    }

    @Test
    @DisplayName("Переход из ЛК в конструтор по кнопке Конструктор (FF)")
    public void inConstructorButton() {

        boolean inConstructor = open(StellarBurgersPage.URL, StellarBurgersPage.class)
                .inLK()
                .constructorButtonClick()
                .isInAccountButton();

        assertTrue("Ошибка перехода или отсутсвует элемент - кнопка Войти в аккаунт", inConstructor);
    }

    @Test
    @DisplayName("Переход из ЛК в конструтор по лого (FF)")
    public void inConstructorLogo() {

        boolean inConstructor = open(StellarBurgersPage.URL, StellarBurgersPage.class)
                .inLK()
                .logoClick()
                .isInAccountButton();

        assertTrue("Ошибка перехода или отсутсвует элемент - кнопка Войти в аккаунт", inConstructor);
    }
}


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

public class SectionStellarBurgersFFTest {

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
    @DisplayName("Пользователь нажимает на раздел Соусы - отображаются соусы (FF)")
    public void sectionSauces() {

        boolean isSaucesSection = open(StellarBurgersPage.URL, StellarBurgersPage.class)
                .isSaucesSection();

        assertTrue("Список соусов не отображается", isSaucesSection);
    }

    @Test
    @DisplayName("Пользователь нажимает на раздел Начинки - отображаются начинки (FF)")
    public void sectionFillings() {

        boolean isFillingsSection = open(StellarBurgersPage.URL, StellarBurgersPage.class)
                .isFillingsSection();

        assertTrue("Список начинок не отображается", isFillingsSection);
    }

    @Test
    @DisplayName("Пользователь нажимает на раздел Булки - отображаются булки (FF)")
    public void sectionRolls() {

        boolean isRollsSection = open(StellarBurgersPage.URL, StellarBurgersPage.class)
                .fillingsSection()
                .isRollsSection();

        assertTrue("Список булок не отображается", isRollsSection);
    }
}


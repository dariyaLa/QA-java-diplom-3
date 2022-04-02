import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.yandex.praktikum.pageobjects.StellarBurgersPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

public class SectionStellarBurgersTest {

    @Test
    @DisplayName("Пользователь нажимает на раздел Соусы - отображаются соусы")
    public void sectionSauces() {

        boolean isSaucesSection = open(StellarBurgersPage.URL, StellarBurgersPage.class)
                .isSaucesSection();

        assertTrue("Список соусов не отображается", isSaucesSection);
    }

    @Test
    @DisplayName("Пользователь нажимает на раздел Начинки - отображаются начинки")
    public void sectionFillings() {

        boolean isFillingsSection = open(StellarBurgersPage.URL, StellarBurgersPage.class)
                .isFillingsSection();

        assertTrue("Список начинок не отображается", isFillingsSection);
    }

    @Test
    @DisplayName("Пользователь нажимает на раздел Булки - отображаются булки")
    public void sectionRolls() {

        boolean isRollsSection = open(StellarBurgersPage.URL, StellarBurgersPage.class)
                .fillingsSection()
                .isRollsSection();

        assertTrue("Список булок не отображается", isRollsSection);
    }
}

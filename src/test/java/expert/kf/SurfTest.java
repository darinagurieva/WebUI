package expert.kf;

// test suite:
// 1) зайти на страницу
// 2) кликнуть на кнопку О компании (kf.expert/about)
// 3) Title =  О компании
// 4) кликнуть на кнопку Аналитика (kf.expert/publish)
// 5) Title = Аналитические отчеты
// 6) кликнуть на кнопку Стать партнером (kf.expert/zaraboytayte-s-knight-frank)
// 7) Title = Зарабатывайте вместе с Knight Frank!
// 8) driver.quit();

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

public class SurfTest extends AbstractClass {

    @Test
    @DisplayName("Ссылки в хедере")
    @Description("Проверка кликабельности и совпадения тайтлов")
    @Severity(SeverityLevel.NORMAL)
    public void SurfIt() {
        super.init();
        new SurfTestMain(getDriver()).goToAbout();
        Assertions.assertTrue(getDriver().getTitle().contains("О компании."), "Wrong page!");
        new SurfTestMain(getDriver()).goToPublish();
        Assertions.assertTrue(getDriver().getTitle().contains("Аналитика по рынку недвижимости — Knight Frank"), "Wrong page!");
        new SurfTestMain(getDriver()).goToPartner();
        Assertions.assertTrue(getDriver().getTitle().contains("Зарабатывайте на недвижимости — партнерская программа Knight Frank"), "Wrong page!");
    }
}
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

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class SurfTest extends AbstractClass {

    @Test
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
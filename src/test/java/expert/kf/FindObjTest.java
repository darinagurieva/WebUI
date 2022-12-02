package expert.kf;

// test suite:
// 1) зайти на страницу
// 2) найти строку поиска в фильтре
// 3) ввести Badaevskiy\n
// 4) нажать Показать
// 5) URL содержит Badaevsky
// 6) driver.quit();

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class FindObjTest extends AbstractClass {

    @Test
    public void FindIt() {
        super.init();
        new FindObjMain(getDriver()).inputSearch();
        new FindObjMain(getDriver()).clickVar();
        new FindObjMain(getDriver()).clickShow();
        Assertions.assertTrue(getDriver().getCurrentUrl().contains("20BADAEVSKIY"), "Wrong request!");
    }
}
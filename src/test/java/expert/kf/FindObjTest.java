package expert.kf;

// test suite:
// 1) зайти на страницу
// 2) найти строку поиска в фильтре
// 3) ввести Badaevskiy\n
// 4) нажать Показать
// 5) URL содержит Badaevsky
// 6) driver.quit();

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

public class FindObjTest extends AbstractClass {

    @Test
    @DisplayName("Поиск объекта")
    @Description("Поиск объекта по названию через поисковую строку в фильтре")
    @Severity(SeverityLevel.CRITICAL)
    public void FindIt() {
        super.init();
        new FindObjMain(getDriver()).inputSearch();
        new FindObjMain(getDriver()).clickVar();
        new FindObjMain(getDriver()).clickShow();
        Assertions.assertTrue(getDriver().getCurrentUrl().contains("20BADAEVSKIY"), "Wrong request!");
    }
}
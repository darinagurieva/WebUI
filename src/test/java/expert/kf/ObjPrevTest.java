package expert.kf;

// test suite:
// 1) зайти на страницу
// 2) кликнуть на кнопку Показать
// 3) Title =  Элитная недвижимость в Москве — продажа элитного жилья в агентстве KF.expert
// 4) проскроллить до первого объекта в списке
// 5) нажать стрелочку вправо
// 6) проверка на кликабельность
// 7) нажать стрелочку влево
// 8) проверка на кликабельность
// 9) driver.quit();

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;

public class ObjPrevTest extends AbstractClass {

    @Test
    public void ScrollIt() {
        super.init();
        new ObjPrevMain(getDriver()).clickShow();
        Assertions.assertTrue(getDriver().getCurrentUrl().contains("/gorod/prodazha"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        new ObjPrevMain(getDriver()).rightScroll();
        Assertions.assertNotNull(getDriver().findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[5]/div[2]/div[1]/div[2]/a/div/div[4]")));
        new ObjPrevMain(getDriver()).leftScroll();
        Assertions.assertNotNull(getDriver().findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[5]/div[2]/div[1]/div[2]/a/div/div[3]")));
    }
}
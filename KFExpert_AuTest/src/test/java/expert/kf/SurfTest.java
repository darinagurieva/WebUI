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
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SurfTest extends AbstractClass {

    @Test
    public void myActionTest() throws InterruptedException {
        super.init();
        System.out.println(super.getDriver());
        WebDriverWait wait = new WebDriverWait(getDriver(),10);
        wait.until(ExpectedConditions.urlContains("expert"));
        Assertions.assertTrue(getDriver().getTitle().contains("Агентство элитной недвижимости в Москве"), "страница недоступна");
        // Создадим экземпляр класса Actions
        Actions act1 = new Actions(getDriver());

        act1.click(getDriver().findElement(By.xpath("/html/body/header/div[1]/div[2]/ul/li[1]/a/span")))
                .pause(1000l)
                .build()
                .perform();
        Assertions.assertTrue(getDriver().getTitle().contains("О компании."), "Wrong page!");

        Actions act2 = new Actions(getDriver());

        act2.click(getDriver().findElement(By.xpath("/html/body/header/div[1]/div[2]/ul/li[2]/a/span")))
                .pause(1000l)
                .build()
                .perform();
        Assertions.assertTrue(getDriver().getTitle().contains("Аналитика по рынку недвижимости — Knight Frank"), "Wrong page!");

        Actions act3 = new Actions(getDriver());

        act3.click(getDriver().findElement(By.xpath("/html/body/header/div[1]/div[2]/ul/li[4]/a/span")))
                .pause(1000l)
                .build()
                .perform();
        Assertions.assertTrue(getDriver().getTitle().contains("Зарабатывайте на недвижимости — партнерская программа Knight Frank"), "Wrong page!");

        Thread.sleep(1000);

        //driver.quit();
    }
}

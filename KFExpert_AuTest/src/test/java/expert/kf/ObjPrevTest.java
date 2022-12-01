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

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ObjPrevTest extends AbstractClass {

    @Test
    public void myActionTest() throws InterruptedException {
        super.init();
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.urlContains("expert"));
        Assertions.assertTrue(getDriver().getTitle().contains("Агентство элитной недвижимости в Москве"), "страница недоступна");
        // Создадим экземпляр класса Actions
        Actions act1 = new Actions(getDriver());
        act1.click(getDriver().findElement(By.xpath("/html/body/div[2]/div[1]/div/div[3]/div[2]/form/div/div[3]/div[2]/button")))
                .pause(1000l)
                .build()
                .perform();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");

        Actions act2 = new Actions(getDriver());
        act2.click(getDriver().findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[5]/div[2]/div[1]/div[2]/a/div/div[4]")))
                .pause(1000l)
                .build()
                .perform();
        Assertions.assertNotNull(getDriver().findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[5]/div[2]/div[1]/div[2]/a/div/div[4]")));

        Actions act3 = new Actions(getDriver());
        act3.click(getDriver().findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[5]/div[2]/div[1]/div[2]/a/div/div[3]")))
                .pause(1000l)
                .build()
                .perform();
        Assertions.assertNotNull(getDriver().findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[5]/div[2]/div[1]/div[2]/a/div/div[3]")));
    }
    }
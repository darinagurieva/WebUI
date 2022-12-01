package expert.kf;

// test suite:
// 1) зайти на страницу
// 2) найти строку поиска в фильтре
// 3) ввести Badaevskiy\n
// 4) нажать Показать
// 5) Элемент содержит Badaevsky
// 6) driver.quit();

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

public class FindObjTest extends AbstractClass {

    @Test
    public void myActionTest() throws InterruptedException {
        super.init();
        WebDriverWait wait = new WebDriverWait(getDriver(),10);
        wait.until(ExpectedConditions.urlContains("expert"));
        Assertions.assertTrue(getDriver().getTitle().contains("Агентство элитной недвижимости в Москве"), "страница недоступна");
        // Создадим экземпляр класса Actions
        Actions act1 = new Actions(getDriver());
        act1.sendKeys(getDriver().findElement(By.xpath("/html/body/div[2]/div[1]/div/div[3]/div[2]/form/div/div[1]/div[7]/div[1]/input")), "Бадаевский")
                .pause(1000l)
                .build()
                .perform();
        //Assertions.assertTrue(getDriver().getTitle().contains("О компании."), "Wrong page!");

        Actions act4 = new Actions(getDriver());
        act4.click(getDriver().findElement(By.xpath("/html/body/div[2]/div[1]/div/div[3]/div[2]/form/div/div[1]/div[7]/div[2]/div/div[1]/div[2]/div[2]/span")))
                .pause(1000l)
                .build()
                .perform();

        Actions act2 = new Actions(getDriver());
        act2.click(getDriver().findElement(By.xpath("/html/body/div[2]/div[1]/div/div[3]/div[2]/form/div/div[3]/div[2]/button/span")))
                .pause(1000l)
                .build()
                .perform();

        Actions act3 = new Actions(getDriver());
        act3.moveToElement(getDriver().findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[5]/div[2]/div[1]/div[3]/div[1]/div[3]/a")))
                .pause(1000l)
                .build()
                .perform();

        Assertions.assertTrue(getDriver().getCurrentUrl().contains("20BADAEVSKIY"), "Wrong request!");

                //findElements(By.xpath("/html/body/div[2]/div[1]/div[1]/div[5]/div[2]/div[1]/div[3]/div[1]/div[3]/a")).contains("BADAEVSKIY"), "Wrong request!");

        Thread.sleep(1000);

        //driver.quit();
    }
}
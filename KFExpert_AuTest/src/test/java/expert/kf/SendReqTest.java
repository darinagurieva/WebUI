package expert.kf;

// test suite:
// 1) зайти на страницу
// 2) кликнуть на кнопку callback
// 3) Имя = тест
// 4) номер = 9999999999
// 5) email = darrrrrrrrina@mail.ru
// 6) нажать Отправить
// 7) driver.quit();

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

public class SendReqTest extends AbstractClass {

    @Test
    public void myActionTest() throws InterruptedException {
        super.init();
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.urlContains("expert"));
        Assertions.assertTrue(getDriver().getTitle().contains("Агентство элитной недвижимости в Москве"), "страница недоступна");
        // Создадим экземпляр класса Actions
        Actions act1 = new Actions(getDriver());
        act1.click(getDriver().findElement(By.xpath("/html/body/header/div[2]/div[1]/div[3]/div[2]/div/span")))
                .pause(1000l)
                .build()
                .perform();

        Actions act2 = new Actions((getDriver()));
        act2.sendKeys(getDriver().findElement(By.xpath("/html/body/div[2]/div[19]/div/div[2]/div/div/div/form/div[1]/div/input")), "test")
                .pause(1000l)
                .build()
                .perform();

        Actions act3 = new Actions((getDriver()));
        act3.sendKeys(getDriver().findElement(By.xpath("/html/body/div[2]/div[19]/div/div[2]/div/div/div/form/div[2]/div/div/input")), "9999999999")
                .pause(1000l)
                .build()
                .perform();

        Actions act4 = new Actions(getDriver());
        act4.sendKeys(getDriver().findElement(By.xpath("/html/body/div[2]/div[19]/div/div[2]/div/div/div/form/div[3]/div/input")), "darrrrrrrrina@mail.ru")
                .pause(1000l)
                .build()
                .perform();

        Actions act5 = new Actions(getDriver());
        act5.click(getDriver().findElement(By.xpath("/html/body/div[2]/div[19]/div/div[2]/div/div/div/form/div[11]/button")))
                .pause(1000l)
                .build()
                .perform();

        Assertions.assertNotNull(getDriver().getTitle().contains("Спасибо!"), "Wrong request!");

        Thread.sleep(1000);

        //driver.quit();
    }
}
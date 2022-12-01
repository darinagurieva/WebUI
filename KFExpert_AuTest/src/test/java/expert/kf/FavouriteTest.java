package expert.kf;
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

public class FavouriteTest extends AbstractClass {

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

        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("window.scrollBy(0,600)", "");

        Actions act2 = new Actions(getDriver());
        act2.click(getDriver().findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[5]/div[2]/div[2]/div[1]/span[3]")))
                .pause(1000l)
                .build()
                .perform();

        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("window.scrollBy(0,-600)", "");

        Actions act3 = new Actions(getDriver());
        act3.click(getDriver().findElement(By.xpath("/html/body/header/div[1]/div[3]/a[1]/span")))
                .pause(1000l)
                .build()
                .perform();

        JavascriptExecutor js3 = (JavascriptExecutor) driver;
        js3.executeScript("window.scrollBy(0,600)", "");

        Actions act4 = new Actions(getDriver());
        act4.click(getDriver().findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div[1]/div[3]/div[3]/div[2]/button/span")))
                .pause(1000l)
                .build()
                .perform();
        Assertions.assertNotNull(getDriver().findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div[1]/div[3]/div[3]/div[2]/button/span")), "List is Empty!");

    }
}

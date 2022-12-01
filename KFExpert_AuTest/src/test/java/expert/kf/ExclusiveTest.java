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

public class ExclusiveTest extends AbstractClass {

    @Test
    public void myActionTest() throws InterruptedException {
        super.init();
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.urlContains("expert"));
        Assertions.assertTrue(getDriver().getTitle().contains("Агентство элитной недвижимости в Москве"), "страница недоступна");
        // Создадим экземпляр класса Actions
        Actions act1 = new Actions(getDriver());
        act1.click(getDriver().findElement(By.xpath("/html/body/div[2]/div[1]/div/div[3]/div[2]/form/div/div[3]/div[1]/button")))
                .pause(1000l)
                .build()
                .perform();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1500)", "");

        Actions act2 = new Actions(getDriver());
        act2.click(getDriver().findElement(By.xpath("/html/body/div[2]/div[1]/div/div[3]/div[2]/form/div/div[2]/div[4]/div[2]/div[1]/div[2]/div/div[4]/label")))
                .pause(1000l)
                .build()
                .perform();

        Actions act3 = new Actions(getDriver());
        act3.click(getDriver().findElement(By.xpath("/html/body/div[2]/div[1]/div/div[3]/div[2]/form/div/div[3]/div[2]/button")))
                .pause(1000l)
                .build()
                .perform();

        Assertions.assertTrue(getDriver().getCurrentUrl().contains("&addit_ids=4"), "Wrong request!");
        Thread.sleep(1000);

        // driver.quit();
    }
}

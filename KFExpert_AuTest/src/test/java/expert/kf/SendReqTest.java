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
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SendReqTest {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver"
        );

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://kf.expert");

        Dimension d = new Dimension(1440, 789);
        driver.manage().window().setSize(d);

        WebElement webElement1 = driver.findElement(By.xpath("/html/body/header/div[2]/div[1]/div[3]/div[2]/div"));
        try {
            WebElement webElementError = driver.findElement(By.xpath("error"));
        } catch (NoSuchElementException e) {
            System.out.println(e.getSupportUrl());
        }

        List<WebElement> webElements = driver.findElements(By.xpath("/html/body/div[2]/div[1]/div/div[3]/div[2]/form/div/div[3]/div[2]/button/span"));
        if (webElements.size() > 1) {
            System.out.println("ERROR!");
            driver.quit();
        }

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new WebDriverWait(driver, 5).until(ExpectedConditions.urlContains("expert"));

        try {
            webElement1.click();
        } catch (StaleElementReferenceException e) {
            System.out.println(e.getSupportUrl());
        }

        WebElement webElement2 = driver.findElement(By.xpath("/html/body/div[2]/div[19]/div/div[2]/div/div/div/form/div[1]/div/input"));
        try {
            webElement2.sendKeys("тест");
        } catch (StaleElementReferenceException e) {
            System.out.println(e.getSupportUrl());
        }

        WebElement webElement3 = driver.findElement(By.xpath("/html/body/div[2]/div[19]/div/div[2]/div/div/div/form/div[2]/div/div/input"));
        try {
            webElement3.sendKeys("9999999999");
        } catch (StaleElementReferenceException e) {
            System.out.println(e.getSupportUrl());
        }

        WebElement webElement4 = driver.findElement(By.xpath("/html/body/div[2]/div[19]/div/div[2]/div/div/div/form/div[3]/div/input"));
        try {
            webElement4.sendKeys("darrrrrrrrina@mail.ru");
        } catch (StaleElementReferenceException e) {
            System.out.println(e.getSupportUrl());
        }

        WebElement webElement5 = driver.findElement(By.xpath("/html/body/div[2]/div[19]/div/div[2]/div/div/div/form/div[11]/button"));
        try {
            webElement5.click();
        } catch (StaleElementReferenceException e) {
            System.out.println(e.getSupportUrl());
        }

        driver.quit();
    }
}

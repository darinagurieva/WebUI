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
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ObjPrevTest {
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

        WebElement webElement1 = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[3]/div[2]/form/div/div[3]/div[2]/button/span"));

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
        new WebDriverWait(driver, 5).until(ExpectedConditions.titleContains("Элитная недвижимость в Москве — продажа элитного жилья в агентстве KF.expert"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");

        WebElement webElement2 = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[5]/div[2]/div[1]/div[2]/a/div/div[4]"));

        try {
            webElement2.click();
        } catch (StaleElementReferenceException e) {
            System.out.println(e.getSupportUrl());
        }

        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(webElement2));

        WebElement webElement3 = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[5]/div[2]/div[1]/div[2]/a/div/div[3]"));

        try {
            webElement3.click();
        } catch (StaleElementReferenceException e) {
            System.out.println(e.getSupportUrl());
        }

        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(webElement3));

        driver.quit();
    }
}

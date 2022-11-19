package expert.kf;

// test suite:
// 1) зайти на страницу
// 2) кликнуть на кнопку О компании (kf.expert/about)
// 3) Title =  О компании
// 4) кликнуть на кнопку Аналитика (kf.expert/publish)
// 5) Title = Аналитические отчеты
// 6) кликнуть на кнопку Стать партнером (kf.expert/zaraboytayte-s-knight-frank)
// 7) Title = Зарабатывайте вместе с Knight Frank!
// 8) кликнуть по кнопке Wealth Report (kf.expert/wealthreport)
// 9) Title = The Wealth Report
// 10) driver.quit();

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

public class SurfTest {

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

        WebElement webElement1 = driver.findElement(By.xpath("/html/body/header/div[1]/div[2]/ul/li[1]/a/span"));

        try {
            WebElement webElementError = driver.findElement(By.xpath("error"));
        } catch (NoSuchElementException e){
            System.out.println(e.getSupportUrl());
        }

        List<WebElement> webElements = driver.findElements(By.xpath("/html/body/header/div[1]/div[2]/ul/li[1]/a/span"));
        if(webElements.size()>1){
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
        } catch (StaleElementReferenceException e){
            System.out.println(e.getSupportUrl());
        }
        new WebDriverWait(driver, 5).until(ExpectedConditions.titleContains("О компании"));

        WebElement webElement2 = driver.findElement(By.xpath("/html/body/header/div[1]/div[2]/ul/li[2]/a/span"));
        try {
            webElement2.click();
        } catch (StaleElementReferenceException e){
            System.out.println(e.getSupportUrl());
        }
        new WebDriverWait(driver, 5).until(ExpectedConditions.titleContains("Аналитика по рынку недвижимости"));

        WebElement webElement3 = driver.findElement(By.xpath("/html/body/header/div[1]/div[2]/ul/li[4]/a/span"));
        try {
            webElement3.click();
        } catch (StaleElementReferenceException e){
            System.out.println(e.getSupportUrl());
        }
        new WebDriverWait(driver, 5).until(ExpectedConditions.titleContains("Зарабатывайте на недвижимости — партнерская программа Knight Frank"));

        WebElement webElement4 = driver.findElement(By.xpath("/html/body/header/div[1]/div[2]/ul/li[5]/a/span"));
        try {
            webElement4.click();
        } catch (StaleElementReferenceException e){
            System.out.println(e.getSupportUrl());
        }
        new WebDriverWait(driver, 5).until(ExpectedConditions.titleContains("The Wealth Report 2021 | Knight Frank – исследование о тенденциях распределения благосостояния в мире и предпочтениях самых состоятельных людей в недвижимости."));

        driver.quit();
    }
}
package expert.kf;

// test suite:
// 1) зайти на страницу
// 2) найти строку поиска в фильтре
// 3) ввести Badaevskiy\n
// 4) нажать Показать
// 5) Элемент содержит Badaevsky
// 6) driver.quit();

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

public class FindObjTest {
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

        WebElement webElement1 = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[3]/div[2]/form/div/div[1]/div[7]/div[1]/input"));
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
            webElement1.sendKeys("Badaevskiy");
        } catch (StaleElementReferenceException e) {
            System.out.println(e.getSupportUrl());
        }

        WebElement webElement4 = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[3]/div[2]/form/div/div[1]/div[7]/div[2]/div/div[1]/div[2]/div[2]/span/span"));

        try {
            webElement4.click();
        } catch (StaleElementReferenceException e) {
            System.out.println(e.getSupportUrl());
        }

        WebElement webElement2 = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[3]/div[2]/form/div/div[3]/div[2]/button"));

        try {
            webElement2.click();
        } catch (StaleElementReferenceException e) {
            System.out.println(e.getSupportUrl());
        }

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)", "");

        WebElement webElement3 = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[5]/div[2]/div[1]/div[3]/div[2]/a"));
        new WebDriverWait(driver, 5).until(ExpectedConditions.textToBePresentInElement(webElement3,"BADAEVSKIY"));

        driver.quit();
    }
}

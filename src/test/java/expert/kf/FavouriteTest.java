package expert.kf;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.*;

public class FavouriteTest extends AbstractClass {

    @Test
    @DisplayName("Избранное")
    @Description("Проверка добавления объекта в избранное. Не залогиненный юзер.")
    @Severity(SeverityLevel.CRITICAL)
    public void FavIt() {
        super.init();
        new FavouriteMain(getDriver()).clickShow();
        Assertions.assertTrue(getDriver().getCurrentUrl().contains("/gorod"));
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("window.scrollBy(0,600)", "");
        new FavouriteMain(getDriver()).clickHeart();
        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("window.scrollBy(0,-600)", "");
        new FavouriteMain(getDriver()).clickFav();
        JavascriptExecutor js3 = (JavascriptExecutor) driver;
        js3.executeScript("window.scrollBy(0,600)", "");
        new FavouriteMain(getDriver()).clickCheckbox();
        Assertions.assertNotNull(getDriver().findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div[1]/div[3]/div[3]/div[2]/button/span")), "List is Empty!");
    }
}
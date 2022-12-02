package expert.kf;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;

public class ExclusiveTest extends AbstractClass {

    @Test
    public void Exclusive() {
        super.init();
        new ExclusiveMain(getDriver()).clickFilters();
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("window.scrollBy(0,1500)", "");
        new ExclusiveMain(getDriver()).labelClick();
        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("window.scrollBy(0,-1500)", "");
        new ExclusiveMain(getDriver()).clickShow();
        Assertions.assertTrue(getDriver().getCurrentUrl().contains("&addit_ids=4"), "Wrong request!");
    }
}
package expert.kf;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExclusiveMain extends AbstractPage {

    @FindBy (xpath = "/html/body/div[2]/div[1]/div/div[3]/div[2]/form/div/div[3]/div[1]/button")
    public WebElement filters;

    @FindBy (xpath = "/html/body/div[2]/div[1]/div/div[3]/div[2]/form/div/div[2]/div[4]/div[2]/div[1]/div[2]/div/div[4]/label")
    public WebElement label_exclusive;

    @FindBy (xpath = "/html/body/div[2]/div[1]/div/div[3]/div[2]/form/div/div[3]/div[2]/button")
    public WebElement button_show;

    public ExclusiveMain(WebDriver driver) {
        super(driver);
    }

    public void clickFilters() {
        filters.click();
        new WebDriverWait(getDriver(), 2);
    }

    public void labelClick() {
        label_exclusive.click();
        new WebDriverWait(getDriver(), 2);
    }

    public void clickShow() {
        button_show.click();
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.urlContains("/gorod"));
    }
}

package expert.kf;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FavouriteMain extends AbstractPage {

    @FindBy (xpath = "/html/body/div[2]/div[1]/div/div[3]/div[2]/form/div/div[3]/div[2]/button")
    public WebElement button_show;

    @FindBy (xpath = "/html/body/div[2]/div[1]/div[1]/div[5]/div[2]/div[2]/div[1]/span[3]")
    public WebElement heart;

    @FindBy (xpath = "/html/body/header/div[1]/div[3]/a[1]/span")
    public WebElement favourite;

    @FindBy (xpath = "/html/body/div[2]/div[1]/div/div/div[1]/div[3]/div[3]/div[2]/button/span")
    public WebElement checkbox;

    public FavouriteMain(WebDriver driver) {
        super(driver);
    }

    public void clickShow() {
        button_show.click();
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.urlContains("/gorod"));
    }

    public void clickHeart() {
        heart.click();
        new WebDriverWait(getDriver(), 2);
    }

    public void clickFav() {
        favourite.click();
        new WebDriverWait(getDriver(), 5);
    }

    public void clickCheckbox() {
        checkbox.click();
        new WebDriverWait(getDriver(), 2);
    }
}

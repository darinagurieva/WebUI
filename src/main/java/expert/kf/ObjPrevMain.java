package expert.kf;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ObjPrevMain extends AbstractPage {

    @FindBy (xpath = "/html/body/div[2]/div[1]/div/div[3]/div[2]/form/div/div[3]/div[2]/button")
    public WebElement button_show;

    @FindBy (xpath = "/html/body/div[2]/div[1]/div[1]/div[5]/div[2]/div[1]/div[2]/a/div/div[4]")
    public static WebElement scroll_right;

    @FindBy (xpath = "/html/body/div[2]/div[1]/div[1]/div[5]/div[2]/div[1]/div[2]/a/div/div[3]")
    public WebElement scroll_left;


    public ObjPrevMain(WebDriver driver) {
        super(driver);
    }

    public void clickShow() {
        button_show.click();
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.urlContains("/gorod/prodazha"));
    }

    public void rightScroll() {
        scroll_right.click();
        new WebDriverWait(getDriver(), 2);
    }

    public void leftScroll() {
        scroll_left.click();
        new WebDriverWait(getDriver(), 2);
    }
}



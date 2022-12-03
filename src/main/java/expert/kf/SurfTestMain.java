package expert.kf;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SurfTestMain extends AbstractPage {

    @FindBy (xpath = "/html/body/header/div[1]/div[2]/ul/li[1]/a/span")
    public WebElement about;

    @FindBy (xpath = "/html/body/header/div[1]/div[2]/ul/li[2]/a/span")
    public WebElement publish;

    @FindBy (xpath = "/html/body/header/div[1]/div[2]/ul/li[4]/a/span")
    public WebElement partner;

    public SurfTestMain(WebDriver driver) {
        super(driver);
    }

    public void goToAbout() {
        about.click();
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.urlContains("/about"));
    }

    public void goToPublish() {
        publish.click();
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.urlContains("/publish"));
    }

    public void goToPartner() {
        partner.click();
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.urlContains("/zaraboytayte-s-knight-frank"));
    }
}

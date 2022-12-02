package expert.kf;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindObjMain extends AbstractPage {

    @FindBy (xpath = "/html/body/div[2]/div[1]/div/div[3]/div[2]/form/div/div[1]/div[7]/div[1]/input")
    public WebElement search_input;

    @FindBy (xpath = "/html/body/div[2]/div[1]/div/div[3]/div[2]/form/div/div[1]/div[7]/div[2]/div/div[1]/div[2]/div[2]/span")
    public WebElement var_click;

    @FindBy (xpath = "/html/body/div[2]/div[1]/div/div[3]/div[2]/form/div/div[3]/div[2]/button")
    public WebElement button_show;

    public FindObjMain(WebDriver driver) {
        super(driver);
    }

    public void inputSearch() {
        search_input.sendKeys("Badaevskiy");
        new WebDriverWait(getDriver(), 2);
    }

    public void clickVar() {
        var_click.click();
        new WebDriverWait(getDriver(), 2);
    }

    public void clickShow() {
        button_show.click();
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.urlContains("search?"));
    }
}

package expert.kf;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SendReqTestMain extends AbstractPage {

    @FindBy (xpath = "/html/body/header/div[2]/div[1]/div[3]/div[2]/div")
    public WebElement callme;

    @FindBy (xpath = "/html/body/div[2]/div[19]/div/div[2]/div/div/div/form/div[1]/div/input")
    public WebElement input_name;

    @FindBy (xpath = "/html/body/div[2]/div[19]/div/div[2]/div/div/div/form/div[2]/div/div/input")
    public WebElement input_phone;

    @FindBy (xpath = "/html/body/div[2]/div[19]/div/div[2]/div/div/div/form/div[3]/div/input")
    public WebElement input_mail;

    @FindBy (xpath = "/html/body/div[2]/div[19]/div/div[2]/div/div/div/form/div[11]/button")
    public WebElement button_submit;

    public SendReqTestMain(WebDriver driver) {
        super(driver);
    }

    public void clickCallMe() {
        callme.click();
        new WebDriverWait(getDriver(), 2);
    }

    public void printName() {
        input_name.sendKeys("test");
        new WebDriverWait(getDriver(), 2);
    }

    public void printPhone() {
        input_phone.sendKeys("9999999999");
        new WebDriverWait(getDriver(), 2);
    }

    public void printMail() {
        input_mail.sendKeys("darrrrrrrrina@mail.ru");
        new WebDriverWait(getDriver(), 2);
    }

    public void clickSubmit() {
        button_submit.click();
        new WebDriverWait(getDriver(), 2);
    }
}

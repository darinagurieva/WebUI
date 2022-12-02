package expert.kf;

// test suite:
// 1) зайти на страницу
// 2) кликнуть на кнопку callback
// 3) Имя = тест
// 4) номер = 9999999999
// 5) email = darrrrrrrrina@mail.ru
// 6) нажать Отправить
// 7) driver.quit();

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class SendReqTest extends AbstractClass {
    @Test
    public void SendIt() {
        super.init();
        new SendReqTestMain(getDriver()).clickCallMe();
        new SendReqTestMain(getDriver()).printName();
        new SendReqTestMain(getDriver()).printPhone();
        new SendReqTestMain(getDriver()).printMail();
        new SendReqTestMain(getDriver()).clickSubmit();
        Assertions.assertTrue(getDriver().getTitle().contains("Агентство элитной недвижимости в Москве"), "Wrong request!");
    }
}
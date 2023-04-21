package pageOblects;

import com.codeborne.selenide.Condition;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static com.codeborne.selenide.Selenide.$;

public class MainPage extends BasePage {

    private static final By EMAIL = By.xpath("//input[@name='email']");
    private static final By PASSWORD = By.xpath("//input[@name='password']");
    private static final By LOGIN = By.xpath("//button[@value='Login']");
    private static final By noticeMessage = By.xpath("//div[@id='notices']");

    Logger logger = Logger.getLogger(MainPage.class);

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public String GetMessage(String Email, String Password) {
        $(EMAIL).shouldBe(Condition.exist).sendKeys(Email);
        $(PASSWORD).shouldBe(Condition.exist).sendKeys(Password);
        $(LOGIN).shouldBe(Condition.exist).click();
        return $(noticeMessage).shouldBe(Condition.exist).getText();
    }
}

package pageOblects;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static com.codeborne.selenide.Selenide.$;

public class MainPage extends BasePage {

    private static final By EMAIL = By.xpath("//input[@name='email']");
    private static final By PASSWORD = By.xpath("//input[@name='password']");
    private static final By LOGIN = By.xpath("//button[@value='Login']");
    private static By errorMessage = By.xpath("//div[@class='notice errors']");
    private static By successMessage = By.xpath("//div[@class='notice success']");
    String correctEmail = "viktar.kudasau@gmail.com";
    String incorrectEmail = "xwq2@de.com";
    String correctPassword = "123456789";
    String incorrectPassword = "123";

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void fillIncorrectLoginAndSend() {
        $(EMAIL).shouldBe(Condition.exist).sendKeys(incorrectEmail);
        $(PASSWORD).shouldBe(Condition.exist).sendKeys(incorrectPassword);
        $(LOGIN).shouldBe(Condition.exist).click();
    }

    public void fillCorrectLoginAndSend() {
        $(EMAIL).shouldBe(Condition.exist).sendKeys(correctEmail);
        $(PASSWORD).shouldBe(Condition.exist).sendKeys(correctPassword);
        $(LOGIN).shouldBe(Condition.exist).click();
    }

    public String getErrorMessage() {
        return $(errorMessage).shouldBe(Condition.visible).getText();
    }

    public String getSuccessMessage() {
        return $(successMessage).shouldBe(Condition.visible).getText();
    }
}

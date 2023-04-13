package pageOblects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.codeborne.selenide.Selenide.$;

public class MainPage extends BasePage {

    private final By Email = By.xpath("//input[@name='email']");
    private final By Password = By.xpath("//input[@name='password']");
    private final By Button_Login = By.xpath("//button[@value='Login']");
    private final By Error_Message = By.xpath("//div[@class='notice errors']");
    private final By Success_Message = By.xpath("//div[@class='notice success']");
    String Correct_email = "viktar.kudasau@gmail.com";
    String incorrect_Email = "xwq2@de.com";
    String Correct_Password = "123456789";
    String Incorrect_Password = "123";

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void fillIncorrectEmailField() {
        $(Email).sendKeys(incorrect_Email);
    }

    public void fillIncorrectPasswordField() {
        $(Password).sendKeys(Incorrect_Password);
    }

    public void fillCorrectEmailField() {
        $(Email).sendKeys(Correct_email);
    }

    public void fillCorrectPasswordField() {
        $(Password).sendKeys(Correct_Password);
    }

    public void clickButtonLogin() {
        wait.until(ExpectedConditions.presenceOfElementLocated(Button_Login));
        $(Button_Login).click();
    }

    public void fillIncorrectLoginAndSend() {
        fillIncorrectEmailField();
        fillIncorrectPasswordField();
        clickButtonLogin();
    }

    public void fillCorrectLoginAndSend() {
        fillCorrectEmailField();
        fillCorrectPasswordField();
        clickButtonLogin();
    }

    public String getErrorMessage() {
        wait.until(ExpectedConditions.presenceOfElementLocated(Error_Message));
        return $(Error_Message).getText();
    }

    public String getSuccessMessage() {
        wait.until(ExpectedConditions.presenceOfElementLocated(Success_Message));
        return $(Success_Message).getText();
    }
}

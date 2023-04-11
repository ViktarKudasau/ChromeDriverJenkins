package pageOblects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage {

    public By Error_Message = By.xpath("//div[@class='notice errors']");
    public String Expected_Error_Message = "Wrong password or the account is disabled, or does not exist";
    public By Success_Message = By.xpath("//div[@class='notice success']");
    public String Expected_Success_Message = "You are now logged in as Viktar Kudasau.";
    private final By Email = By.xpath("//input[@name='email']");
    private final By Password = By.xpath("//input[@name='password']");
    private final By Button_Login = By.xpath("//button[@value='Login']");
    private final String Incorrect_Email = "wrgwg@wf.com";
    private final String Correct_email = "viktar.kudasau@gmail.com";
    private final String Incorrect_Password = "123";
    private final String Correct_Password = "123456789";

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void fillIncorrectEmailField() {
        webDriver.findElement(Email).sendKeys(Incorrect_Email);
    }

    public void fillIncorrectPasswordField() {
        webDriver.findElement(Password).sendKeys(Incorrect_Password);
    }

    public void fillCorrectEmailField() {
        webDriver.findElement(Email).sendKeys(Correct_email);
    }

    public void fillCorrectPasswordField() {
        webDriver.findElement(Password).sendKeys(Correct_Password);
    }

    public void clickButtonLogin() {
        webDriver.findElement(Button_Login).click();
    }

    public void fillIncorrectValueFormsAndSend() {
        fillIncorrectEmailField();
        fillIncorrectPasswordField();
        clickButtonLogin();
    }

    public void fillCorrectValueFormsAndSend() {
        fillCorrectEmailField();
        fillCorrectPasswordField();
        clickButtonLogin();
    }

    public void verifyErrorMessage() {
        wait.until(ExpectedConditions.presenceOfElementLocated(Error_Message));
        System.out.println(webDriver.findElement(Error_Message).getText());
    }

    public void verifySuccessMessage() {
        wait.until(ExpectedConditions.presenceOfElementLocated(Success_Message));
        System.out.println(webDriver.findElement(Success_Message).getText());
    }
}

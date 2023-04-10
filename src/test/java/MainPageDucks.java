import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPageDucks {
    By Email = By.xpath("//input[@name='email']");
    By Password = By.xpath("//input[@name='password']");
    By Button_Login = By.xpath("//button[@value='Login']");
    public By Result = By.xpath("//div[@class='notice errors']");

    WebDriver webDriver;
    WebDriver wait;

    public MainPageDucks(WebDriver driver) {
        webDriver = driver;
    }
    public void fillIncorrectEmailField (){
        webDriver.findElement(Email).sendKeys("brerbv");
    }
    public  void fillIncorrectPasswordField(){
        webDriver.findElement(Password).sendKeys("1234");
    }
    public void clickButtonLogin(){
        webDriver.findElement(Button_Login).click();
    }
    public void fillIncorrectValueFormsAndSend (){
        fillIncorrectEmailField();
        fillIncorrectPasswordField();
        clickButtonLogin();
    }
}

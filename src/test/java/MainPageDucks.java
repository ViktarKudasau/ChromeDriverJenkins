import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Assert;

import java.time.Duration;

public class MainPageDucks {
    By Email = By.xpath("//input[@name='email']");
    By Password = By.xpath("//input[@name='password']");
    By Button_Login = By.xpath("//button[@value='Login']");
    By Result = By.xpath("//div[@class='notice errors']");
    WebDriver webDriver;
    WebDriverWait wait;

    public MainPageDucks(WebDriver driver) {
        webDriver = driver;
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(300));
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
    public void verifyResultText(){
        wait.until(ExpectedConditions.presenceOfElementLocated(Result));
        System.out.println(webDriver.findElement(Result).getText());
        Assert.assertEquals(webDriver.findElement(Result).getText(),
                "Wrong password or the account is disabled, or does not exist");
    }

}

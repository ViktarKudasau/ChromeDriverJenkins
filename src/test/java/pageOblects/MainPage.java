package pageOblects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class MainPage extends BasePage {

        By Email = By.xpath("//input[@name='email']");
        By Password = By.xpath("//input[@name='password']");
        By Button_Login = By.xpath("//button[@value='Login']");
        By Result = By.xpath("//div[@class='notice errors']");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void fillIncorrectEmailField (){
            webDriver.findElement(Email).sendKeys("brerbv");
        }
        public  void fillIncorrectPasswordField(){
            webDriver.findElement(Password).sendKeys("1234");
        }

    public void fillCorrectEmailField (){
        webDriver.findElement(Email).sendKeys("viktar.kudasau@gmail.com");
    }
    public  void fillCorrectPasswordField(){
        webDriver.findElement(Password).sendKeys("123456789");
    }

        public void clickButtonLogin(){
            webDriver.findElement(Button_Login).click();
        }

        public void fillIncorrectValueFormsAndSend (){
            fillIncorrectEmailField();
            fillIncorrectPasswordField();
            clickButtonLogin();
        }

    public void fillCorrectValueFormsAndSend (){
        fillCorrectEmailField();
        fillCorrectPasswordField();
        clickButtonLogin();
    }

        public void verifyResultText(){
            wait.until(ExpectedConditions.presenceOfElementLocated(Result));
            System.out.println(webDriver.findElement(Result).getText());
            Assert.assertEquals(webDriver.findElement(Result).getText(),
                    "Wrong password or the account is disabled, or does not exist");
        }

    public void verifyCorrectResultText(){
        wait.until(ExpectedConditions.presenceOfElementLocated(Result));
        System.out.println(webDriver.findElement(Result).getText());
        Assert.assertEquals(webDriver.findElement(Result).getText(),
                "You are now logged in as Viktar Kudasau.");
    }

}

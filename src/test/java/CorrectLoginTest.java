import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageOblects.MainPage;

import java.time.Duration;

public class CorrectLoginTest extends BaseTest{

    @Test(invocationCount = 1)
    public void  firstTest(){
        webDriver.get("https://litecart.stqa.ru/en/");
        mainPageDucks.fillCorrectValueFormsAndSend();
        mainPageDucks.verifyCorrectResultText();
    }
}


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class IncorrectLoginTest {
    WebDriver webDriver;
    MainPageDucks mainPageDucks;

    @BeforeTest
    public void beforeTest(){
        WebDriverManager.chromedriver().setup();;
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(300));
        mainPageDucks = new MainPageDucks(webDriver);
    }

    @Test(invocationCount = 1)
    public void  firstTest(){
        webDriver.get("https://litecart.stqa.ru/en/");
        mainPageDucks.fillIncorrectValueFormsAndSend();
        mainPageDucks.verifyResultText();
    }

    @AfterTest
    public void afterTest(){
        webDriver.quit();
    }
}

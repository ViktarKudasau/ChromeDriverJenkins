import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageOblects.MainPageObject;
import java.time.Duration;

public class Aviasales_with_variables {
    WebDriver webDriver;
    MainPageObject mainPageObject;

    @BeforeTest
    public void beforeTest(){
        WebDriverManager.chromedriver().setup();;
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(300));
        mainPageObject = new MainPageObject(webDriver);
    }

    @Test(invocationCount = 1)
    public void  firstTest(){
        webDriver.get("https://www.aviasales.by/");
        mainPageObject.fillFormsAndSend();
        mainPageObject.verifyResultText();
    }
    @AfterTest
    public void afterTest(){
        webDriver.quit();
    }
}

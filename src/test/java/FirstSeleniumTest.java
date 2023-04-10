import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageOblects.MainPageObject;
import java.time.Duration;

public class FirstSeleniumTest extends BaseTest{

    @Test(invocationCount = 1)
    public void  firstTest(){
        webDriver.get("https://www.aviasales.by/");
        mainPageObject.fillFormsAndSend();
        mainPageObject.verifyResultText();
    }
}

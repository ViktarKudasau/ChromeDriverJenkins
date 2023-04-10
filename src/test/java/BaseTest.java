import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pageOblects.MainPage;

import java.time.Duration;

public class BaseTest {
    WebDriver webDriver;
    MainPage mainPageDucks;

    @BeforeTest
    public void beforeTest(){
        WebDriverManager.chromedriver().setup();;
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(300));
        mainPageDucks = new MainPage(webDriver);
    }

    @AfterTest
    public void afterTest(){
        webDriver.quit();
    }
}

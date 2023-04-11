import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pageOblects.MainPage;
import pageOblects.RubberDucksPage;
import java.time.Duration;

public class BaseTest {
    private final String base_URL = "https://litecart.stqa.ru/en/";
    WebDriver webDriver;
    MainPage mainPage;
    RubberDucksPage rubberDucksPage;

    @BeforeTest
    public void beforeTest() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(300));
        mainPage = new MainPage(webDriver);
        rubberDucksPage = new RubberDucksPage(webDriver);
    }

    @BeforeMethod
    public void beforeMethod() {
        webDriver.manage().deleteAllCookies();
        webDriver.get(base_URL);
    }

    @AfterTest
    public void afterTest() {
        webDriver.quit();
    }
}

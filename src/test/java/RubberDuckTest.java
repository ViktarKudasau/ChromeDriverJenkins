import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class RubberDuckTest {
    WebDriver webDriver;

    @BeforeTest
    public void beforeTest(){

        WebDriverManager.chromedriver().setup();;
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(180));
    }

    @Test(invocationCount = 1)
    public void  firstTest(){

        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(180));
        webDriver.get("https://litecart.stqa.ru/en/");

        WebElement Button_Rubber_Ducks = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//a[@href='https://litecart.stqa.ru/en/rubber-ducks-c-1/']")));
        Button_Rubber_Ducks.click();
        System.out.println("Click OK");

        List<WebElement> listElements = webDriver.findElements(By.xpath("//li[@class='product column shadow hover-light']"));

        int result = listElements.size();
        System.out.println("Size elements =" + result);
        Assert.assertTrue(listElements.size()==result, "size = " + result);


    }
    @AfterTest
    public void afterTest(){
        webDriver.quit();
    }
}

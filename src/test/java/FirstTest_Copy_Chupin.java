import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FirstTest_Copy_Chupin {

    WebDriver webDriver;

    @BeforeTest
    public void beforeTest(){
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
    }

    @Test
    public void firstTest(){
        webDriver.get("https://google.com");
        // WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofMillis(180));
      //  WebElement inputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("input1")));

        //WebElement inputField = webDriver.findElement(By.tagName("input1"));
       // inputField.sendKeys("Котики");

       // inputField.sendKeys(Keys.ENTER);

        String header = webDriver.getTitle();
        Assert.assertEquals(header, "Котики - Поиск в Google");

        List<WebElement> listElements = webDriver.findElements(By.xpath("//h3"));
        Assert.assertTrue(listElements.size()==10);
    }

    @AfterTest
    public void afterTest() {
        webDriver.quit();
    }

}

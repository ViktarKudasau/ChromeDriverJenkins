import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class ExampleTest {
    WebDriver webDriver;

    @BeforeTest
    public void beforeTest(){
       // String pathToDriver = "D:/Программы/chromedriver_win32.chromedriver.exe";
       // System.setProperty("webdriver.chrome.driver", pathToDriver);
        WebDriverManager.chromedriver().setup();;
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
    }

    @Test(invocationCount = 1)
    public void  firstTest(){
        webDriver.get("https://litecart.stqa.ru/en/rubber-ducks-c-1/?category_id=1&page=1&sort=name");


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }



        List <WebElement> listElements = webDriver.findElements(By.xpath("//li[@class='product column shadow hover-light']"));

        int result = listElements.size();
        System.out.println(result);
        Assert.assertTrue(listElements.size()==result, "size =" + result);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
    @AfterTest
    public void afterTest(){
        webDriver.quit();
    }

}

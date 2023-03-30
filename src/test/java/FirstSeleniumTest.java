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

public class FirstSeleniumTest {
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
        webDriver.get("https://www.google.com/");
        WebElement inputField = webDriver.findElement(By.name("q"));
        inputField.sendKeys("Котики");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        inputField.sendKeys(Keys.ENTER);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String header = webDriver.getTitle();
        Assert.assertEquals(header, "Котики - Поиск в Google");

        List <WebElement> listElements = webDriver.findElements(By.xpath("//h3"));
        for (WebElement el: listElements) {
            System.out.println(el.getText());
        }
        Assert.assertFalse(listElements.size()==20);

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

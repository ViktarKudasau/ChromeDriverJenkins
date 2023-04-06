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

import java.time.Duration;

public class Aviasales_with_variables {
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

        By From = By.xpath("//input[@id='origin']");
        By Where = By.xpath("//input[@id='destination']");
        By Find = By.xpath("//button[@data-test-id='form-submit']");
        By Result = By.xpath("//div[@data-test-id='card-text']/p");

        webDriver.get("https://www.aviasales.by/");
        webDriver.findElement(From).sendKeys("Минск");
        webDriver.findElement(Where).sendKeys("Мальта");
        webDriver.findElement(Find).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(Result));

        System.out.println(webDriver.findElement(Result).getText());
        Assert.assertEquals(webDriver.findElement(Result).getText(), "Нет прямых рейсов");

    }
    @AfterTest
    public void afterTest(){
        webDriver.quit();
    }
}

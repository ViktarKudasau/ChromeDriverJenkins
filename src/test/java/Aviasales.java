import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Aviasales {
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
        webDriver.get("https://www.aviasales.by/");

        WebElement inputField_From = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//input[@id='origin']")));
        inputField_From.sendKeys("Минск");

        WebElement inputField_Where = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//input[@id='destination']")));
        inputField_Where.sendKeys("Мальта");

        WebElement Button_Find = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//button[@data-test-id='form-submit']")));
  //      Button_Find.click();

        Actions actions = new Actions(webDriver);
        actions.doubleClick(Button_Find).build().perform();

        WebElement Search_Result = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("//div[@data-test-id='card-text']/p")));

        System.out.println(Search_Result.getText());
        Assert.assertEquals(Search_Result.getText(), "Нет прямых рейсов");



    }
    @AfterTest
    public void afterTest(){
        webDriver.quit();
    }
}

package pageOblects;

import com.codeborne.selenide.Condition;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class MainPage extends BasePage {

    private static final By EMAIL = By.xpath("//input[@name='email']");
    private static final By PASSWORD = By.xpath("//input[@name='password']");
    private static final By LOGIN = By.xpath("//button[@value='Login']");
    private static final By noticeMessage = By.xpath("//div[@id='notices']");
    private static final By emptyFieldMessage = By.id("box-account-login");

    Logger logger = Logger.getLogger(MainPage.class);

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public String GetMessage(String Email, String Password) {
        $(EMAIL).shouldBe(Condition.exist).sendKeys(Email);
        $(PASSWORD).shouldBe(Condition.exist).sendKeys(Password);
        $(LOGIN).shouldBe(Condition.exist).click();
        return $(noticeMessage).shouldBe(Condition.visible).getText();
    }

    public void getTextFromEmptyField(){
        $(EMAIL).shouldBe(Condition.exist).sendKeys("");
        $(PASSWORD).shouldBe(Condition.exist).sendKeys("Password");
        $(LOGIN).shouldBe(Condition.exist).click();

        WebElement rootElement = $(emptyFieldMessage);
 //       logger.info("Start to print rootElement.getText");
 //       System.out.println(rootElement.getText());

        logger.info("Start to find shadowRoot");
        SearchContext shadowRoot = (SearchContext) ((JavascriptExecutor)webDriver)
                .executeScript("return arguments[0].shadowRoot", rootElement);
        System.out.println(shadowRoot);
        SearchContext shadowRoot1 = (SearchContext) ((JavascriptExecutor)webDriver)
                .executeScript("return arguments[0].shadowRoot1", rootElement);
        System.out.println(shadowRoot1);

 /*       logger.info("Start to getting MESSAGE from empty field");
          WebElement message = (new WebDriverWait(webDriver, Duration.ofSeconds(5)))
                .until((ExpectedCondition<WebElement>) d ->
                {
                    assert d != null;
                    return d.findElement(emptyFieldMessage);
                });
          System.out.println(message.getText());
  */
   /*     logger.info("Start alert search");
        Alert alert = webDriver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println(alertText);
        Assert.assertEquals(alertText, "Заполните это поле.");
        alert.accept();
    */
  //      alert.dismiss();
      /*  alert.sendKeys("Hello!");
        alert.accept();
       */

    }
}

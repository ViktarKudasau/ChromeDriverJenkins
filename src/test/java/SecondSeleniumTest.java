import org.testng.annotations.Test;

public class SecondSeleniumTest extends BaseTest{
    @Test(invocationCount = 1)
    public void  firstTest(){
        webDriver.get("https://www.aviasales.by/");
        mainPageObject.fillFormsAndSend();
        mainPageObject.verifyResultText();
    }
}

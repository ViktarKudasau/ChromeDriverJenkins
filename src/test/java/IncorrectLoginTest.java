import org.testng.annotations.Test;

public class IncorrectLoginTest extends BaseTest {

    @Test(invocationCount = 1)
    public void  firstTest(){
        webDriver.get("https://litecart.stqa.ru/en/");
        mainPageDucks.fillIncorrectValueFormsAndSend();
        mainPageDucks.verifyResultText();
    }
}

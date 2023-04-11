import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(invocationCount = 1, priority = 0)
    public void TestIncorrectLogin() {
        mainPage.fillIncorrectValueFormsAndSend();
        mainPage.verifyErrorMessage();
        Assert.assertEquals(webDriver.findElement(mainPage.Error_Message).getText(),
                mainPage.Expected_Error_Message);
    }

    @Test(priority = 1)
    public void TestCorrectLogin() {
        mainPage.fillCorrectValueFormsAndSend();
        mainPage.verifySuccessMessage();
        Assert.assertEquals(webDriver.findElement(mainPage.Success_Message).getText(),
                mainPage.Expected_Success_Message);
    }
}

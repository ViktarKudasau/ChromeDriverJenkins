import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    String Expected_Success_Message = "You are now logged in as Viktar Kudasau.";
    String Expected_Error_Message = "Wrong password or the account is disabled, or does not exist";

    @Test(invocationCount = 1, priority = 0)
    public void TestIncorrectLogin() {
        mainPage.fillIncorrectLoginAndSend();
        Assert.assertEquals(mainPage.getErrorMessage(), Expected_Error_Message);
    }

    @Test(priority = 1)
    public void TestCorrectLogin() {
        mainPage.fillCorrectLoginAndSend();
        Assert.assertEquals(mainPage.getSuccessMessage(), Expected_Success_Message);
    }
}

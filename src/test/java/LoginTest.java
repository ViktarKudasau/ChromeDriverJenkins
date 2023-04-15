import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    String expectedSuccessMessage = "You are now logged in as Viktar Kudasau.";
    String expectedErrorMessage = "Wrong password or the account is disabled, or does not exist";

    @Test(invocationCount = 1, priority = 0)
    public void TestIncorrectLogin() {
        mainPage.fillIncorrectLoginAndSend();
        Assert.assertEquals(mainPage.getErrorMessage(), expectedErrorMessage,
                "Actual error message is " + "'" + mainPage.getErrorMessage() + "'");
    }

    @Test(priority = 1)
    public void TestCorrectLogin() {
        mainPage.fillCorrectLoginAndSend();
        Assert.assertEquals(mainPage.getSuccessMessage(), expectedSuccessMessage,
                "Actual success message is " + "'" + mainPage.getSuccessMessage() + "'");
    }
}

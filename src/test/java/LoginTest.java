import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    String expectedSuccessMessage = "You are now logged in as Viktar Kudasau.";
    String expectedErrorMessage = "Wrong password or the account is disabled, or does not exist";
    Logger logger = Logger.getLogger(LoginTest.class);

    @Test
    public void TestIncorrectLogin() {
        logger.info("TestIncorrectLogin()");
        mainPage.fillIncorrectLoginAndSend();
        Assert.assertEquals(mainPage.getErrorMessage(), expectedErrorMessage,
                "Actual error message is " + "'" + mainPage.getErrorMessage() + "'");
    }

    @Test
    public void TestCorrectLogin() {
        logger.info("TestCorrectLogin()");
        mainPage.fillCorrectLoginAndSend();
        Assert.assertEquals(mainPage.getSuccessMessage(), expectedSuccessMessage,
                "Actual success message is " + "'" + mainPage.getSuccessMessage() + "'");
    }
}

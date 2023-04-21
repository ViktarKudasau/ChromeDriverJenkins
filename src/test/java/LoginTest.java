import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    static String expectedSuccessMessage = "You are now logged in as Viktar Kudasau.";
    static String expectedErrorMessage = "Wrong password or the account is disabled, or does not exist";
    static String expectedErrorMessageByEmptyField = "You must provide both email address and password.";
    static String correctEmail = "viktar.kudasau@gmail.com";
    static String incorrectEmail = "xwq2@de.com";
    static String correctPassword = "123456789";
    static String incorrectPassword = "123";

    Logger logger = Logger.getLogger(LoginTest.class);

    @DataProvider(name = "LoginValues")
    public static Object[][] LoginValues() {
        return new Object[][] {
                {incorrectEmail, incorrectPassword, expectedErrorMessage},
                {incorrectEmail, correctPassword, expectedErrorMessage},
                {correctEmail, incorrectPassword, expectedErrorMessage},
                {correctEmail, correctPassword, expectedSuccessMessage},
                {correctEmail, "", expectedErrorMessageByEmptyField},
        };
    }
    @Test(dataProvider = "LoginValues")
    @Epic("RubberDucks Login Test")
    @Description("Test API 'Login' with different values: correct values, incorrect, empty fields,")
    public void Test1 (String Email, String Password, String ExpectedResult) {
        logger.info("Test1 started with filling Email = " + Email + " , Password = " + Password);
        Assert.assertEquals(mainPage.GetMessage(Email, Password), ExpectedResult);
    }
}

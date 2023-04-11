import org.testng.Assert;
import org.testng.annotations.Test;

public class RubberDuckTest extends BaseTest {

    @Test(invocationCount = 1)
    public void quantityDucksTest() {
        rubberDucksPage.verifyLoadButtonRubberDucks();
        rubberDucksPage.clickButtonRubberDucks();
        rubberDucksPage.verifyLoadDucks();
        Assert.assertEquals(rubberDucksPage.ListSize(), rubberDucksPage.expected_Quantity_Ducks);
        System.out.println("Quantity of Ducks = " + rubberDucksPage.ListSize());
    }
}

import org.testng.Assert;
import org.testng.annotations.Test;

public class RubberDucksTest extends BaseTest {

    @Test
    public void quantityDucksTest() {
        rubberDucksPage.clickRubberDucks();
        Assert.assertEquals(rubberDucksPage.ListSize(), rubberDucksPage.expected_Quantity_Ducks);
        System.out.println("Quantity of Ducks = " + rubberDucksPage.ListSize());
    }

    @Test
    public void sortByDateTest() {
        rubberDucksPage.clickRubberDucks();
        rubberDucksPage.clickDate();
        Assert.assertEquals(webDriver.findElement(rubberDucksPage.price_first_duck_By_Date).getText(),
                rubberDucksPage.Expected_price_by_Date);
        System.out.println("Price first duck by sort of Date = " +
                webDriver.findElement(rubberDucksPage.price_first_duck_By_Date).getText());
    }

    @Test
    public void sortByNameTest() {
        rubberDucksPage.clickRubberDucks();
        rubberDucksPage.clickName();
        Assert.assertEquals(webDriver.findElement(rubberDucksPage.price_first_duck_By_Name).getText(),
                rubberDucksPage.Expected_price_by_Name);
        System.out.println("Price first duck by sort of Name = " +
                webDriver.findElement(rubberDucksPage.price_first_duck_By_Name).getText());
    }
}

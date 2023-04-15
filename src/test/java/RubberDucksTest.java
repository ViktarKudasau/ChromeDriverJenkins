import org.testng.Assert;
import org.testng.annotations.Test;

public class RubberDucksTest extends BaseTest {

    int expectedQuantityDucks = 5;
    String expectedPriceByDate = "$18";
    String expectedPriceByName = "$20";

    @Test
    public void quantityDucksTest() {
        rubberDucksPage.clickRubberDucks();
        Assert.assertEquals(rubberDucksPage.getQuantityDucks(), expectedQuantityDucks,
                "Actual quantity ducks = " + rubberDucksPage.getQuantityDucks());
    }

    @Test
    public void sortByDateTest() {
        rubberDucksPage.clickRubberDucks();
        rubberDucksPage.clickDate();
        Assert.assertEquals(rubberDucksPage.getPriceByDate(), expectedPriceByDate,
                "Actual first's duck price sorted by Date = " + rubberDucksPage.getPriceByDate());
    }

    @Test
    public void sortByNameTest() {
        rubberDucksPage.clickRubberDucks();
        rubberDucksPage.clickName();
        Assert.assertEquals(rubberDucksPage.getPriceByName(), expectedPriceByName,
                "Actual first's duck price sorted by Name = " + rubberDucksPage.getPriceByName());
    }
}

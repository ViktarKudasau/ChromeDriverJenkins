package pageOblects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class RubberDucksPage extends BasePage {
    private final By Button_Rubber_Ducks = By.xpath("//a[text()='Rubber Ducks']");
    private final By Button_Date = By.xpath("//a[text()='Date']");
    private final By Ducks = By.xpath("//li[@class='product column shadow hover-light']");
    public int expected_Quantity_Ducks = 5;

    public RubberDucksPage(WebDriver driver) {
        super(driver);
    }

    public void clickButtonRubberDucks() {
        webDriver.findElement(Button_Rubber_Ducks).click();
    }
    public void clickButtonDate() {
        webDriver.findElement(Button_Rubber_Ducks).click();
    }

    public int ListSize() {
        List<WebElement> listElements = webDriver.findElements(Ducks);
        return listElements.size();
    }

    public void verifyLoadButtonRubberDucks() {
        wait.until(ExpectedConditions.presenceOfElementLocated(Button_Rubber_Ducks));
    }
    public void verifyLoadSortByDate() {
        wait.until(ExpectedConditions.presenceOfElementLocated(Button_Rubber_Ducks));
    }
    public void verifyLoadDucks() {
        wait.until(ExpectedConditions.presenceOfElementLocated(Ducks));
    }
}

package pageOblects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class RubberDucksPage extends BasePage {
    private final By Button_Rubber_Ducks = By.xpath("//a[text()='Rubber Ducks']");
    private final By Button_Date = By.xpath("//a[text()='Date']");
    private final By Button_Name = By.xpath("//a[text()='Name']");
    private final By Ducks = By.xpath("//li[@class='product column shadow hover-light']");
    private final By price_first_duck_By_Date = By.xpath("//a[@title='Yellow Duck']/div//strong");
    private final By price_first_duck_By_Name = By.xpath("//a[@title='Blue Duck']/div/span");

    public RubberDucksPage(WebDriver driver) {
        super(driver);
    }

    public void clickButtonRubberDucks() {
        wait.until(ExpectedConditions.presenceOfElementLocated(Button_Rubber_Ducks));
        webDriver.findElement(Button_Rubber_Ducks).click();
    }

    public void clickButtonDate() {
        wait.until(ExpectedConditions.presenceOfElementLocated(Button_Date));
        webDriver.findElement(Button_Date).click();
    }

    public void clickButtonName() {
        wait.until(ExpectedConditions.presenceOfElementLocated(Button_Name));
        webDriver.findElement(Button_Name).click();
    }

    public void verifyLoadDucks() {
        wait.until(ExpectedConditions.presenceOfElementLocated(Ducks));
    }

    public void clickRubberDucks() {
        clickButtonRubberDucks();
        verifyLoadDucks();
    }

    public void clickDate() {
        clickButtonDate();
        verifyLoadDucks();
    }

    public void clickName() {
        clickButtonName();
        verifyLoadDucks();
    }

    public int getQuantityDucks() {
        List<WebElement> listElements = webDriver.findElements(Ducks);
        return listElements.size();
    }

    public String getPriceByName() {
        return webDriver.findElement(price_first_duck_By_Name).getText();
    }

    public String getPriceByDate() {
        return webDriver.findElement(price_first_duck_By_Date).getText();
    }
}

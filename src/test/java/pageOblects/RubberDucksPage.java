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
    public int expected_Quantity_Ducks = 5;
    public By price_first_duck_By_Date = By.xpath("//a[@title='Yellow Duck']/div//strong");
    public By price_first_duck_By_Name = By.xpath("//a[@title='Blue Duck']/div/span");
    public String Expected_price_by_Date = "$18";
    public String Expected_price_by_Name = "$20";

    public RubberDucksPage(WebDriver driver) {
        super(driver);
    }

    public void clickButtonRubberDucks() {
        webDriver.findElement(Button_Rubber_Ducks).click();
    }
    public void clickButtonDate() {
        webDriver.findElement(Button_Date).click();
    }
    public void clickButtonName(){
        webDriver.findElement(Button_Name).click();
    }

    public int ListSize() {
        List<WebElement> listElements = webDriver.findElements(Ducks);
        return listElements.size();
    }

    public void verifyLoadButtonRubberDucks() {
        wait.until(ExpectedConditions.presenceOfElementLocated(Button_Rubber_Ducks));
    }
    public void verifyLoadButtonDate() {
        wait.until(ExpectedConditions.presenceOfElementLocated(Button_Date));
    }
    public void verifyLoadButtonName(){
        wait.until(ExpectedConditions.presenceOfElementLocated(Button_Name));
    }
    public void verifyLoadDucks() {
        wait.until(ExpectedConditions.presenceOfElementLocated(Ducks));
    }

    public void clickRubberDucks(){
        verifyLoadButtonRubberDucks();
        clickButtonRubberDucks();
        verifyLoadDucks();
    }
    public void clickDate(){
        verifyLoadButtonDate();
        clickButtonDate();
        verifyLoadDucks();
    }
    public void clickName(){
        verifyLoadButtonName();
        clickButtonName();
        verifyLoadDucks();
    }
}

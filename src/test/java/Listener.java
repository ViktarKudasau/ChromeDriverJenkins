import com.codeborne.selenide.WebDriverRunner;
import com.epam.reportportal.service.ReportPortal;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;

public class Listener implements ITestListener {
    Logger logger = Logger.getLogger(Listener.class);

    @Override
    public void onTestStart(ITestResult result) {
        logger.info("Test start");
        getScreen();
    }

    @Override
    public void onTestSuccess(ITestResult result){
        logger.info("start add screenshot to ReportPortal");
        addAttachmentScreenshot();
    }

 /*   @Attachment(value = "Screenshot", type = "image/png")
    public byte[] screenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
  */

    @Override
    public void onTestFailure(ITestResult result) {
        getScreen();
        logger.info("start getting screenshot");
        logger.info("Test failed");
    }

    @Override
    public void onStart(ITestContext context) {
        logger.info("On start");
    }

    @Override
    public void onFinish(ITestContext context) {
        logger.info("On finish");
    }

    public void getScreen(){
        String fileName;
        logger.info("start getting screenshot");
        File screenshot = ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.FILE);
        fileName = "src/main/resources/screenshots/screen_" + System.currentTimeMillis() + ".png";
        File res = new File(fileName);
        try {
            FileUtils.copyFile(screenshot, res);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        logger.info("screenshot was saved to " + fileName);
    }

    public void addAttachmentScreenshot(){
        Allure.addAttachment("HELLO!", new ByteArrayInputStream(((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES)));
    }
    public void addScreenshotToReportPortal() {

        try {
            File screenshot = ((TakesScreenshot)
                    WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.FILE);
            ReportPortal.emitLog("Screenshot", "SUCCESS",
                    Calendar.getInstance().getTime(), screenshot);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

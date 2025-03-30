package utils;

import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotTaker {

    public static void takeScreenshot(Scenario scenario, WebDriver driver) {
//        Reporter.log("Taking screenshot for test: " + result.getName(), true);
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("src/screenshots/" + scenario.getName() + ".png"));
        } catch (IOException ioException) {
//            Reporter.log("Failed to save a screenshot for test: " + result.getTestMethod().toString(), true);
        }
    }

    public static void takeScreenshot(TestInfo result, WebDriver driver) {
//        Reporter.log("Taking screenshot for test: " + result.getName(), true);
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("src/screenshots/" + result.getTestMethod().toString() + ".png"));
        } catch (IOException ioException) {
//            Reporter.log("Failed to save a screenshot for test: " + result.getTestMethod().toString(), true);
        }
    }
}

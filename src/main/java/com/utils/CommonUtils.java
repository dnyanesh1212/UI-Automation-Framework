package com.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class CommonUtils {
    WebDriver driver;
    WebDriverWait wait;

    public CommonUtils(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(PageConstants.LOW));
    }

    public String captureScreenshot(WebDriver driver, String testName){
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String userPath = System.getProperty("user.dir");

        String path = userPath + "\\test-output\\Extent-reports\\screenshots\\" + testName + ".png";
        try {
            FileHandler.copy(screenshot,new File(path));
        } catch (IOException e) {
            throw new RuntimeException("Error capturing screenshot: " + e.getMessage());
        }

        return path;
    }

    public boolean isClickable(WebElement element){
        try {
                wait.until(ExpectedConditions.visibilityOf(element));
                wait.until(ExpectedConditions.elementToBeClickable(element));
                return true;

        } catch (Exception e) {

            wait.until(ExpectedConditions.elementToBeClickable(element));
            throw new RuntimeException("Element is not clickable " + e.getMessage());

        }
    }
}

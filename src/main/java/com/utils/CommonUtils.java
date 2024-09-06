package com.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class CommonUtils {
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
}

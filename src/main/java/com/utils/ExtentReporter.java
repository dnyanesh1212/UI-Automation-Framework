package com.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;

public class ExtentReporter {
    public static ExtentReports generateExtentReport(){
        ExtentReports extentReports = new ExtentReports();
        FileUtilities fileUtilities = new FileUtilities();
        File file = new File(System.getProperty("user.dir") + "\\test-output\\Extent-reports\\report.html");
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);

        sparkReporter.config().setTheme(Theme.STANDARD);
        sparkReporter.config().setReportName("UI Automation");
        sparkReporter.config().setDocumentTitle("UI Automation Reports");
        sparkReporter.config().setTimeStampFormat("dd/mm/yyyy hh:mm:ss");

        try {
            extentReports.attachReporter(sparkReporter);
            extentReports.setSystemInfo("Application Url",fileUtilities.getProp().getProperty("url") );
            extentReports.setSystemInfo(("Browser "), fileUtilities.getProp().getProperty("browser"));
            extentReports.setSystemInfo("Executed By ", fileUtilities.getProp().getProperty("user"));

            return extentReports;
        }
        catch (Exception e){
            throw new RuntimeException("Error generating extent report " + e.getMessage());
        }


    }
}

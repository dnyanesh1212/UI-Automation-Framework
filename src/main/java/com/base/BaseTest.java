package com.base;

import com.pages.LandingPage;
import com.utils.PageConstants;
import com.utils.FileUtilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    public WebDriver driver = null;
    LandingPage landingPage;
    FileUtilities fileUtilities;

    public WebDriver initializeBrowser(String browserName, String appUrl)  {

        if (driver == null) {
            if (browserName.equalsIgnoreCase("chrome")) {
                driver = new ChromeDriver();
            } else if (browserName.equalsIgnoreCase("firefox")) {
                driver = new FirefoxDriver();
            } else if (browserName.equalsIgnoreCase("edge")) {
                driver = new EdgeDriver();
            } else {
                throw new IllegalArgumentException("Invalid browser name: " + browserName);
            }
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PageConstants.HIGH));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(PageConstants.MEDIUM));
        driver.manage().deleteAllCookies();

        driver.get(appUrl);

        return driver;
    }

    @BeforeMethod
    public LandingPage goToApplication() {
          fileUtilities = new FileUtilities();
          String browserName = fileUtilities.getProp().getProperty("browser");
          String appUrl = fileUtilities.getProp().getProperty("url");
          driver = initializeBrowser(browserName,appUrl);
          landingPage = new LandingPage(driver);
          return landingPage;
    }

    @AfterMethod
    public void tearDown(){
        if (driver != null)
            driver.quit();
    }
    
}

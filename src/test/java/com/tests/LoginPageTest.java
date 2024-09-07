package com.tests;

import com.base.BaseTest;
import com.pages.LandingPage;
import com.pages.LoginPage;
import com.utils.FileUtilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {
    @Test
    public void loginPageTest() throws InterruptedException {

        FileUtilities fileUtilities = new FileUtilities();
        //go to landing page
        LandingPage landingPage = goToApplication();
        String email = fileUtilities.getProp().getProperty("email");
        String password = fileUtilities.getProp().getProperty("password");
        //go to login page and login
        LoginPage loginPage = landingPage.goToLoginPage();
        // redirected to homepage
        loginPage.doLogin(email, password);
    }
}

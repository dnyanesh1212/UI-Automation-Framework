package com.tests;

import com.base.BaseTest;
import com.pages.LandingPage;
import com.pages.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class RegisterPageTest extends BaseTest {
    @Test
    public void firstProgram() throws InterruptedException {

        LandingPage landingPage= goToApplication();
        RegisterPage registerPage = landingPage.goToRegisterPage();
        registerPage.doRegister("dnyana","d","dnyana@gmail.com","1234567890", "Abc@123", "Abc@123");

    }
}

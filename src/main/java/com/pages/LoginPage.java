package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginPage {
    private static final Logger log = LoggerFactory.getLogger(LoginPage.class);
    public WebDriver driver;

    @FindBy(xpath = "//input[@name='email']") private WebElement emailTxt;
    @FindBy(xpath = "//input[@name='password']") private WebElement passwordTxt;
    @FindBy(xpath = "//input[@type='submit']") private WebElement loginBtn;

    //constructor to initialize login page objects
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    // Action methods for login page objects
    public HomePage doLogin(String email, String password) {
        emailTxt.sendKeys(email);
        passwordTxt.sendKeys(password);
        loginBtn.click();
        HomePage homePage = new HomePage(driver);
        return homePage;
    }
}

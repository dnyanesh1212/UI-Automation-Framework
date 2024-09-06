package com.pages;

import com.base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

    public WebDriver driver;
    RegisterPage registerPage;

    // Landing Page objects
    @FindBy(xpath = "//a[@title='My Account']") private WebElement myAccountBtn;
    @FindBy(xpath = "//a[.='Register']") private WebElement registerBtn;
    @FindBy(xpath = "//a[.='Login']") private WebElement loginBtn;

    //constructor to initialize page objects
    public LandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public RegisterPage goToRegisterPage(){
        myAccountBtn.click();
        registerBtn.click();
        registerPage = new RegisterPage(driver);
        return registerPage;
    }

    public LoginPage goToLoginPage(){
        myAccountBtn.click();
        loginBtn.click();
        LoginPage loginPage = new LoginPage(driver);
        return loginPage;
    }
}

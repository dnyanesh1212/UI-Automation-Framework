package com.pages;

import com.base.BaseTest;
import com.utils.CommonUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

    public WebDriver driver;
    RegisterPage registerPage;
    CommonUtils commonUtils;

    // Landing Page objects
    @FindBy(xpath = "//a[@title='My Account']") private WebElement myAccountBtn;
    @FindBy(xpath = "//a[.='Register']") private WebElement registerBtn;
    @FindBy(xpath = "//a[.='Login']") private WebElement loginBtn;

    //constructor to initialize landing page objects
    public LandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.commonUtils = new CommonUtils(driver);
    }

    // Action methods for landing page objects
    public RegisterPage goToRegisterPage(){
        if (commonUtils.isClickable(myAccountBtn))
            myAccountBtn.click();

        if (commonUtils.isClickable(registerBtn))
            registerBtn.click();

        registerPage = new RegisterPage(driver);
        return registerPage;
    }

    public LoginPage goToLoginPage(){
        if (commonUtils.isClickable(myAccountBtn))
            myAccountBtn.click();

        if (commonUtils.isClickable(loginBtn))
            loginBtn.click();

        LoginPage loginPage = new LoginPage(driver);
        return loginPage;
    }
}

package com.pages;

import com.base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
    public WebDriver driver;

    // Register page objects
    @FindBy(xpath = "//input[@name='firstname']") private WebElement firstNameTxt;
    @FindBy(xpath = "//input[@name='lastname']") private WebElement lastNameTxt;
    @FindBy(xpath = "//input[@name='email']") private WebElement emailTxt;
    @FindBy(xpath = "//input[@name='telephone']") private WebElement telephoneTxt;
    @FindBy(xpath = "//input[@name='password']") private WebElement passwordTxt;
    @FindBy(xpath = "//input[@name='confirm']") private WebElement confirmPasswordTxt;
    @FindBy(xpath = "//input[@type='checkbox']") private WebElement checkBox;
    @FindBy(xpath = "//input[@type='submit']") private WebElement continueBtn;

    //constructor to initialize page objects
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    // Action methods for page objects
    public void doRegister(String firstName, String lastName,String email, String telephone, String password, String confirmPassword){

        firstNameTxt.sendKeys(firstName);
        lastNameTxt.sendKeys(lastName);
        emailTxt.sendKeys(email);
        telephoneTxt.sendKeys(telephone);
        passwordTxt.sendKeys(password);
        confirmPasswordTxt.sendKeys(confirmPassword);
        checkBox.click();
        continueBtn.click();

    }

}

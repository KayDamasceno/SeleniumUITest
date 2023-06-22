package com.newtours.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "firstName")
    private WebElement firstNameBox;


    @FindBy(name = "lastName")
    private WebElement lastNameBox;

    @FindBy(name = "email")
    private WebElement userNameBox;

    @FindBy(name = "password")
    private WebElement passwordBox;

    @FindBy(name = "confirmPassword")
    private WebElement confirmPasswordBox;

    @FindBy(name = "register")
    private WebElement submitButton;


    public RegistrationPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    public void goTo(){
        this.driver.get("https://vins-udemy.s3.amazonaws.com/docker/docker-book-flight.html");
        this.wait.until(ExpectedConditions.visibilityOf(this.firstNameBox));
    }

    public void enterUserDetails(String firstName, String lastName){
        this.firstNameBox.sendKeys(firstName);
        this.lastNameBox.sendKeys(lastName);
    }

    public void enterUserCredentials(String userName, String password){
        this.userNameBox.sendKeys(userName);
        this.passwordBox.sendKeys(password);
        this.confirmPasswordBox.sendKeys(password);
    }

    public void submit(){
        this.submitButton.click();
    }
}

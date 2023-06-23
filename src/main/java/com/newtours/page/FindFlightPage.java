package com.newtours.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FindFlightPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "reserveFlights")
    private WebElement continueButton;

    @FindBy(name = "buyFlights")
    private WebElement securePurchase;

    public void FindFlightPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    public void clickFirstContinue(){
        this.wait.until(ExpectedConditions.elementToBeClickable(continueButton));
        this.continueButton.click();
    }

    public void clickSecurePurchase(){
        this.wait.until(ExpectedConditions.elementToBeClickable(securePurchase));
        this.securePurchase.click();
    }
}

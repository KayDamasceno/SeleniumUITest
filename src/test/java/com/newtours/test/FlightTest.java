package com.newtours.test;

import com.newtours.page.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FlightTest {

    private WebDriver driver;

    @BeforeTest
    public void setupDriver(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\kboin\\Videos\\SeleniumFramework\\chromedriver.exe");
        this.driver = new ChromeDriver();

    }

    @Test
    public void registrationPageTest(){
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.goTo();
        registrationPage.enterUserDetails("Kayque", "Damasceno");
        registrationPage.enterUserCredentials("Kayque", "teste");
        registrationPage.submit();
    }

    @Test(dependsOnMethods = "registrationPageTest")
    public void registrationConfirmationTest(){
        RegistrationConfirmationPage registrationConfirmationPage = new RegistrationConfirmationPage(driver);
        registrationConfirmationPage.goToFlightDetailsPage();
    }

    @Test(dependsOnMethods = "registrationConfirmationTest")
    public void flightDetailsPageTest(){
        FlightDetailsPage flightDetailsPage = new FlightDetailsPage(driver);
        flightDetailsPage.selectPassengers("3");
        flightDetailsPage.clickContinue();
    }

    @Test(dependsOnMethods = "flightDetailsPageTest")
    public void findFlightPageTest(){
        FindFlightPage findFlightPage = new FindFlightPage(driver);
        findFlightPage.clickFirstContinue();
        findFlightPage.clickSecurePurchase();
    }

    @Test(dependsOnMethods = "findFlightPageTest")
    public void flightConfirmationPage(){
        FlightConfirmationPage flightConfirmationPage = new FlightConfirmationPage(driver);
        flightConfirmationPage.printConfirmation();
    }

    @AfterTest
    public void quitBrowser(){
        this.driver.quit();
    }
}

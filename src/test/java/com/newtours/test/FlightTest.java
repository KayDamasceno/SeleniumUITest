package com.newtours.test;

import com.newtours.page.*;
import com.test.BaseTest;
import org.testng.annotations.Test;

public class FlightTest extends BaseTest {

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


}

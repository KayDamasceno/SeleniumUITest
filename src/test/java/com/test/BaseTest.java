package com.test;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    protected WebDriver driver;

    @BeforeTest
    public void setupDriver(ITestContext context) throws MalformedURLException {

        String host = "localhost";
        MutableCapabilities dc;

        if (System.getProperty("BROWSER") != null &&
            System.getProperty("BROWSER").equalsIgnoreCase("firefox")) {
            dc = new FirefoxOptions();
        } else {
            dc = new ChromeOptions();
        }

        if (System.getProperty("HUB_HOST") != null){
            host = System.getProperty("HUB_HOST");
        }
        String testName = context.getCurrentXmlTest().getName();
        String completeURL = "http://" + host + ":4444/wd/hub";


        //dc.setCapability("name", testName);
        this.driver = new RemoteWebDriver(new URL(completeURL), dc);

    }

    @AfterTest
    public void quitBrowser(){
        this.driver.quit();
    }
}

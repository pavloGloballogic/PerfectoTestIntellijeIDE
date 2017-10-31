package com.perfect.test;

import com.perfect.test.util.DriverInicialisation;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;

public class BaseTest {

    protected AppiumDriver driver;

    //Locators
    protected String closeWhiteBoxBtn = "//*[@name='mocks.close']";
    protected String goBtn = "//*[@name='bnt_go' and @visible='true']";
    protected String patientBtn = "//*[@name='eK7-mX-MF7' and @visible='true']";
    protected String hcpBtn = "//*[@name='4Q0-RT-sFa' and @visible='true']";
    protected String backButton = "//*[@label=\"Back\"]";
    protected String helpBtn = "//*[@label=\"Help\"]";

    protected void setupDriverIos(String automationName) throws MalformedURLException {
        driver = DriverInicialisation.getIosDriver(automationName);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }


    protected void waitForElement(AppiumDriver driver, String locator) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public Dimension getElementSize(WebElement element) {
        return element.getSize();
    }

    public Point gelElementLocation(WebElement element) {
        return element.getLocation();
    }
}
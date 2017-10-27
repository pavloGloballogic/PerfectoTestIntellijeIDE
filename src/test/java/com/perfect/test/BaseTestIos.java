package com.perfect.test;

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

public class BaseTestIos {

    protected IOSDriver driver;
    String remoteUrl = "https://medtronictest.perfectomobile.com/nexperience/perfectomobile/wd/hub";
    String appPath = "PUBLIC:Builds/IOS/3387-SparkMobileDiabetes-Mock-Staging.ipa";


    //Locators
    protected String closeBtn = "//*[@name='mocks.close']";
    protected String goBtn = "//*[@name='bnt_go' and @visible='true']";
    protected String patientBtn = "//*[@name='eK7-mX-MF7' and @visible='true']";
    protected String hcpBtn = "//*[@name='4Q0-RT-sFa' and @visible='true']";


    protected void setupDriver(String automationName) throws MalformedURLException {
        String browserName = "mobileOS";
        DesiredCapabilities capabilities = new DesiredCapabilities(browserName, "", Platform.ANY);
        capabilities.setCapability("user", "jenkins_auto_user@globallogic.com");
        capabilities.setCapability("password", "");
        capabilities.setCapability("deviceName", "14C70B91D3ED7C01EF263728DFB98D500FDD4CA8");
        capabilities.setCapability("bundleId", "com.medtronicndt.SparkMobileDiabetesMock");
        capabilities.setCapability("app", appPath);
        if (automationName != null) {
            capabilities.setCapability("automationName", automationName);//
        }
        driver = new IOSDriver(new URL(remoteUrl), capabilities);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }


    protected void waitForElement(AppiumDriver driver, String locator) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public Dimension getElementSize(WebElement element) {
        return element.getSize();
    }

    public Point gelElementLocation(WebElement element) {
        return element.getLocation();
    }

    public Point getElementCenter(WebElement element) {
        Point start = element.getLocation();
        Dimension size = element.getSize();
        return new Point(start.getX() + size.getWidth() / 2, start.getY() + size.getHeight() / 2);
    }
}
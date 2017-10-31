package com.perfect.test.util;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverInicialisation {
    static final String remoteUrl = "https://medtronictest.perfectomobile.com/nexperience/perfectomobile/wd/hub";
    static final String appPath = "PUBLIC:Builds/IOS/3387-SparkMobileDiabetes-Mock-Staging.ipa";
    static final String user = "jenkins_auto_user@globallogic.com";
    static final String password = "";

    public static AppiumDriver getIosDriver(String automationName) {
        String browserName = "mobileOS";
        DesiredCapabilities capabilities = new DesiredCapabilities(browserName, "", Platform.ANY);
        capabilities.setCapability("user", user);
        capabilities.setCapability("password", password);
        capabilities.setCapability("deviceName", "14C70B91D3ED7C01EF263728DFB98D500FDD4CA8");
        capabilities.setCapability("bundleId", "com.medtronicndt.SparkMobileDiabetesMock");
        capabilities.setCapability("app", appPath);
        if (automationName != null) {
            capabilities.setCapability("automationName", automationName);//
        }
        IOSDriver driver = null;
        try {
            driver = new IOSDriver(new URL(remoteUrl), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }

    public AppiumDriver getAndroidDriver() {
        String browserName = "mobileOS";
        DesiredCapabilities capabilities = new DesiredCapabilities(browserName, "", Platform.ANY);
        capabilities.setCapability("user", user);
        capabilities.setCapability("password", password);
        capabilities.setCapability("deviceName", "XWB6R17227002539");
        capabilities.setCapability("appPackage", "com.medtronicndt.SparkMobileDiabetesMock");
        capabilities.setCapability("app", appPath);

        AndroidDriver driver = null;
        try {
            driver = new AndroidDriver(new URL(remoteUrl), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }
}

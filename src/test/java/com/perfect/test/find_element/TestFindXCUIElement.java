package com.perfect.test.find_element;

import com.perfect.test.BaseTest;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class TestFindXCUIElement extends BaseTest {


    String carelinkSettings = "//*[@label='CareLink Settings']";
    String naigationBarXPATH = "//XCUIElementTypeNavigationBar";
    String naigationBarUiAutomatorXPATH = "//UIANavigationBar";


    @Test
    public void testFindElementXCUI() throws MalformedURLException {
        setupDriverIos("XCUITest");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement element = driver.findElement(new By.ByXPath(carelinkSettings));
        assertNotNull(element);

        driver.findElement(new By.ByXPath(carelinkSettings))
                .click();

        WebElement elementNavigationBar = driver.findElement(new By.ByXPath(naigationBarXPATH));
        assertNotNull(elementNavigationBar);

        String label = elementNavigationBar.getAttribute("name");
        assertEquals("CareLink Settings", label);

    }
    @Test
    public void testFindElementUIAutomator() throws MalformedURLException {
        setupDriverIos("Appium");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement element = driver.findElement(new By.ByXPath(carelinkSettings));
        assertNotNull(element);

        driver.findElement(new By.ByXPath(carelinkSettings))
                .click();

        WebElement elementNavigationBar = driver.findElement(new By.ByXPath(naigationBarUiAutomatorXPATH));
        assertNotNull(elementNavigationBar);

        String label = elementNavigationBar.getAttribute("name");
        assertEquals("CareLink Settings", label);


    }


}

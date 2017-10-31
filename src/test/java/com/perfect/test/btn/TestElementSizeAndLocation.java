package com.perfect.test.btn;

import com.perfect.test.BaseTest;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;

import java.net.MalformedURLException;

import static org.junit.Assert.assertEquals;

public class TestElementSizeAndLocation extends BaseTest {

    @Test
    public void testHCPButtonSizeAppium() throws MalformedURLException {
        setupDriverIos("Appium");
        testHCPButtonSize();
    }

    @Test
    public void testHCPButtonSizeXCUI() throws MalformedURLException {
        setupDriverIos("XCUITest");
        testHCPButtonSize();
    }

    @Test
    public void testHCPButtonSizeNOAtomation() throws MalformedURLException {
        setupDriverIos(null);
        testHCPButtonSize();
    }

    @Test
    public void testHCPButtonLocationAppium() throws MalformedURLException {
        setupDriverIos("Appium");
        testHCPButtonLocation();
    }

    @Test
    public void testHCPButtonLocationXCUI() throws MalformedURLException {
        setupDriverIos("XCUITest");
        testHCPButtonLocation();
    }

    @Test
    public void testHCPButtonLocationNOAtomation() throws MalformedURLException {
        setupDriverIos(null);
        testHCPButtonLocation();
    }

    public void testHCPButtonSize() {

        int expectedWidth = 686;
        int expectedHeight = 106;

        waitForElement(driver, closeWhiteBoxBtn);
        driver.findElementByXPath(closeWhiteBoxBtn).click();

        waitForElement(driver, goBtn);
        driver.findElementByXPath(goBtn).click();

        waitForElement(driver, patientBtn);
        Dimension element = getElementSize(driver.findElementByXPath(hcpBtn));
        assertEquals("Expected button height ", expectedHeight, element.height);
        assertEquals("Expected button width ", expectedWidth, element.width);
    }

    public void testHCPButtonLocation() {
        int expectedX = 32;
        int expectedY = 892;


        waitForElement(driver, closeWhiteBoxBtn);
        driver.findElementByXPath(closeWhiteBoxBtn).click();

        waitForElement(driver, goBtn);
        driver.findElementByXPath(goBtn).click();

        waitForElement(driver, patientBtn);
        Point elementLocation = gelElementLocation(driver.findElementByXPath(hcpBtn));
        assertEquals("Expected button x", expectedX, elementLocation.x);
        assertEquals("Expected button y", expectedY, elementLocation.y);
    }

}

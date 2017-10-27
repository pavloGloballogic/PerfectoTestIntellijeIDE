package com.perfect.test.location;

import com.perfect.test.BaseTestIos;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;

import java.net.MalformedURLException;

import static org.junit.Assert.assertEquals;

public class TestMesureSizeAndLocationNOAutomation extends BaseTestIos {
    protected String automationName;

    @Before
    public void sutUp() throws InterruptedException, MalformedURLException {
        setupDriver(automationName);
    }

    @Test
    public void testHCPButtonSize() {
        int expectedWidth = 686;
        int expectedHeight = 106;

        waitForElement(driver, closeBtn);
        driver.findElementByXPath(closeBtn).click();

        waitForElement(driver, goBtn);
        driver.findElementByXPath(goBtn).click();

        waitForElement(driver, patientBtn);
        Dimension element = getElementSize(driver.findElementByXPath(hcpBtn));
        assertEquals("Expected button height ", expectedHeight, element.height);
        assertEquals("Expected button width ", expectedWidth, element.width);
    }

    @Test
    public void testHCPButtonLocation() {
        int expectedX = 32;
        int expectedY = 892;


        waitForElement(driver, closeBtn);
        driver.findElementByXPath(closeBtn).click();

        waitForElement(driver, goBtn);
        driver.findElementByXPath(goBtn).click();

        waitForElement(driver, patientBtn);
        Point elementLocation = gelElementLocation(driver.findElementByXPath(hcpBtn));
        assertEquals("Expected button x", expectedX, elementLocation.x);
        assertEquals("Expected button y", expectedY, elementLocation.y);
    }

}

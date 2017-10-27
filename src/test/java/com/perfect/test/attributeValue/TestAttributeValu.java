package com.perfect.test.attributeValue;

import com.perfect.test.BaseTestIos;
import org.junit.Test;
import org.openqa.selenium.Dimension;

import java.net.MalformedURLException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestAttributeValu extends BaseTestIos {


    String switchTest = "//*[@name='predef_response.error_from_server']";
    String carelinkSettings = "//*[@label='CareLink Settings']";

    @Test
    public void testWindowSizeNOAtomation() throws MalformedURLException {
        setupDriver(null);
        checkGetAttributeValue();
    }

    @Test
    public void testWindowSizeAppium() throws MalformedURLException {
        setupDriver("Appium");
        checkGetAttributeValue();
    }

    @Test
    public void testWindowSizeXCUI() throws MalformedURLException {
        setupDriver("XCUITest");
        checkGetAttributeValue();
    }

    public void checkGetAttributeValue() {


        waitForElement(driver, carelinkSettings);
        driver.findElementByXPath(carelinkSettings).click();

        waitForElement(driver, switchTest);
        Object value = driver.findElementByXPath(switchTest).getAttribute("value");

        assertEquals("Is object", value.getClass(), Boolean.class);

    }

}

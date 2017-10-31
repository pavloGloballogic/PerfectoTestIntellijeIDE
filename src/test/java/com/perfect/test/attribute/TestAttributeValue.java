package com.perfect.test.attribute;

import com.perfect.test.BaseTest;
import org.junit.Test;

import java.net.MalformedURLException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestAttributeValue extends BaseTest {


    String switchTest = "//*[@name='predef_response.error_from_server']";
    String carelinkSettings = "//*[@label='CareLink Settings']";

    @Test
    public void testWindowSizeNOAtomation() throws MalformedURLException {
        setupDriverIos(null);
        checkGetAttributeValue();
    }

    @Test
    public void testWindowSizeAppium() throws MalformedURLException {
        setupDriverIos("Appium");
        checkGetAttributeValue();
    }

    @Test
    public void testWindowSizeXCUI() throws MalformedURLException {
        setupDriverIos("XCUITest");
        checkGetAttributeValue();
    }

    public void checkGetAttributeValue() {

        waitForElement(driver, carelinkSettings);
        driver.findElementByXPath(carelinkSettings).click();

        waitForElement(driver, switchTest);
        Object value = driver.findElementByXPath(switchTest).getAttribute("value");
        assertEquals("Is object", String.class, value.getClass());
        assertEquals("1", value.toString());

    }

}

package com.perfect.test.attribute;

import com.perfect.test.BaseTest;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;

import static org.junit.Assert.assertEquals;

public class TestAttributeText extends BaseTest {

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
        WebElement elementByXPath = driver.findElementByXPath(carelinkSettings);
        String value = elementByXPath.getAttribute("text");
        assertEquals( "CareLink Settings", value);
    }

}

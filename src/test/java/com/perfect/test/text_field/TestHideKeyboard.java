package com.perfect.test.text_field;

import com.perfect.test.BaseTest;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TestHideKeyboard extends BaseTest {

    String carelinkSettings = "//*[@label='CareLink Settings']";
    String inputTextUrl = "//*[@name=\"predef_response.request_url\"]";
    String keyboardXCUI = "//XCUIElementTypeKeyboard";
    String keyboardUIA = "//UIAKeyboard";

    @Test
    public void testInputTextXCUI() throws MalformedURLException {
        setupDriverIos("XCUITest");
        testInputText(keyboardXCUI);
    }

    @Test
    public void testInputTextAppium() throws MalformedURLException {
        setupDriverIos("Appium");
        testInputText(keyboardUIA);
    }

    public void testInputText(String keyboardLocator) {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement element = driver.findElement(new By.ByXPath(carelinkSettings));
        assertNotNull(element);

        driver.findElement(new By.ByXPath(carelinkSettings))
                .click();

        WebElement elementNavigationBar = driver.findElement(new By.ByXPath(inputTextUrl));
        assertNotNull(elementNavigationBar);
        elementNavigationBar.click();

        WebElement elementByXPath = driver.findElementByXPath(keyboardLocator);
        assertNotNull(elementByXPath);

        String visible = elementByXPath.getAttribute("visible");
        assertEquals("true", visible);

        driver.hideKeyboard();

        visible = elementByXPath.getAttribute("visible");
        assertEquals("false", visible);
    }
}

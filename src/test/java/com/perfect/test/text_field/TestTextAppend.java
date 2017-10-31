package com.perfect.test.text_field;

import com.perfect.test.BaseTest;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TestTextAppend extends BaseTest {

    String carelinkSettings = "//*[@label='CareLink Settings']";
    String inputTextUrl = "//*[@name=\"predef_response.request_url\"]";

    @Test
    public void testInputTextXCUI() throws MalformedURLException {
        setupDriverIos("XCUITest");
        testInputText();
    }

    @Test
    public void testInputTextAppium() throws MalformedURLException {
        setupDriverIos("Appium");
        testInputText();
    }

    public void testInputText() {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement element = driver.findElement(new By.ByXPath(carelinkSettings));
        assertNotNull(element);

        driver.findElement(new By.ByXPath(carelinkSettings))
                .click();

        WebElement elementNavigationBar = driver.findElement(new By.ByXPath(inputTextUrl));
        assertNotNull(elementNavigationBar);
        elementNavigationBar.click();

        driver.getKeyboard().sendKeys("test text");

        String value = elementNavigationBar.getAttribute("value");
        assertEquals("test text", value);

        driver.getKeyboard().sendKeys(" append new text");

        value = elementNavigationBar.getAttribute("value");
        assertEquals("test text append new text", value);
    }
}

package com.perfect.test.window;

import com.perfect.test.BaseTest;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;

import java.net.MalformedURLException;

import static org.junit.Assert.assertEquals;

public class TestWindowsSize extends BaseTest {

    @Before
    public void setUp() {

    }

    @Test
    public void testWindowSizeNOAtomation() throws MalformedURLException {
        setupDriverIos(null);
        checkWindowSize();
    }

    @Test
    public void testWindowSizeAppium() throws MalformedURLException {
        setupDriverIos("Appium");
        checkWindowSize();
    }

    @Test
    public void testWindowSizeXCUI() throws MalformedURLException {
        setupDriverIos("XCUITest");
        checkWindowSize();
    }

    public void checkWindowSize() {

        int expectedWidth = 750;
        int expectedHeight = 1334;

        Dimension size = driver.manage().window().getSize();

        assertEquals("Expected button height ", expectedHeight, size.height);
        assertEquals("Expected button width ", expectedWidth, size.width);
    }

}

package com.perfect.test.window_size;

import com.perfect.test.BaseTestIos;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;

import java.net.MalformedURLException;

import static org.junit.Assert.assertEquals;

public class TestWindowsSize extends BaseTestIos {

    @Before
    public void setUp() {

    }

    @Test
    public void testWindowSizeNOAtomation() throws MalformedURLException {
        setupDriver(null);
        checkWindowSize();
    }

    @Test
    public void testWindowSizeAppium() throws MalformedURLException {
        setupDriver("Appium");
        checkWindowSize();
    }

    @Test
    public void testWindowSizeXCUI() throws MalformedURLException {
        setupDriver("XCUITest");
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

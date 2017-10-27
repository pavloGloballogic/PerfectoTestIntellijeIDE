package com.perfect.test.location;

import com.perfect.test.BaseTestIos;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;

import java.net.MalformedURLException;

import static org.junit.Assert.assertEquals;

public class TestMesureSizeAndLocationAppium extends TestMesureSizeAndLocationNOAutomation {

    @Before
    public void sutUp() throws InterruptedException, MalformedURLException {
        automationName = "Appium";
        super.sutUp();
    }



}

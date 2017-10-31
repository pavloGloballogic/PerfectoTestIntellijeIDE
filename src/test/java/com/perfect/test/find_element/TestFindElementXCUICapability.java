package com.perfect.test.find_element;

import com.perfect.test.BaseTest;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TestFindElementXCUICapability extends BaseTest {
    String mockButton = "//*[@name=\"managing_view\"]";
    String carelinkSettings = "//*[@label='CareLink Settings']";
    String imPatientBtn = "//*[@label=\"I'm a Patient\"]";
    String thisIsFirstEvaluationBtn = "//*[@label=\"This is my first evaluation\"]";
    String iHaveEnvisionProBtn = "//*[@label=\"I have an Envision Pro account\"]";
    String closeBtn = "//*[@label=\"Close\"]";


    @Test
    public void testFindElement() throws MalformedURLException {
        setupDriverIos  ("XCUITest");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement element = driver.findElement(new By.ByXPath(carelinkSettings));
        assertNotNull(element);
        driver.findElement(new By.ByXPath(carelinkSettings))
                .click();

        element = driver.findElement(new By.ByXPath(closeWhiteBoxBtn));
        assertNotNull(element);
        driver.findElement(new By.ByXPath(closeWhiteBoxBtn)).click();

        element = driver.findElement(new By.ByXPath(goBtn));
        assertNotNull(element);
        element.click();

        int i = 0;
//        try {
        while (i++ < 50) {
            element = driver.findElement(new By.ByXPath(mockButton));
            assertNotNull(element);
            driver.findElement(new By.ByXPath(mockButton))
                    .click();

            element = driver.findElement(new By.ByXPath(carelinkSettings));
            assertNotNull(element);
            driver.findElement(new By.ByXPath(carelinkSettings))
                    .click();

            element = driver.findElement(new By.ByXPath(closeWhiteBoxBtn));
            assertNotNull(element);
            driver.findElement(new By.ByXPath(closeWhiteBoxBtn)).click();

            element = driver.findElement(new By.ByXPath(imPatientBtn));
            assertNotNull(element);
            driver.findElement(new By.ByXPath(imPatientBtn)).click();

            element = driver.findElement(new By.ByXPath(thisIsFirstEvaluationBtn));
            assertNotNull(element);

            element = driver.findElement(new By.ByXPath(helpBtn));
            assertNotNull(element);
            driver.findElement(new By.ByXPath(helpBtn)).click();

            element = driver.findElement(new By.ByXPath(closeBtn));
            assertNotNull(element);
            driver.findElement(new By.ByXPath(closeBtn)).click();

            element = driver.findElement(new By.ByXPath(iHaveEnvisionProBtn));
            assertNotNull(element);

            element = driver.findElement(new By.ByXPath(backButton));
            assertNotNull(element);

            driver.findElement(new By.ByXPath(backButton)).click();

        }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        assertEquals("Crashed on:", 51, i);
    }

}

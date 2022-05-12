package com.automation.web.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ExampleTest extends BaseTest {

    @Test
    public void exampleTest(){
        // Assert.assertTrue(mainPage.isLogoVisible());
        mainPage.scrollDownByPixels();
        mainPage.setOriginDestination("Las Vegas");
        mainPage.clickLasVegasDestinationButton();
        mainPage.setArrivalDestination("San Salvador");
    }
}

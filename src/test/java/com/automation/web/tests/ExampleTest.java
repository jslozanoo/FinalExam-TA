package com.automation.web.tests;

import org.testng.annotations.Test;

public class ExampleTest extends BaseTest {

    @Test
    public void exampleTest() throws InterruptedException {
        mainPage.scrollDownByPixels();
        mainPage.setOriginDestination("Las Vegas");
        mainPage.setArrivalDestination("San Salvador");
        mainPage.addPassenger();
        mainPage.chooseDates();
        mainPage.submitFlight();
        Thread.sleep(8000);
    }
}

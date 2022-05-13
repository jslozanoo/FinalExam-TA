package com.automation.web.tests;

import org.testng.annotations.Test;

public class ExampleTest extends BaseTest {

    @Test
    public void exampleTest() {
        mainPage.scrollDownByPixels();
        mainPage.setOriginDestination("Las Vegas");
        mainPage.clickLasVegasDestinationButton();
        mainPage.setArrivalDestination("San Salvador");
        mainPage.clickSanSalvadorDestinationButton();
        mainPage.clickChoosePassengersButton();
        mainPage.addPassenger();
    }
}

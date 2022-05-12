package com.automation.web.tests;

import org.testng.annotations.Test;

public class ExampleTest extends BaseTest {

    @Test
    public void exampleTest(){
        mainPage.scrollDownByPixels();
        mainPage.setFromDestination("Las Vegas");
        mainPage.setToDestination("San Salvador");
    }
}

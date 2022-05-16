package com.automation.web.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class ExampleTest extends BaseTest {

    @Test
    public void exampleTest() {
        LoginPage loginPage = homePage.goToLoginPage();
        Assert.assertTrue(loginPage.areElementsVisible(), "Not all elements are visible");
    }
}

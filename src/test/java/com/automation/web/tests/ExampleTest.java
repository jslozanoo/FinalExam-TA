package com.automation.web.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SignupPage;

public class ExampleTest extends BaseTest {

    @Test
    public void exampleTest() {
        LoginPage loginPage = homePage.goToLoginPage();
        Assert.assertTrue(loginPage.isLogoDisplayed(), "Logo is not displayed");
        Assert.assertTrue(loginPage.areButtonsDisplayed(), "Buttons are not displayed");
        SignupPage signupPage = loginPage.goToSignupPage();
        Assert.assertTrue(signupPage.isTitleDisplayed(), "Signup title is not displayed");
        Assert.assertTrue(signupPage.areInputsDisplayed(), "Inputs boxes are not displayed");
        Assert.assertTrue(signupPage.isCloseFormButtonDisplayed());
    }
}

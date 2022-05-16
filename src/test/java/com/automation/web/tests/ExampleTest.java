package com.automation.web.tests;

import com.automation.web.data.Data;
import com.automation.web.data.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.SignupPage;

public class ExampleTest extends BaseTest {

    @Test(dataProvider = "user", dataProviderClass = Data.class)
    public void exampleTest(User user) {
        LoginPage loginPage = homePage.goToLoginPage();
        Assert.assertTrue(loginPage.isLogoDisplayed(), "Logo is not displayed");
        Assert.assertTrue(loginPage.areButtonsDisplayed(), "Buttons are not displayed");
        SignupPage signupPage = loginPage.goToSignupPage();
        Assert.assertTrue(signupPage.isTitleDisplayed(), "Signup title is not displayed");
        Assert.assertTrue(signupPage.areInputsDisplayed(), "Inputs boxes are not displayed");
        Assert.assertTrue(signupPage.isCloseFormButtonDisplayed());
        signupPage.completeFormInputs(user.getFirstName(), user.getLastName(),
                user.getEmail(), user.getPassword());
        MainPage mainPage =  signupPage.createAccount();
    }
}

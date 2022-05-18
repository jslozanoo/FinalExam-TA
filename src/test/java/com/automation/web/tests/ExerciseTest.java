package com.automation.web.tests;

import com.automation.web.data.Data;
import com.automation.web.data.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.SignupPage;
import pages.WatchPage;

public class ExerciseTest extends BaseTest {

    @Test(dataProvider = "user", dataProviderClass = Data.class)
    public void exampleTest(User user) {
        LoginPage loginPage = homePage.goToLoginPage();
        log.info("Validation in Login page");
        Assert.assertTrue(loginPage.isLogoDisplayed(), "Logo is not displayed");
        Assert.assertTrue(loginPage.areButtonsDisplayed(), "Buttons are not displayed");

        SignupPage signupPage = loginPage.goToSignupPage();
        log.info("Validation in Signup Page");
        Assert.assertTrue(signupPage.isTitleDisplayed(), "Signup title is not displayed");
        Assert.assertTrue(signupPage.areInputsDisplayed(), "Inputs boxes are not displayed");
        Assert.assertTrue(signupPage.isSignupButtonDisplayed(), "Signup button is not displayed");
        Assert.assertTrue(signupPage.isCloseFormButtonDisplayed(), "Close form button is not displayed");
        signupPage.completeFormInputs(user.getFirstName(), user.getLastName(),
                user.getEmail(), user.getPassword());

        MainPage mainPage =  signupPage.createAccount();
        WatchPage watchPage = mainPage.goToWatchPage();
        log.info("Validations in Watch Page");
        Assert.assertTrue(watchPage.areStreamingSourceInfoDisplayed(),
                "Streaming source information in cards are not displayed");
        Assert.assertTrue(watchPage.areCardsTitlesDisplayed() ,"Titles in cards are not present");
        Assert.assertTrue(watchPage.AreCarouselsPresent(), "There are no carousels present");
        Assert.assertTrue(watchPage.areCarouselsDisplayed(), "There are no carousels displayed");
        watchPage.clickSecondCardFirstCarousel();
        Assert.assertTrue(watchPage.isCloseProviderButtonDisplayed(),
                "Close provider selection button is not displayed");
        watchPage.closeProviderSelection();

        mainPage = watchPage.goBackToHomePage();
        mainPage.clickUserIconButton();
        log.info("Welcome message: " + mainPage.getNameInUserContainer());
        log.info("User name: " + user.getFirstName());
        Assert.assertEquals(mainPage.getNameInUserContainer(), "Welcome" + user.getFirstName() + "!",
                "Names are not equal");
        homePage = mainPage.logout();
        homePage.clickUserIconButton();
        log.info("Welcome message: " + homePage.getNameInUserContainer());
        Assert.assertEquals(homePage.getNameInUserContainer(), "Welcome!",
                "Names are not equal");
    }
}

package com.automation.web.tests;

import com.automation.web.data.Data;
import com.automation.web.data.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.SignupPage;
import pages.WatchPage;

public class ExampleTest extends BaseTest {

    @Test(dataProvider = "user", dataProviderClass = Data.class)
    public void exampleTest(User user) throws InterruptedException {
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
        WatchPage watchPage = mainPage.goToWatchPage();
        Assert.assertTrue(watchPage.AreCarouselsPresent(), "There are no carousels present");
        Assert.assertTrue(watchPage.areCarouselsDisplayed(), "There are no carousels displayed");
        watchPage.clickCard();
        log.info("Delayed");
        Assert.assertTrue(watchPage.isCloseProviderButtonDisplayed(),
                "Close provider selection button is not displayed");
        watchPage.closeProviderSelection();
        mainPage = watchPage.goBackToHomePage();
        mainPage.clickUserIconButton();
        Assert.assertEquals(mainPage.getNameInUserContainer(), "Welcome" + user.getFirstName() + "!",
                "Names are not equal");
        homePage = mainPage.logout();
        homePage.clickUserIconButton();
        Assert.assertEquals(homePage.getNameInUserContainer(), "Welcome!",
                "Names are not equal");
        Thread.sleep(5000);
    }
}

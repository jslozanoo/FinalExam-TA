package com.automation.web.tests;

import com.automation.web.driver.Driver;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import pages.MainPage;

public class BaseTest {
    protected Driver driver;
    protected Logger log = Logger.getLogger(BaseTest.class);
    protected MainPage mainPage;

    @BeforeTest
    @Parameters({"browser", "url"})
    public void beforeTest(String browser, String url){
        driver = new Driver(browser);
        driver.getDriver().manage().window().maximize();
        driver.getDriver().get(url);
        mainPage = new MainPage(driver.getDriver());
    }

    @AfterTest
    public void afterTest(){
        driver.getDriver().quit();
    }
}

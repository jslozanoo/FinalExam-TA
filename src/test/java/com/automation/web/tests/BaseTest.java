package com.automation.web.tests;

import com.automation.web.driver.Driver;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import pages.HomePage;

public class BaseTest {
    protected Driver driver;
    protected HomePage homePage;
    protected Logger log = Logger.getLogger(BaseTest.class);

    @BeforeTest
    @Parameters({"browser", "url"})
    public void beforeTest(String browser, String url){
        driver = new Driver(browser);
        driver.getDriver().manage().window().maximize();
        driver.getDriver().get(url);
        log.info("Loading espn page");
        homePage = new HomePage(driver.getDriver());
    }

    @AfterTest
    public void afterTest(){
        log.info("Closing driver");
        driver.getDriver().quit();
    }
}

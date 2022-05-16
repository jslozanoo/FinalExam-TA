package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page representing home page.
 * @author js.lozano
 */
public class HomePage extends BasePage{

    @FindBy(id = "global-user-trigger")
    private WebElement userButton;

    @FindBy(css = ".global-user[style] div[class*='container']")
    private WebElement userContainer;

    @FindBy(css = ".global-user[style] a[data-regformid]")
    private WebElement loginButton;

    @FindBy(id = "oneid-iframe")
    private WebElement loginFrame;

    /**
     * Constructor
     *
     * @param driver WebDriver
     */
    public HomePage(WebDriver driver) {
        super(driver);
    }

    /**
     * Switch driver to login frame
     * @param iFrame WebElement
     */
    public void switchToLoginFrame(WebElement iFrame){
        getDriver().switchTo().frame(iFrame);
    }

    /**
     * Click on login button
     * @return LoginPage {@link LoginPage}
     */
    public LoginPage goToLoginPage(){
        isElementAvailable(userButton);
        click(userButton);
        isElementAvailable(userContainer);
        click(loginButton);
        switchToLoginFrame(loginFrame);

        return new LoginPage(getDriver());
    }
}

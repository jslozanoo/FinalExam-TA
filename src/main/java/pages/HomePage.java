package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(id = "global-user-trigger")
    private WebElement userButton;

    @FindBy(css = ".global-user[style] div[class*='container']")
    private WebElement userContainer;

    @FindBy(css = ".global-user[style] a[data-regformid]")
    private WebElement loginButton;

    /**
     * Constructor
     *
     * @param driver WebDriver
     */
    public HomePage(WebDriver driver) {
        super(driver);
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

        return new LoginPage(getDriver());
    }
}

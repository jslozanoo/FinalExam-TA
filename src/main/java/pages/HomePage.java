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

    @FindBy(id = "global-user-trigger")
    private WebElement userIconButton;

    @FindBy(css = "li[class*='user hover'] li.display-user")
    private WebElement nameInUserContainer;

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
        switchToIframe(loginFrame);

        return new LoginPage(getDriver());
    }

    /**
     * Click on user icon button
     */
    public void clickUserIconButton(){
        click(userIconButton);
    }
    
    /**
     * Get text displayed in user container
     * @return String name
     */
    public String getNameInUserContainer(){
        return nameInUserContainer.getText();
    }
}

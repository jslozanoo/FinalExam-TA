package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page representing main page obtained after login or create an account.
 * @author js.lozano
 */
public class MainPage extends BasePage{

    @FindBy(linkText = "Watch")
    private WebElement watchLink;

    @FindBy(id = "global-user-trigger")
    private WebElement userIconButton;

    @FindBy(css = "li[class*='user hover'] li.display-user")
    private WebElement nameInUserContainer;

    @FindBy(linkText = "ESPN Profile")
    private WebElement espnProfileButton;

    @FindBy(linkText = "Log Out")
    private WebElement logoutButton;

    /**
     * Constructor
     *
     * @param driver WebDriver
     */
    public MainPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Go to watch page.
     * @return WatchPage {@link WatchPage}
     */
    public WatchPage goToWatchPage(){
        click(watchLink);

        return new WatchPage(getDriver());
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

    /**
     * Click logout button to return home page
     * @return HomePage {@link HomePage}
     */
    public HomePage logout(){
        click(logoutButton);
        isElementInvisible(espnProfileButton);

        return new HomePage(getDriver());
    }
}

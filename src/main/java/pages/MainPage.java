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
}

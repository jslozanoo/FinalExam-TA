package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Main page. Elements are located with Round-Trip option selected
 * @author js.lozano
 */
public class MainPage extends BasePage{

    @FindBy(linkText = "Link back to home page")
    private WebElement logoLink;

    @FindBy(css = "div[id*='ida_regreso'] input[id*='pbOrigen']")
    private WebElement fromDestinationInput;

    @FindBy(css = "div[id*='ida_regreso'] input[id*='pbDestino']")
    private WebElement toDestinationInput;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLogoVisible(){
        return isElementAvailable(logoLink);
    }

    public void setFromDestination(String destination){
        sendKeys(fromDestinationInput, destination);
    }

    public void setToDestination(String toDestination){
        sendKeys(toDestinationInput, toDestination);
    }
}

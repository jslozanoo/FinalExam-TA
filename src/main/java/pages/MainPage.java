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
    private WebElement originDestinationInput;

    @FindBy(css = "div[id*='ida_regreso'] div[data-source*='origin'] div[class*='countries']")
    private WebElement originCountriesSelectorContainer;

    @FindBy(css = "div[id*='ida_regreso'] div[data-source*='origin'] div[class*='countries'] li[data-terminal='LAS']")
    private WebElement selectLasVegasDestinationButton;

    @FindBy(css = "div[id*='ida_regreso'] input[id*='pbDestino']")
    private WebElement arrivalDestinationInput;

    /**
     * Constructor
     * @param driver WebDriver
     */
    public MainPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Wait main logo visibility
     * @return boolean
     */
    public boolean isLogoVisible(){
        return isElementAvailable(logoLink);
    }

    /**
     * Send keys to origin destination box.
     * @param destination origin place
     */
    public void setOriginDestination(String destination){
        sendKeys(originDestinationInput, destination);
    }

    /**
     * Send keys to arrival destination box
     * @param toDestination
     */
    public void setArrivalDestination(String toDestination){
        sendKeys(arrivalDestinationInput, toDestination);
    }

    /**
     * Select las vegas as origin destination
     */
    public void clickLasVegasDestinationButton(){
        isElementAvailable(originCountriesSelectorContainer);
        click(selectLasVegasDestinationButton);
    }
}

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

    @FindBy(css = "div[id*='ida_regreso'] div[data-source*='destination'] div[class*='countries']")
    private WebElement arrivalCountriesSelectorContainer;

    @FindBy(css = "div[id*='ida_regreso'] div[data-source*='destination'] div[class*='countries'] li[data-terminal='SAL']")
    private WebElement selectSanSalvadorDestinationButton;

    @FindBy(css = "div[id*='ida_regreso'] div[data-source*='origin'] div[class*='countries'] li[data-terminal='LAS']")
    private WebElement selectLasVegasDestinationButton;

    @FindBy(css = "div[id*='ida_regreso'] input[id*='pbDestino']")
    private WebElement arrivalDestinationInput;

    @FindBy(css = "div[id*='ida_regreso'] div[class*='pasajero-container'] span i")
    private WebElement choosePassengersButton;

    @FindBy(css = "div[id*='ida_regreso'] div[data-name*='pbPasajeros']")
    private WebElement choosePassengerContainer;

    @FindBy(css = "div[id*='ida_regreso'] div[class*='plus'][data-property='adults']")
    private WebElement addPassengerButton;

    @FindBy(css = "div[id*='ida_regreso'] input[name='pbFechaIda']")
    private WebElement chooseOriginDate;

    @FindBy(css = "div[id*='ida_regreso'] div[class*='calendar-container'] ")
    private WebElement calendarContainer;

    @FindBy(css = "div[id*='ida_regreso'] div[data-day='2022.6.18']")
    private WebElement juneEighteenDate;

    @FindBy(css = "div[id*='ida_regreso'] input[name='pbFechaRegreso']")
    private WebElement chooseArrivalDate;

    @FindBy(css = "div[id*='ida_regreso'] div[class*='month-next'] em")
    private WebElement nextMonthButton;

    @FindBy(css = "div[id*='ida_regreso'] div[data-day='2022.8.20']")
    private WebElement augustTwentyDate;

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
     * Select Las Vegas as origin destination
     */
    public void clickLasVegasDestinationButton(){
        isElementAvailable(originCountriesSelectorContainer);
        click(selectLasVegasDestinationButton);
    }

    /**
     * Select San Salvador as arrival destination
     */
    public void clickSanSalvadorDestinationButton() {
        isElementAvailable(arrivalCountriesSelectorContainer);
        click(selectSanSalvadorDestinationButton);
    }

    /**
     * Click choose passengers button
     */
    public void clickChoosePassengersButton(){
        click(choosePassengersButton);
    }

    public void addPassenger(){
        click(addPassengerButton);
    }

    public void chooseDates() {
        click(chooseOriginDate);
        if (isElementAvailable(calendarContainer)){
            click(juneEighteenDate);
        }
        click(chooseArrivalDate);
        if (isElementAvailable(calendarContainer)){
            click(nextMonthButton);
            click(augustTwentyDate);
        }
    }
}

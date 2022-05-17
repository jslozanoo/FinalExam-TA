package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class WatchPage extends BasePage{

    @FindBy(css = "section[class*='Carousel']")
    private List<WebElement> carousels;

    @FindBy(css = "section[class*='Carousel'] div[class*='Header']")
    private List<WebElement> carouselsTitles;

    @FindBy(xpath = "//section[contains(@class, 'Container')]/div[1]//li[contains(@data-carousel-id, '1')]")
    private WebElement secondCardFirstCarousel;

    @FindBy(css = "button[class*='closebtn']")
    private WebElement closeProviderSelectionButton;

    @FindBy(css = "section[class*='contentBox']")
    private WebElement chooseProviderContainer;

    /**
     * Constructor
     *
     * @param driver WebDriver
     */
    public WatchPage(WebDriver driver) {
        super(driver);
    }

    /**
     * True if there are at least one carousel
     * @return Boolean
     */
    public boolean AreCarouselsPresent(){
        log.info("There are " + carousels.size() + " carousels");
        return carousels.size() > 0;
    }

    /**
     * True if there are at least one carousel displayed
     * @return Boolean
     */
    public boolean areCarouselsDisplayed(){
        List<Boolean> isElementPresent = new ArrayList<>();
        carousels.forEach(carousel->{
            isElementPresent.add(carousel.isDisplayed());
        });
        return isElementPresent.contains(true);
    }

    /**
     * Select the second card in the first carrousel
     */
    public void clickSecondCardFirstCarousel(){
        click(secondCardFirstCarousel);
        isElementAvailable(chooseProviderContainer);
    }

    /**
     * True if close button in provider selection window is displayed. False otherwise
     * @return Boolean
     */
    public boolean isCloseProviderButtonDisplayed(){
        return isElementAvailable(closeProviderSelectionButton);
    }

    /**
     * Close choose provider selection window
     */
    public void closeProviderSelection(){
        click(closeProviderSelectionButton);
    }

    /**
     * Go back to home page
     */
    public MainPage goBackToHomePage(){
        log.info("Returning to Main Page");
        goBack();
        return new MainPage(getDriver());
    }
}

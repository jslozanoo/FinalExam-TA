package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Base page class
 * @author js.lozano
 */
public class BasePage {

    private WebDriver driver;
    private WebDriverWait wait;
    protected Logger log = Logger.getLogger(BasePage.class);

    /**
     * Constructor
     * @param driver WebDriver
     */
    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 10);
    }

    /**
     * Wrapper for visibility event. True if element is available, false otherwise.
     * @param element Web element to wait visibility
     * @return boolean
     */
    public boolean isElementAvailable(WebElement element){
        try{
            getWait().until(ExpectedConditions.visibilityOf(element));
            return true;
        }catch (Exception e){
            return false;
        }
    }

    /**
     * Wrapper for invisibility event. True if element is invisible, false otherwise
     * @param element WebElement
     * @return Boolean
     */
    public boolean isElementInvisible(WebElement element){
        try{
            getWait().until(ExpectedConditions.invisibilityOf(element));
            return true;
        }catch (Exception e){
            return false;
        }
    }

    /**
     * Wrapper for clickable event. True if element is clickable, false otherwise.
     * @param element Web element to wait clickable
     * @return boolean
     */
    public boolean isElementClickable(WebElement element){
        try{
            getWait().until(ExpectedConditions.elementToBeClickable(element));
            return true;
        }catch (Exception e){
            return false;
        }
    }

    /**
     * Wrapper for click event
     * @param element Web element to click
     */
    public void click(WebElement element){
         if(isElementClickable(element)){
             element.click();
         }
    }

    /**
     * Send keys to element until its visible.
     * @param element Web element to send keys
     * @param keys String to send
     */
    public void sendKeys(WebElement element, String keys){
        if (isElementClickable(element)){
            element.sendKeys(keys);
        }
    }

    /**
     * Scroll down by pixels.
     */
    public void scrollDownByPixels(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)" ,"");
    }

    /**
     * Scroll down until element visibility
     * @param element Web element
     */
    public void scrollDownUntilElementVisibility(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    /**
     * Scroll down to the bottom of the page
     */
    public void scrollDownToBottom(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    /**
     * Go back to the previous page
     */
    public void goBack(){
        getDriver().navigate().back();
    }

    /**
     * Switch to Iframe
     * @param iframe WebElement Iframe
     */
    public void switchToIframe(WebElement iframe){
        if (isElementAvailable(iframe)){
            getDriver().switchTo().frame(iframe);
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }
}

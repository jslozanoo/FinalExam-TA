package pages;

import org.apache.log4j.Logger;
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
    protected WebDriverWait wait;
    protected Logger log = Logger.getLogger(BasePage.class);

    /**
     * Constructor
     * @param driver WebDriver
     */
    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 15);
    }

    /**
     * True if element is available, false otherwise.
     * @param element WebElement
     * @return boolean
     */
    public boolean isElementVisible(WebElement element){
        try{
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        }catch (Exception e){
            return false;
        }
    }

    /**
     * True if element is clickable, false otherwise.
     * @param element WebElement
     * @return boolean
     */
    public boolean isElementClickable(WebElement element){
        try{
            wait.until(ExpectedConditions.elementToBeClickable(element));
            return true;
        }catch (Exception e){
            return false;
        }
    }

    /**
     * Click WebElement
     * @param element WebElement
     */
    public void click(WebElement element){
         if(isElementClickable(element)){
             element.click();
         }
    }
}
